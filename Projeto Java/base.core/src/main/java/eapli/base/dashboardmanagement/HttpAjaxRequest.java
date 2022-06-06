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
	Socket sock;
	DataInputStream inS;
	DataOutputStream outS;
	private static final Logger LOGGER = LogManager.getLogger(HttpAjaxRequest.class);

	public HttpAjaxRequest(Socket s, String f) throws IOException {
		baseFolder=f; sock=s;
	}
    
	public void run() {
		try {
		/*	InetAddress clientIP;


			clientIP = sock.getInetAddress();
			LOGGER.trace("New client connection from " + clientIP.getHostAddress() +
					", port number " + sock.getPort());
*/
			outS = new DataOutputStream(sock.getOutputStream());
			inS = new DataInputStream(sock.getInputStream());



		} catch(IOException ex) { System.out.println("Thread error on data streams creation"); }
		try {

			/*byte [] array_comm_test = inS.readNBytes(4);
			System.out.println("AAAA");
			System.out.println(new String(array_comm_test));
			InputMessage.parseMessage(array_comm_test, inS, outS);
			LOGGER.debug("Response from initial request sent\n");*/

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


		/*	byte [] array_end_of_session = inS.readNBytes(4);
		//	System.out.println(Arrays.toString(array_end_of_session));
			LOGGER.debug("End of session request");
			InputMessage.parseMessage(array_end_of_session, inS, outS);
			LOGGER.debug("End of session request received\n");*/

			} catch (IOException e) {
				e.printStackTrace();
			}
		try { sock.close();}
		catch(IOException ex) { System.out.println("CLOSE IOException"); }

		}
	}

