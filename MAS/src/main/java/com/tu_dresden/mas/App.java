package com.tu_dresden.mas;


import com.tu_dresden.blockchain.ConnectionWeb3;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ConnectionWeb3.connectionWeb3js();   
        JadeSetup jadeSetup = new JadeSetup();
        jadeSetup.setup();
    }
    
    
}
