package com.tudresden.multiagents.jadetopicmanagement;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import jade.core.*;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.messaging.TopicManagementHelper;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.util.logging.Logger;

public class ReceiverAgentTopic extends Agent{

		/**
	 * 
	 */
	private static final long serialVersionUID = -7497138143170826814L;
		private static final Logger logger = Logger.getLogger(ReceiverAgentTopic.class.getName());
		// declare setup function
		protected void setup() 
		{
			try 
			{
				logger.info("Receiver Agent Topic");
				TopicManagementHelper topicHelper = (TopicManagementHelper) getHelper(TopicManagementHelper.SERVICE_NAME);
				final AID topic = topicHelper.createTopic("JADE Supply Chain");
				// topic with a name
				topicHelper.register(topic);
				
				// Add a behaviour with regard to "JADE Supply Chain"
				addBehaviour(new CyclicBehaviour(this) {
					/**
					 * 
					 */
					private static final long serialVersionUID = 6301338166381717615L;

					public void action() {
						ACLMessage msg = myAgent.receive(MessageTemplate.MatchTopic(topic));
						if(msg != null) {
							logger.info("Agent: " + myAgent.getLocalName() + "Message about topic: " + topic.getLocalName() + "received. Content is " + msg.getContent());
							
						}
						else
						{
							block();
						}
					}
				});
			}
			catch(Exception ex)
			{
				logger.severe("Agent" + getLocalName() + " ERROR registering to topic ");
				ex.printStackTrace();
			}
		}
}
