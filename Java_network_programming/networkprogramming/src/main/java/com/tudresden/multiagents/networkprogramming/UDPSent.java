package com.tudresden.multiagents.networkprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;
import java.net.DatagramSocket;

public class UDPSent {

	private static final Logger logger = Logger.getLogger(UDPSent.class.getName());
	
	private static final String MESSAGEUDP = "Hello UDP";
	
	public static void UDPSend() throws IOException {
		byte[] buffer = MESSAGEUDP.getBytes();  //byte array
		InetAddress address = InetAddress.getLocalHost(); 
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 1024);
		DatagramSocket datagramSocket = new DatagramSocket();
		logger.info("packet:" + packet);
		logger.info("datagramSocket: " + datagramSocket);
		datagramSocket.send(packet);
		logger.info("Message has been sent: " + MESSAGEUDP + " ");
	}
	
	public static void main(String[] args) throws IOException {
		UDPSend();
	}
	
	public static void ResolveNameInetAddress() {
		//Read text from a character input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
		//scan the input line
		//Returns a Stream, the elements of which are lines read from this BufferedReader
		input.lines().forEach((line) -> {
			try {
//				This class represents an Internet Protocol (IP) address
				InetAddress address = InetAddress.getByName(line);
				System.out.println(address.getHostAddress());
			} catch(Exception ex) {
				System.out.println("Unknown host has been detected");
				ex.printStackTrace();
			}
		});
	}
}
