package eapli.base.dashboardmanagement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLSocket;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;

public class HttpAjaxRequest extends Thread {
	String baseFolder;
	SSLSocket sock;
	DataInputStream inS;
	DataOutputStream outS;
	private static final Logger LOGGER = LogManager.getLogger(HttpAjaxRequest.class);
	private static final DashboardAgvManagerService service = new DashboardAgvManagerService();

	public HttpAjaxRequest(SSLSocket s, String f) throws IOException {
		baseFolder = f;
		sock = s;
	}

	public void run() {
		try {
			outS = new DataOutputStream(sock.getOutputStream());
			inS = new DataInputStream(sock.getInputStream());


		} catch (IOException ex) {
			System.out.println("Thread error on data streams creation");
		}
		try {

				HTTPmessage request =  new HTTPmessage(inS);
				HTTPmessage response = new HTTPmessage();


				if (request.getMethod().equals("GET")) {
					if (request.getURI().equals("/warehouse")) {

						String html = service.assignAGVService();
						response.setContentFromString(
								HttpServerAjax.getWarehousePlantInHTML(html), "text/html");

						response.setResponseStatus("200 Ok");
					} else {

						String fullname = baseFolder + "/";
						if (request.getURI().equals("/")) fullname = fullname + "index.html";
						else {
							fullname = fullname + request.getURI();
						}
						if (response.setContentFromFile(fullname)) {
							response.setResponseStatus("200 Ok");
						} else {
							response.setContentFromString(
									"<html><body><h1>404 File not found</h1></body></html>",
									"text/html");
							response.setResponseStatus("404 Not Found");
						}
					}
					response.send(outS);
				} else { // NOT GET

					response.setContentFromString(
							"<html><body><h1>ERROR: 405 Method Not Allowed</h1></body></html>",
							"text/html");
					response.setResponseStatus("405 Method Not Allowed");

					response.send(outS);
				}


			} catch (IOException e) {
			System.out.println(e.getMessage());
			}
			try {
				sock.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}


	}
}


