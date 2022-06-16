package eapli.base.dashboardmanagement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class HttpServerAjax {
    static private final String BASE_FOLDER="base.core/src/main/java/eapli/base/dashboardmanagement/www";
    static private SSLServerSocket sock;
    static private int PORT = 8000;
    private static final String TRUSTED_STORE = "certificates/httpserver.jks";
    private static final String KEYSTORE_PASS = "Password1";
    private static final Logger LOGGER = LogManager.getLogger(HttpServerAjax.class);


    public static void main(String args[]) throws Exception {
        SSLSocket cliSock;


       //Trust the cert provided by authorized clients

        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);


        //Use this certificate and private key as Server certificate
        System.setProperty("javax.net.ssl.keyStore",TRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);





        try {
            SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sock = (SSLServerSocket) sslF.createServerSocket(PORT);

        }
        catch(IOException ex) {
            LOGGER.debug("Server failed to open local port " + PORT + "\n");
            System.exit(1);
        }
      /*      Desktop desktop = java.awt.Desktop.getDesktop();
        try {
            URI url = new URI ("https://127.0.0.1:8000/");
            desktop.browse(url);
        }catch ( URISyntaxException e){
            System.out.println("Error openimg the browser");
        }*/


        while(true) {

            cliSock= (SSLSocket) sock.accept();
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

    public static synchronized String getWarehousePlantInHTML(String html) {

        changeDimensions(html.substring(12));

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

    public static synchronized String getWarehouseSharedMemory(String html) {

        List<Integer> list = new ArrayList<>();
        list = parse(html);



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
                        if (traverse(list, j, i)){
                            textHtml.append("\" style=\"border: 1px solid black; width: 40px; height: 40px; background-color: yellow; text-align: center;\">&#9899;</td>");
                        }
                        else{
                            textHtml.append("\" style=\"border: 1px solid black; width: 40px; height: 40px; background-color: yellow; text-align: center;\">&nbsp;</td>");
                        }
                    } else if (isAisle) {
                        if (isAislelimit) {
                            textHtml.append("<td style=\"border-bottom: 1px solid black; width: 40px; height: 40px; background-color: red; text-align: center;\">&nbsp;</td>");
                        } else {
                            textHtml.append("<td style=\"border: 0px solid black; width: 40px; height: 40px; background-color: red; text-align: center;\">&nbsp;</td>");
                        }
                    }else if (traverse(list, j, i)){
                        textHtml.append("<td id=\"");
                        textHtml.append(agvId);
                        textHtml.append("\" style=\"border: 1px solid black; width: 40px; height: 40px; text-align: center;\">&#9899;</td>");
                    } else {
                        textHtml.append("<td style=\"border: 1px solid black; width: 40px; height: 40px; text-align: center;\">&nbsp;</td>");
                    }

                }
                textHtml.append("</tr>");
            }
        }
        textHtml.append("</table>");
        return textHtml.toString();
    }

    public static synchronized List<Integer> parse(String matrix){
        String[] res1 = matrix.split(";");
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < res1.length; i++){
            String[] res2 = res1[i].split(",");
            list.add(Integer.parseInt(res2[0]));
            list.add(Integer.parseInt(res2[1]));
        }

        return list;
    }

    public static synchronized boolean traverse(List<Integer> list, int j, int i){

        for (int k = 0; k < list.size(); k+=2){
            if (list.get(k) == j && list.get(k+1) == i){
                return true;
            }
        }
        return false;
    }
}
