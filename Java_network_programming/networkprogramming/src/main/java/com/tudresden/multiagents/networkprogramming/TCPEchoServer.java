package com.tudresden.multiagents.networkprogramming;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger; 
import java.io.InputStream;
import java.io.OutputStream;

public class TCPEchoServer {

	private static final int REMOTE_CONNECTION_PORT = 8080;
	private static final int BUFFER_LENGTH = 1024; 
	private static final Logger logger = Logger.getLogger(TCPEchoServer.class.getName());
	public static void main(String[] args) {
		logger.info("Hello Main Method");
		try {
//			This class implements server sockets. A server socket waits for requests to come in over the network.
//			It performs some operation based on that request, and then possibly returns a result to the requester. 
			ServerSocket serverSocket = new ServerSocket(REMOTE_CONNECTION_PORT);
			logger.info("serverSocket object: " + serverSocket);
			Socket clientSocket = serverSocket.accept();
			logger.info("clientSocket address: " + clientSocket);
			//This class implements an IP Socket Address (IP address + port number) 
//			It can also be a pair (hostname + port number), in which case an attempt will be made to resolve the hostname. 
//			If resolution fails then the address is said to be unresolved but can still be used on some circumstances like connecting through a proxy.
			InetSocketAddress remoteAddress = (InetSocketAddress) clientSocket.getRemoteSocketAddress(); 
			logger.info("InetSocketAddress: " + remoteAddress);
			logger.info("Connection has been initiated from the port: " + remoteAddress.getPort() + "host: " + remoteAddress.getHostName());
			//This abstract class is the superclass of all classes representing an input stream of bytes. 
			InputStream inputStream = clientSocket.getInputStream();
			//This abstract class is the superclass of all classes representing an output stream of bytes. 
//			An output stream accepts output bytes and sends them to some sink. 
			OutputStream outputStream = clientSocket.getOutputStream();
			
			byte[] buffer = new byte[BUFFER_LENGTH];
			while(clientSocket.isConnected()) { //status of the client socket
				int lengthOfTheStream = inputStream.read(buffer);
				if(lengthOfTheStream > 0) {
					outputStream.write(buffer, 0, lengthOfTheStream);
				}
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
}
