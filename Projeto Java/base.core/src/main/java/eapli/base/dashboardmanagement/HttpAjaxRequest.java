package eapli.base.dashboardmanagement;

import java.io.*;
import java.net.Socket;

public class HttpAjaxRequest extends Thread {
	String baseFolder;
	Socket sock;
	DataInputStream inS;
	DataOutputStream outS;
    
	public HttpAjaxRequest(Socket s, String f) throws IOException {
		baseFolder=f; sock=s;
	}
    
	public void run() {
		try {
			outS = new DataOutputStream(sock.getOutputStream());
			inS = new DataInputStream(sock.getInputStream());
		} catch(IOException ex) { System.out.println("Thread error on data streams creation"); }
		try {
			HTTPmessage request = null;
			try {
				request = new HTTPmessage(inS);
			} catch (IOException e) {
				e.printStackTrace();
			}
			HTTPmessage response = new HTTPmessage();

			if(request.getMethod().equals("GET")) {
				if(request.getURI().equals("/warehouse")) {
					response.setContentFromString(
							HttpServerAjax.getWarehousePlantInHTML(), "text/html");
					response.setResponseStatus("200 Ok");
				}
				else {
					String fullname=baseFolder + "/";
					if(request.getURI().equals("/")) fullname=fullname+"index.html";
					else{
						fullname=baseFolder;
						fullname=fullname+request.getURI();
					}
					if(response.setContentFromFile(fullname)) {
						response.setResponseStatus("200 Ok");
					}
					else {
						response.setContentFromString(
								"<html><body><h1>404 File not found</h1></body></html>",
								"text/html");
						response.setResponseStatus("404 Not Found");
					}
				}
			}
			else { // NOT GET
				if(request.getMethod().equals("PUT")
						&& request.getURI().startsWith("/dimensions/")) {
					HttpServerAjax.changeDimensions(request.getURI().substring(12));
					response.setResponseStatus("200 Ok");
				}
				else {
					response.setContentFromString(
							"<html><body><h1>ERROR: 405 Method Not Allowed</h1></body></html>",
							"text/html");
					response.setResponseStatus("405 Method Not Allowed");
				}
			}
			response.send(outS);
			} catch (IOException e) {
				e.printStackTrace();
			}
		try { sock.close();}
		catch(IOException ex) { System.out.println("CLOSE IOException"); }
		}
	}

