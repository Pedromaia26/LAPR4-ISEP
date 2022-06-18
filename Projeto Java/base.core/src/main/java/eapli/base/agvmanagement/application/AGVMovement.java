package eapli.base.agvmanagement.application;

import eapli.base.Warehouse.domain.*;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.domain.Battery;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.dashboardmanagement.DashboardAgvManagerService;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.OrderLine;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.repositories.OrderLineRepository;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.domain.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;


public class AGVMovement{

    private static final int SAVING_MODE = 20;
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();
    private final OrderRepository orderRepository = PersistenceContext.repositories().orders();
    private final OrderLineRepository orderLineRepository = PersistenceContext.repositories().orderlines();
    private static final Logger LOGGER = LogManager.getLogger(AGVMovement.class);


    private static final int VELOCITY = 1000;
    private static final int VELOCITY_SAVING_MODE = 3000;
    private static final double BATTERY_DRAIN_SAVING_MODE = 0.2d;
    private static final int BATTERY_DRAIN = 1;
    private static final int AVOID_COLLISION_2_SQUARES = 2000;
    private static final int AVOID_COLLISION_3_SQUARES = 1500;
    private static final int SLEEP_PICK_UP = 2000;
    private static final int WAITING_ON_AGV_DOCK = 1200;


    private static int length;
    private static int width;
    private static int square;
    private static List<String> agvDocks = new ArrayList<>();
    private static List<Long> aisles = new ArrayList<>();
    private static List<String> agvs = new ArrayList<>();


    public void main(String id, Methods methods) throws IOException {

        List<Integer> positionProduct = new ArrayList<>();
        Product product = new Product();

        AGV agv = agvRepository.findById(id);

        ProductOrder productOrder = orderRepository.findOrderByAGVId(id);

        List<String> accessibility = new ArrayList<>();
        AGVDock agvDock = agv.AgvDock();
        int startW = Integer.parseInt(String.valueOf(agvDock.AgvDockBeginWSquare().BeginWSquare() - 1));
        int startL = Integer.parseInt(String.valueOf(agvDock.AgvDockBeginLSquare().BeginLSquare() - 1));

        int[] start;
        int count = 0;
        int count2 = 0;
        int endW, endL;

        int[] positions = new int[2];
        positions[0] = startW;
        positions[1] = startL;

        for (OrderLine ol: orderLineRepository.findOrderLinesByOrderIdNotPickedUp(productOrder.identity())){
            product = ol.Product();

            ShelfIdentifier shelf = product.Shelf().ShelfIdentifier();
            Section section = shelf.Section();
            Aisle aisle = section.identity().Aisle();
            accessibility.add(aisle.Accessibility());

            if (aisle.Accessibility().equalsIgnoreCase("w-") || aisle.Accessibility().equalsIgnoreCase("w+")){
                endW = Integer.parseInt(String.valueOf(section.RowBeginWSquare().BeginWSquare()-1));
                int endL1 = Integer.parseInt(String.valueOf(section.RowBeginLSquare().BeginLSquare()-1));
                int endL2 = Integer.parseInt(String.valueOf(section.RowEndLSquare().EndLSquare()-1));
                endL = (int) ((Math.random() * (endL2 - endL1)) + endL1);
            }else{
                endL = Integer.parseInt(String.valueOf(section.RowBeginLSquare().BeginLSquare()-1));
                int endW1 = Integer.parseInt(String.valueOf(section.RowBeginWSquare().BeginWSquare()-1));
                int endW2 = Integer.parseInt(String.valueOf(section.RowEndWSquare().EndWSquare()-1));
                endW = (int) ((Math.random() * (endW2 - endW1)) + endW1);
            }

            positionProduct.add(endW);
            positionProduct.add(endL);

            count++;
        }
        List<OrderLine> orderLines= (List<OrderLine>) orderLineRepository.findOrderLinesByOrderIdNotPickedUp(productOrder.identity());

        start = positions;

        ShortestPath shortestPath = new ShortestPath(methods, start, positionProduct, accessibility, agv,orderLines);
        Thread t = new Thread(shortestPath);
        t.start();

    }

    static class ShortestPath extends Thread {


        private final AGVRepository agvRepository = PersistenceContext.repositories().agv();
        private final FreeAGVService freeAGVService = new FreeAGVService();
        private final RechargingAGVService rechargingAGVService = new RechargingAGVService();
        private UpdateStatusFreeService updateStatusFreeService = new UpdateStatusFreeService();
        private final OrderLineRepository orderlineRepository = PersistenceContext.repositories().orderlines();
        private final AssignAGVService assignAGVService = new AssignAGVService();
        private final RechargingAGVFinishedOrderService rechargingAGVFinishedOrderService = new RechargingAGVFinishedOrderService();

        int [] start;
        int [] end = new int[2];
        int [] newStart = new int[2];
        List<String> accessibility;
        List<Integer> positionProduct;
        Methods methods;
        AGV agv;
        double battery;
        List<OrderLine> orderLines;

        public ShortestPath(Methods methods, int[] start, List<Integer> positionProduct, List<String> accessibility, AGV agv, List<OrderLine> orderLines) {
            this.methods = methods;
            this.start = start.clone();
            this.positionProduct = positionProduct;
            this.accessibility = accessibility;
            this.agv = agv;
            this.orderLines=orderLines;
        }


        @Override
        public void run () {
            boolean recharge = false;
            int i;
            try {
                methods.addStartPositions(start);
                battery = agv.Battery().battery();
                newStart[0] = start[0];
                newStart[1] = start[1];
                int count = 0;
                for (i = 0; i < positionProduct.size(); i+=2){
                    end[0] = positionProduct.get(i);
                    end[1] = positionProduct.get(i+1);
                    methods.checkAccessibility(accessibility.get(count), end);
                    battery = methods.doCycle(newStart, end, battery, agv, false);
                    newStart[0] = end[0];
                    newStart[1] = end[1];
                    OrderLine orderLine=orderLines.get(count);
                    orderLine.modifyProductStatus(2);
                    orderlineRepository.save(orderLine);
                    count++;
                    Thread.sleep(SLEEP_PICK_UP); // depois de ir buscar um produto espera um pouco para simular a recolha
                    if (battery < SAVING_MODE){
                        battery-=BATTERY_DRAIN_SAVING_MODE;
                        recharge = true;
                        break;
                    }else{
                        battery-=BATTERY_DRAIN;
                    }
                }
                battery = methods.doCycle(end, start, battery, agv, true);
                if (battery < SAVING_MODE){
                    recharge = true;
                }
                if (recharge && i < positionProduct.size()-2) {
                    rechargingAGVService.rechargingAGVService(agv.identity().AgvIdentifier());
                    // recharge
                }else if (recharge){
                    rechargingAGVFinishedOrderService.rechargingAGVFinishedOrderService(agv.identity().AgvIdentifier());
                }else{
                    freeAGVService.freeAgvService(agv.identity().AgvIdentifier());
                }
                Thread.sleep(WAITING_ON_AGV_DOCK);
                assignAGVService.assignAGVService();
                //updateStatusFreeService.updateStatusFreeService(agv.identity().AgvIdentifier());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


     public static class Methods{


         private boolean flag = true;
        private final AGVRepository agvRepository = PersistenceContext.repositories().agv();
        int[][] matrix;
        int sleep;
        List<Position> positions = new ArrayList<>();
        private DashboardAgvManagerService dashboardAgvManagerService = new DashboardAgvManagerService();

        public Methods(){

            String string = dashboardAgvManagerService.assignAGVService();
            getWarehousePlantMatrix(string);


           /*for (int i = 0; i < 18; i++) {
                for (int j = 0; j < 20; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }*/

            this.matrix = matrix.clone();
        }

        public int[] shortestPath(int[][] matrix, int[] start, int[] end, boolean ver) throws InterruptedException {
            int beginL = start[0], beginC = start[1];
            int endL = end[0], endC = end[1];
            //if start or end value is 0, return
            if (matrix[beginL][beginC] == 0 || matrix[endL][endC] == 0) {
                LOGGER.debug("There is no path.");
                return null;
            }
            //initialize the cells
            int m = matrix.length;
            int n = matrix[0].length;
            Position[][] cells = new Position[m][n];


            synchronized (this) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (matrix[i][j] != 0 && matrix[i][j] != 3 && (matrix[i][j] != 9)) {
                            cells[i][j] = new Position(i, j, Integer.MAX_VALUE, null);
                        }

                        if (matrix[i][j] == 9 && start[0] + 1 == i && start[1] == j) {
                            LOGGER.debug("AGV below");
                            while (flag) {
                                try {
                                    flag = false;
                                    notifyAll();
                                    wait();
                                } catch (Exception e) {
                                    LOGGER.debug(e.getMessage() + "\n");
                                    e.printStackTrace();
                                }
                            }
                            flag = true;
                        } else if (matrix[i][j] == 9 && start[0] + 2 == i && start[1] == j) {
                            LOGGER.debug("AGV below 2 squares");
                            sleep = AVOID_COLLISION_2_SQUARES;
                        } else if (matrix[i][j] == 9 && start[0] + 3 == i && start[1] == j) {
                            LOGGER.debug("AGV below 3 squares");
                            sleep = AVOID_COLLISION_3_SQUARES;
                        }

                        if (matrix[i][j] == 9 && start[0] - 1 == i && start[1] == j) {
                            LOGGER.debug("AGV up");
                            while (flag) {
                                try {
                                    flag = false;
                                    notifyAll();
                                    wait();
                                } catch (Exception e) {
                                    LOGGER.debug(e.getMessage() + "\n");
                                    e.printStackTrace();
                                }
                            }
                            flag = true;
                        } else if (matrix[i][j] == 9 && start[0] - 2 == i && start[1] == j) {
                            LOGGER.debug("AGV up 2 squares");
                            sleep = AVOID_COLLISION_2_SQUARES;
                        } else if (matrix[i][j] == 9 && start[0] - 3 == i && start[1] == j) {
                            LOGGER.debug("AGV up 3 squares");
                            sleep = AVOID_COLLISION_3_SQUARES;
                        }

                        if (matrix[i][j] == 9 && start[0] == i && start[1] + 1 == j) {
                            LOGGER.debug("AGV right");
                            while (flag) {
                                try {
                                    flag = false;
                                    notifyAll();
                                    wait();
                                } catch (Exception e) {
                                    LOGGER.debug(e.getMessage() + "\n");
                                    e.printStackTrace();
                                }
                            }
                            flag = true;
                        } else if (matrix[i][j] == 9 && start[0] == i && start[1] + 2 == j) {
                            LOGGER.debug("AGV right 2 squares");
                            sleep = AVOID_COLLISION_2_SQUARES;
                        } else if (matrix[i][j] == 9 && start[0] == i && start[1] + 3 == j) {
                            LOGGER.debug("AGV right 3 squares");
                            sleep = AVOID_COLLISION_3_SQUARES;
                        }

                        if (matrix[i][j] == 9 && start[0] == i && start[1] - 1 == j) {
                            LOGGER.debug("AGV left");
                            while (flag) {
                                try {
                                    flag = false;
                                    notifyAll();
                                    wait();
                                } catch (Exception e) {
                                    LOGGER.debug(e.getMessage() + "\n");
                                    e.printStackTrace();
                                }
                            }
                            flag = true;
                        } else if (matrix[i][j] == 9 && start[0] == i && start[1] - 2 == j) {
                            LOGGER.debug("AGV left 2 squares");
                            sleep = AVOID_COLLISION_2_SQUARES;
                        } else if (matrix[i][j] == 9 && start[0] == i && start[1] - 3 == j) {
                            LOGGER.debug("AGV left 3 squares");
                            sleep = AVOID_COLLISION_3_SQUARES;
                        }
                    }
                }
            }


                LinkedList<Position> queue = new LinkedList<>();
                cells[beginL][beginC]= new Position(beginL, beginC, Integer.MAX_VALUE, null);

                if(!ver){
                    for (int k=0; k< positions.size();k++){
                        if(beginC != positions.get(k).c || beginL != positions.get(k).l){
                            cells[positions.get(k).l][positions.get(k).c]=null;
                        }
                    }
                }


                Position src = cells[beginL][beginC];
                src.dist = 0;
                queue.add(src);
                Position dest = null;
                Position p;

                while ((p = queue.poll()) != null) {
                    //find destination
                    if (p.l == endL && p.c == endC) {
                        dest = p;
                        break;
                    }
                    // up
                    visit(cells, queue, p.l - 1, p.c, p);
                    // down
                    visit(cells, queue, p.l + 1, p.c, p);
                    // left
                    visit(cells, queue, p.l, p.c - 1, p);
                    // right
                    visit(cells, queue, p.l, p.c + 1, p);
                }

        /*for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                System.out.printf(cells[i][j] + " ") ;
            }
            System.out.println();
        }*/
                //compose the path if path exists

            synchronized (this){
                int[] array = new int[2];
                if (dest == null) {
                    LOGGER.debug("there is no path");
                    while (flag) {
                        try {
                            wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    flag = true;
                    array=shortestPath(matrix, start, end,ver);
                } else {
                    LinkedList<Position> path = new LinkedList<>();
                    p = dest;
                    do {
                        path.addFirst(p);
                    } while ((p = p.prev) != null);
                    array[0] = path.get(1).l;
                    array[1] = path.get(1).c;
                }
                return array;
            }
        }

        public void visit (Position[][]cells, LinkedList < Position > queue,int l, int c, Position parent){
            if (l < 0 || l >= cells.length || c < 0 || c >= cells[0].length || cells[l][c] == null) {
                return;
            }

            int dist = parent.dist + 1;
            Position p = cells[l][c];
            if (dist < p.dist) {
                p.dist = dist;
                p.prev = parent;
                queue.add(p);
            }
        }

        public double doCycle(int[] start, int[] end, double battery, AGV agv, boolean ver) throws InterruptedException {
            int oldStartW;
            int oldStartL;
            double batteryAtTheMoment = battery;
            do {
                synchronized (this) {
                    if (batteryAtTheMoment < SAVING_MODE) {
                        sleep = VELOCITY_SAVING_MODE;
                    } else {
                        sleep = VELOCITY;
                    }
                    oldStartW = start[0];
                    oldStartL = start[1];
                    flag = false;
                    notifyAll();
                }
                    start = shortestPath(matrix, start, end, ver);

                synchronized (this){
                    matrix[oldStartW][oldStartL] = 1;
                    matrix[start[0]][start[1]] = 9;

                   /*for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[0].length; j++) {
                            if (matrix[i][j] == 9){
                                System.out.print("\033[0;33m" + matrix[i][j] + " \033[0m");
                            }else if (matrix[i][j] == 0){
                                System.out.print("\033[0;32m" + matrix[i][j] + " \033[0m");
                            }else{
                                System.out.print(matrix[i][j] + " ");
                            }

                        }
                        System.out.println();
                    }*/

                   LOGGER.debug("\n");
                if (batteryAtTheMoment < SAVING_MODE){
                    batteryAtTheMoment-=BATTERY_DRAIN_SAVING_MODE;
                }else{
                    batteryAtTheMoment-=BATTERY_DRAIN;
                }

                agv.modifyBattery(new Battery(batteryAtTheMoment));
                agvRepository.save(agv);
                }
                Thread.sleep(sleep);
            } while (start[0] != end[0] || start[1] != end[1]);

            return batteryAtTheMoment;
        }

        public synchronized void checkAccessibility(String accessibility, int [] end){
           // trocamos w- com w+ por causa dum erro PORQUE ESTAVAMOS COM SONO
            if (accessibility.equalsIgnoreCase("w-")){
                end[0]-=1;
            }else if (accessibility.equalsIgnoreCase("w+")){
                end[0]+=1;
            }else if(accessibility.equalsIgnoreCase("l-")){
                end[1]-=1;
            }else if (accessibility.equalsIgnoreCase("l+")){
                end[1]+=1;
            }
        }

        public synchronized void getWarehousePlantMatrix(String html) {

            changeDimensions(html.substring(12));
            matrix = new int[length/square][width/square];
            boolean agvD = false;
            boolean isAisle = false;
            boolean isAislelimit = false;
            String agvId = null;
            if (square != 0) {
                for (int j = 0; j < (length / square); j++) {
                    for (int i = 0; i < (width / square); i++) {
                        agvD = false;
                        isAisle = false;
                        for (int k = 0; k < agvDocks.size(); k+=3){
                            if (Long.parseLong(agvDocks.get(k))-1 == i && Long.parseLong(agvDocks.get(k+1))-1 == j){
                                agvD = true;
                                agvId = agvDocks.get(k+2);
                            }
                        }
                        for (int l = 0; l < aisles.size(); l+=6){
                            if (aisles.get(l)-1 <= i && aisles.get(l+4)-1 >= i && ((aisles.get(l+2)-1 <= j  && aisles.get(l+5)-1 >= j) || (aisles.get(l+2)-1 >= j  && aisles.get(l+5)-1 <= j))){
                                isAisle = true;
                            }
                        }
                        if (agvD){
                           matrix[j][i] = 3;
                            if (agvs.contains(agvId)){
                                matrix[j][i] = 9;
                            }
                        }
                        else if (isAisle){
                          matrix[j][i] = 0;
                            }
                        else{
                            matrix[j][i] = 1;
                        }
                    }
                }
            }
        }

        public synchronized void changeDimensions(String incomingDimensions){
            String[] res1 = incomingDimensions.split("[,]", 0);
            width= Integer.parseInt(res1[0]);
            length = Integer.parseInt(res1[1]);
            square = Integer.parseInt(res1[2]);
            String[] res2 = incomingDimensions.split("[;]", 0);
            for (int i = 0; i < res2.length-1; i++){
                String[] agvDock = res2[i+1].split("[,]", 0);
                agvDocks.add(agvDock[0]);
                agvDocks.add(agvDock[1]);
                agvDocks.add(agvDock[2]);
            }
            String[] res3 = incomingDimensions.split("[/]", 0);
            for (int i = 0; i < res3.length-1; i++){
                String[] aisle = res3[i+1].split("[,]", 0);
                aisles.add(Long.parseLong(aisle[0]));
                aisles.add(Long.parseLong(aisle[1]));
                aisles.add(Long.parseLong(aisle[2]));
                aisles.add(Long.parseLong(aisle[3]));
                aisles.add(Long.parseLong(aisle[4]));
                aisles.add(Long.parseLong(aisle[5]));
            }
            String[] res4 = incomingDimensions.split("[?]", 0);
            for (int i = 0; i < res4.length-1; i++){
                String[] agvDock = res4[i+1].split("[,]", 0);
                agvs.add(agvDock[0]);
            }
        }

        public int[][] Matrix(){
            return matrix;
        }

        public void addStartPositions(int [] start){
            positions.add(new Position(start[0],start[1],Integer.MAX_VALUE,null));
        }


    }


}


