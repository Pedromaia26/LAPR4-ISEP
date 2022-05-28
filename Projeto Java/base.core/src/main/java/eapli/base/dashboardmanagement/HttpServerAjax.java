package eapli.base.dashboardmanagement;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class HttpServerAjax {
    static private final String BASE_FOLDER="base.core/src/main/java/eapli/base/dashboardmanagement/www";
    static private ServerSocket sock;
    static private int PORT = 80;

    public static void main(String args[]) throws Exception {
        Socket cliSock;

        try { sock = new ServerSocket(PORT); }
        catch(IOException ex) {
            System.out.println("Server failed to open local port " + PORT);
            System.exit(1);
        }
        while(true) {
            cliSock=sock.accept();
            HttpAjaxRequest req=new HttpAjaxRequest(cliSock, BASE_FOLDER);
            req.start();
        }
    }
    private static int length;
    private static int width;
    private static int square;
    private static List<String> agvDocks = new ArrayList<>();
    private static List<Long> aisles = new ArrayList<>();
    private static List<String> agvs = new ArrayList<>();

    public static synchronized String getWarehousePlantInHTML() {
        boolean agvD = false;
        boolean isAisle = false;
        boolean isAislelimit = false;
        String agvId = null;
        StringBuilder textHtml = new StringBuilder("<table style=\"border: 1px solid black; margin: auto; border-collapse: collapse;\">");
        if (square != 0) {
            for (int j = 0; j < (length / square); j++) {
                textHtml.append("<tr>");
                for (int i = 0; i < (width / square); i++) {
                    agvD = false;
                    isAisle = false;
                    isAislelimit = false;
                    for (int k = 0; k < agvDocks.size(); k+=3){
                        if (Long.parseLong(agvDocks.get(k))-1 == i && Long.parseLong(agvDocks.get(k+1))-1 == j){
                            agvId = agvDocks.get(k+2);
                            agvD = true;
                        }
                    }
                    for (int l = 0; l < aisles.size(); l+=6){
                        if (aisles.get(l)-1 <= i && aisles.get(l+4)-1 >= i && ((aisles.get(l+2)-1 <= j  && aisles.get(l+5)-1 >= j) || (aisles.get(l+2)-1 >= j  && aisles.get(l+5)-1 <= j))){
                            if (aisles.get(l)-1 <= i && aisles.get(l+4)-1 >= i && ((aisles.get(l+2)-1 <= j  && aisles.get(l+5)-1 == j))){
                                isAislelimit = true;
                            }
                            isAisle = true;
                        }
                    }
                    if (agvD){
                        textHtml.append("<td id=\"");
                        textHtml.append(agvId);
                        if (agvs.contains(agvId)){
                            textHtml.append("\" style=\"border: 1px solid black; width: 40px; height: 40px; background-color: yellow; text-align: center;\">&#9899;</td>");
                        }
                        else{
                            textHtml.append("\" style=\"border: 1px solid black; width: 40px; height: 40px; background-color: yellow; text-align: center;\">&nbsp;</td>");
                        }
                    }
                    else if (isAisle){
                        if (isAislelimit){
                            textHtml.append("<td style=\"border-bottom: 1px solid black; width: 40px; height: 40px; background-color: red; text-align: center;\">&nbsp;</td>");
                        }
                        else{
                            textHtml.append("<td style=\"border: 0px solid black; width: 40px; height: 40px; background-color: red; text-align: center;\">&nbsp;</td>");
                        }
                    }
                    else{
                        textHtml.append("<td style=\"border: 1px solid black; width: 40px; height: 40px; text-align: center;\">&nbsp;</td>");
                    }
                }
                textHtml.append("</tr>");
            }
        }
        textHtml.append("</table>");
        return textHtml.toString();
    }

    public static synchronized void changeDimensions(String incomingDimensions){
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
