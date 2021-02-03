package com.tudresden.multiagents.topicmanagement;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.core.messaging.TopicManagementHelper;
import jade.lang.acl.ACLMessage;
import java.util.logging.Logger;

public class SenderAgentTopic extends Agent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3076763432372075009L;
	private static final Logger logger = Logger.getLogger(SenderAgentTopic.class.getName());
	
	public void setup() {
		try 
		{
			// Periodically send messages about corresponding topic
			logger.info("Sender Agent Topic");
			TopicManagementHelper topicHelper = (TopicManagementHelper) getHelper(TopicManagementHelper.SERVICE_NAME);
			final AID topic = topicHelper.createTopic("JADE Supply Chain");
			logger.info("topic name: " + topic);
			addBehaviour(new TickerBehaviour(this, 10000) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void onTick() {
					logger.info("Agent "+myAgent.getLocalName()+": Sending message about topic "+topic.getLocalName());
					ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
					msg.addReceiver(topic);
					msg.setContent(String.valueOf(getTickCount()));
					myAgent.send(msg);
				}
			});
		}
		catch(Exception ex)
		{
			logger.severe("An error has been occurred in the sender agent");
			ex.printStackTrace();
		}
	}
}
