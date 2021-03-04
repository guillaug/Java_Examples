package com.tudresden.multiagents.networkprogramming;

import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;



public class UDPReceive {
	//create a buffer
	private static final int BUFFER_SIZE = 2000;
	private static int portnumber = 0;
	
	public UDPReceive(int portnumber) {
		// TODO Auto-generated constructor stub
		UDPReceive.portnumber = portnumber;
	}
	
	//isBound() returns the binding state of the socket  
	static boolean isBound(DatagramSocket serverSocket) {
		return serverSocket != null && serverSocket.isBound();
	}
	
	public String datagramReceive() throws IOException {
		String message = "";
		try {
			//Sleep 1 second
			Thread.sleep(1000);
			//initialize a server socket
			DatagramSocket serverSocket = new DatagramSocket(portnumber);
			if(!isBound(serverSocket))
				return null;
			//create a byte array in the size of BUFFER_SIZE
			byte[] dataReceive = new byte[BUFFER_SIZE];
			//take the datagram package --> DatagramPacket(receive of the data, the length of the received data)
			DatagramPacket packetReceive = new DatagramPacket(dataReceive, dataReceive.length); 
			
			//Open a server socket --> serverSocket(DatagramPacket)
			serverSocket.receive(packetReceive); 
			//received data in a string form
			message = new String(packetReceive.getData());
			System.out.println("RECEIVED the data: " + message);

		} catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return message;
	}
	
	public static void main(String[] args) {
		System.out.println("Hello Main of the UDP Receive Behavior");
	}
}
