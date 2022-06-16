package eapli.base.dashboardmanagement;

import eapli.base.agvmanagement.application.RequestSharedMemoryService;
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
	private static final RequestSharedMemoryService requestSharedMemoryService = new RequestSharedMemoryService();


	public HttpAjaxRequest(SSLSocket s, String f) throws IOException {
		baseFolder = f;
		sock = s;
	}

	public void run() {
		try {
			outS = new DataOutputStream(sock.getOutputStream());
			inS = new DataInputStream(sock.getInputStream());


		} catch (IOException ex) {
			LOGGER.debug("Thread error on data streams creation\n");
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

					if (request.getMethod().equals("PUT")) {
						if (request.getURI().equals("/movement")) {
							String html = requestSharedMemoryService.requestSharedMemoryService();
							response.setContentFromString(HttpServerAjax.getWarehouseSharedMemory(html), "text/html");
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

						}else{
							response.setContentFromString(
									"<html><body><h1>ERROR: 405 Method Not Allowed</h1></body></html>",
									"text/html");
							response.setResponseStatus("405 Method Not Allowed");

							response.send(outS);
						}
				}
		}catch(IOException e){}
			try {
				sock.close();
			} catch (IOException e) {
				LOGGER.debug(e.getMessage() + "\n");
			}
	}
}


