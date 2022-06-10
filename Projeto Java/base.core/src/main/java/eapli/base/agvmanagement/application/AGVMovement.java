package eapli.base.agvmanagement.application;

import eapli.base.Warehouse.domain.*;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.dashboardmanagement.DashboardAgvManagerService;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.OrderLine;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.repositories.OrderLineRepository;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;

import java.io.IOException;
import java.util.*;


public class AGVMovement{


    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();
    private final OrderRepository orderRepository = PersistenceContext.repositories().orders();
    private final OrderLineRepository orderLineRepository = PersistenceContext.repositories().orderlines();
    private final ProductRepository productRepository = PersistenceContext.repositories().products();

    private static int length;
    private static int width;
    private static int square;
    private static List<String> agvDocks = new ArrayList<>();
    private static List<Long> aisles = new ArrayList<>();
    private static List<String> agvs = new ArrayList<>();

    public void main(String id, Methods methods) throws IOException {
        Product product = new Product();

        AGV agv = agvRepository.findById(id);

        ProductOrder productOrder = orderRepository.findOrderByAGVId(id);


        for (OrderLine ol: orderLineRepository.findOrderLinesByOrderId(productOrder.identity())){
            product = ol.Product();
            break;
        }

        ShelfIdentifier shelf = product.Shelf().ShelfIdentifier();
        Section section = shelf.Section();
        Aisle aisle = section.identity().Aisle();
        String accessibility = aisle.Accessibility();

        System.out.println(accessibility);



        AGVDock agvDock = agv.AgvDock();
        int startW = Integer.parseInt(String.valueOf(agvDock.AgvDockBeginWSquare().BeginWSquare() - 1));
        System.out.println(startW);
        int startL = Integer.parseInt(String.valueOf(agvDock.AgvDockBeginLSquare().BeginLSquare() - 1));
        System.out.println(startL);
        int endW = Integer.parseInt(String.valueOf(section.RowBeginWSquare().BeginWSquare()-1));
        System.out.println(endW);
        int endL = Integer.parseInt(String.valueOf(section.RowBeginLSquare().BeginLSquare()-1));
        System.out.println(endL);


        int[] start;
        int[] end;

        int[][] positions = new int[6][2];
        positions[0][0] = startW;
        positions[0][1] = startL;
        positions[1][0] = endW;
        positions[1][1] = endL;
        /*positions[2][0] = 12;
        positions[2][1] = 0;
        positions[3][0] = 7;
        positions[3][1] = 7;
        positions[4][0] = 4;
        positions[4][1] = 0;
        positions[5][0] = 17;
        positions[5][1] = 4;*/




        start = positions[0];
        end = positions[1];
        ShortestPath shortestPath = new ShortestPath(methods, start, end, accessibility);
        Thread t = new Thread(shortestPath);
        t.start();

        System.out.println();
    }

    static class ShortestPath extends Thread {
        int [] start;
        int [] end;
        String accessibility;
        Methods methods;

        public ShortestPath(Methods methods, int[] start, int[] end, String accessibility) {
            this.methods = methods;
            this.start = start.clone();
            this.end = end.clone();
            this.accessibility = accessibility;
        }


        @Override
        public void run () {
            try {
                methods.checkAccessibility(accessibility, end);
                methods.doCycle(start, end);
                methods.doCycle(end,start);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


     public static class Methods{

        int[][] matrix;
        int sleep;
        private DashboardAgvManagerService dashboardAgvManagerService = new DashboardAgvManagerService();

        public Methods(){

            String string = dashboardAgvManagerService.assignAGVService();
            getWarehousePlantMatrix(string);


            for (int i = 0; i < 18; i++) {
                for (int j = 0; j < 20; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            this.matrix = matrix.clone();
        }

        public int[] shortestPath(int[][] matrix, int[] start, int[] end){
            int beginL = start[0], beginC = start[1];
            int endL = end[0], endC = end[1];
            //if start or end value is 0, return
            if (matrix[beginL][beginC] == 0 || matrix[endL][endC] == 0) {
                System.out.println("There is no path.");
                return null;
            }
            //initialize the cells
            //int m = matrix.length;
            //int n = matrix[0].length;
            Position[][] cells = new Position[18][20];

            synchronized (this) {

                for (int i = 0; i < 18; i++) {
                    for (int j = 0; j < 20; j++) {
                        if (matrix[i][j] != 0 && matrix[i][j] != 3 && (matrix[i][j] != 9 || (i == endL && j == endC))) {
                            cells[i][j] = new Position(i, j, Integer.MAX_VALUE, null);
                        }

                        if (matrix[i][j] == 9 && start[0] + 1 == i && start[1] == j){
                            System.out.println("AGV below");
                        }else if(matrix[i][j] == 9 && start[0] + 2 == i && start[1] == j){
                            System.out.println("AGV below 2 squares");
                            sleep=3000;
                        }else if(matrix[i][j] == 9 && start[0] + 3 == i && start[1] == j){
                            System.out.println("AGV below 3 squares");
                            sleep=2000;
                        }

                        if (matrix[i][j] == 9 && start[0] - 1 == i && start[1] == j){
                            System.out.println("AGV up");
                        }else if(matrix[i][j] == 9 && start[0] - 2 == i && start[1] == j){
                            System.out.println("AGV up 2 squares");
                            sleep=3000;
                        }else if(matrix[i][j] == 9 && start[0] - 3 == i && start[1] == j){
                            System.out.println("AGV up 3 squares");
                            sleep=2000;
                        }

                        if (matrix[i][j] == 9 && start[0] == i && start[1] + 1 == j){
                            System.out.println("AGV right");
                        }else  if (matrix[i][j] == 9 && start[0] == i && start[1] + 2 == j){
                            System.out.println("AGV right 2 squares");
                            sleep=3000;
                        }else  if (matrix[i][j] == 9 && start[0] == i && start[1] + 3 == j){
                            System.out.println("AGV right 3 squares");
                            sleep=2000;
                        }

                        if (matrix[i][j] == 9 && start[0] == i && start[1] - 1== j){
                            System.out.println("AGV left");
                        }else if (matrix[i][j] == 9 && start[0] == i && start[1] - 2== j){
                            System.out.println("AGV left 2 squares");
                            sleep=3000;
                        }else if (matrix[i][j] == 9 && start[0] == i && start[1] - 3== j){
                            System.out.println("AGV left 3 squares");
                            sleep=2000;
                        }
                    }
                }
                //breadth first search

                LinkedList<Position> queue = new LinkedList<>();
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
                    // moving up

                    visit(cells, queue, p.l - 1, p.c, p);
                    // moving down
                    visit(cells, queue, p.l + 1, p.c, p);
                    // moving left
                    visit(cells, queue, p.l, p.c - 1, p);
                    //moving right
                    visit(cells, queue, p.l, p.c + 1, p);
                }

        /*for (int i = 0; i < 18; i++){
            for (int j = 0; j < 20; j++){
                System.out.printf(cells[i][j] + " ") ;
            }
            System.out.println();
        }*/
                //compose the path if path exists
                if (dest == null) {
                    System.out.println("there is no path.");
                    return null;
                } else {
                    LinkedList<Position> path = new LinkedList<>();
                    p = dest;
                    do {
                        path.addFirst(p);
                    } while ((p = p.prev) != null);
                    //System.out.println(path);
                    int[] array = new int[2];
                    array[0] = path.get(1).l;
                    array[1] = path.get(1).c;
                    return array;
                }
            }

        }

        //function to update cell visiting status, Time O(1), Space O(1)
        public synchronized void visit (Position[][]cells, LinkedList < Position > queue,int l, int c, Position parent){
            //out of boundary
            if (l < 0 || l >= cells.length || c < 0 || c >= cells[0].length || cells[l][c] == null) {
                return;
            }
            //update distance, and previous node
            int dist = parent.dist + 1;
            Position p = cells[l][c];
            if (dist < p.dist) {
                p.dist = dist;
                p.prev = parent;
                queue.add(p);
            }
        }

        public void doCycle(int[] start, int[] end) throws InterruptedException {
            do {
                synchronized (this){
                    sleep=1000;
                    matrix[start[0]][start[1]] = 5;
                    start = shortestPath(matrix, start, end);

                    matrix[start[0]][start[1]] = 9;
                    for (int i = 0; i < 18; i++) {
                        for (int j = 0; j < 20; j++) {
                            if (matrix[i][j] == 9){
                                System.out.printf("\033[0;33m" + matrix[i][j] + " \033[0m");
                            }else if (matrix[i][j] == 0){
                                System.out.printf("\033[0;31m" + matrix[i][j] + " \033[0m");
                            }else{
                                System.out.print(matrix[i][j] + " ");
                            }

                        }
                        System.out.println();
                    }
                    System.out.println();
                }
                System.out.println(sleep);
                Thread.sleep(sleep);
            } while (start[0] != end[0] || start[1] != end[1]);


        }

        public synchronized void checkAccessibility(String accessibility, int [] end){
           // trocamos w- com w+ por causa dum erro PORQUE ESTAVAMOS COM SONO
            if (accessibility.equalsIgnoreCase("w-")){
                end[0]-=1;
            }else if (accessibility.equalsIgnoreCase("w+")){
                end[0]+=1;
            }else if(accessibility.equalsIgnoreCase("l+")){
                end[1]-=1;
            }else if (accessibility.equalsIgnoreCase("l-")){
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
                            }
                        }
                        for (int l = 0; l < aisles.size(); l+=6){
                            if (aisles.get(l)-1 <= i && aisles.get(l+4)-1 >= i && ((aisles.get(l+2)-1 <= j  && aisles.get(l+5)-1 >= j) || (aisles.get(l+2)-1 >= j  && aisles.get(l+5)-1 <= j))){
                                isAisle = true;
                            }
                        }
                        if (agvD){
                           matrix[j][i] = 3;
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
    }


}


