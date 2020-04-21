package com.tu_dresden.mas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tu_dresden.blockchain.ConnectionWeb3;
import com.tu_dresden.mas.topic_management.ReceiverAgentTopic;
import com.tu_dresden.mas.topic_management.SenderAgentTopic;


public class App 
{
	private static final Logger logger = LoggerFactory.getLogger(App.class.getName());
    public static void main( String[] args )
    {
        logger.info( "Hello World!" );
        //ConnectionWeb3.connectionWeb3js();   
        //JadeSetup jadeSetup = new JadeSetup();
        SenderAgentTopic agentTopic = new SenderAgentTopic();
        agentTopic.setup();
    }
    
    
}
