package com.tudresden.multiagents.networkprogramming;

import static com.tudresden.multiagents.networkprogramming.PORTInfo.CLIENT_PORT;
import static com.tudresden.multiagents.networkprogramming.PORTInfo.SERVER_PORT;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class UDPEchoClient {

	//Create a message
	private static final String MESSAGE = "This message is coming from the UDP Echo Client"; 
	//logger object
	private static final Logger logger = Logger.getLogger(UDPEchoClient.class.getName());
	
	public static CompletableFuture<String> initiateFunction() throws UnknownHostException, SocketException {
		//create a byte array
		byte[] arrayBytes = MESSAGE.getBytes();
		logger.info("byte of the message is: " + arrayBytes);
		//DatagramPacket(buffer, length of the buffer, adddress of the host, number of the port	)
		//creation of the packet
		DatagramPacket packet = new DatagramPacket(arrayBytes, arrayBytes.length, InetAddress.getLocalHost(), SERVER_PORT);
		DatagramSocket datagramSocket = new DatagramSocket(); 
		UDPReceive receive = new UDPReceive(CLIENT_PORT);
		//the final message
		//Sync response
		//TODO: Fix the issue
		return null;
		
      }
	
	
	public static void main(String[] args) throws UnknownHostException, SocketException {
		initiateFunction();
	}

}
