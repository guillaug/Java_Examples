package com.tudresden.multiagents.networkprogramming;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class MultiThreadedTCPServer {
	
	private static final int REMOTE_PORT = 8080; //HTTP Port
	private static final Logger logger = Logger.getLogger(MultiThreadedTCPServer.class.getName());
			
	public static void initializeTCPServer() throws IOException {
		final ServerSocket serverSocket = new ServerSocket(REMOTE_PORT);
//		Creates a thread pool that reuses a fixed number of threads
//		operating off a shared unbounded queue.
		final ExecutorService executorService = Executors.newFixedThreadPool(10); //Thread pool
		while(true) {
//		     Listens for a connection to be made to this socket and accepts
//		     it. The method blocks until a connection is made.
			final Socket acceptionSocket = serverSocket.accept();
//			Returns the address of the endpoint this socket is connected to, or if it is not connected
			final InetSocketAddress inetSocket = (InetSocketAddress) acceptionSocket.getRemoteSocketAddress();
			logger.info("connection from the port: " + inetSocket.getPort() + "connection from the hostname: " + inetSocket.getHostName());
//			Submits a Runnable task for execution and returns a Future representing that task.
			executorService.submit(() -> {
//				Returns an input stream for this socket
				try (final InputStream inputStream =  acceptionSocket.getInputStream(); 
						final OutputStream outputStream = acceptionSocket.getOutputStream()) {
//					transferTo() - java 1.9
					while(acceptionSocket.isConnected() && inputStream.transferTo(outputStream) > 0); 
					logger.info("disconnection from the port: " + inetSocket.getPort() + "disconnection from the hostname: " + inetSocket.getHostName());
					
				} catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			});
			
		}
	}
}
