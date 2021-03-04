package com.tudresden.multiagents.networkprogramming;

/**
 * Hello world!
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;


public class HTTPSend 
{
	private static final Logger logger = Logger.getLogger(HTTPSend.class.getName());
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
        	Socket socket = new Socket("www.packtpub.com", 80);
        	OutputStream outputStream = socket.getOutputStream();
        	outputStream.write(("GET / HTTP/1.1\\r\\n" + "Host: www.google.com\r\n\r\n").getBytes());
        	logger.info("outputStream: " + outputStream);
        	outputStream.flush();
        	
        	BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        	String line; 
        	while((line = reader.readLine()) != null) {
        		logger.info("read line: " + line);
        	}
        	
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
    }
}
