package com.tudresden.multiagents.networkprogramming;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TransferToMethodTest {

	public void testTransferTo() throws IOException {
		byte[] inputBytes = "string".getBytes(); 
		ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes); 
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
		try {
			inputStream.transferTo(outputStream); 
			byte[] outputBytes = outputStream.toByteArray(); 
			for(int i = 0; i < outputBytes.length; i++) {
				System.out.println("outputBytes: " + outputBytes[i]);
			}
			int bytes = inputStream.read();
			//TODO fix the following line
			String result = new String(outputBytes, 0, bytes );
			System.out.println("result of stream: " + result);
			
		} finally {
			try {
				inputStream.close();
			} catch(Exception ex) 
			{
				ex.printStackTrace();
			}
			try {
				outputStream.close(); 
			} catch(Exception ex) 
			{
				ex.printStackTrace();
			}
		}
	}
	
	public void initializeTransfer() throws IOException {
		TransferToMethodTest obj = new TransferToMethodTest(); 
		obj.testTransferTo();
	}
	
	public static void main(String[] args) throws IOException {
		TransferToMethodTest newObj = new TransferToMethodTest();
		newObj.initializeTransfer();
	}
}
