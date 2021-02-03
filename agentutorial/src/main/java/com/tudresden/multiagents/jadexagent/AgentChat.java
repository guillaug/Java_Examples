package com.tudresden.multiagents.jadexagent;
//package com.tudresden.multiagents.agentutorial;
//
//import jadex.base.Starter;
//import jadex.bridge.IComponentIdentifier;
//import jadex.bridge.IExternalAccess;
//import jadex.bridge.IInternalAccess;
//import jadex.bridge.nonfunctional.annotation.NameValue;
//import jadex.bridge.service.IService;
//import jadex.bridge.service.ServiceScope;
//import jadex.bridge.service.annotation.OnInit;
//import jadex.bridge.service.types.chat.ChatEvent;
//import jadex.bridge.service.types.chat.IChatGuiService;
//import jadex.bridge.service.types.chat.IChatService;
//import jadex.bridge.service.types.cms.CreationInfo;
//import jadex.commons.future.IntermediateDefaultResultListener;
//import jadex.micro.annotation.Agent;
//import jadex.micro.annotation.Component;
//import jadex.micro.annotation.ComponentType;
//import jadex.micro.annotation.ComponentTypes;
//import jadex.micro.annotation.Configuration;
//import jadex.micro.annotation.Configurations;
//import jadex.micro.annotation.RequiredService;
//import jadex.micro.annotation.RequiredServices;
//
///**
// * Apply a function wrapped in AST to AST arguments.
// * 
// * @param fn An AnyAST containing the argument.
// * @param args A list of Maybe<AST> arguments or holes for partial application.
// * @param namedArgs A list of Pair<String Maybe<AST>> named arguments or holes for partial application.
// * @return An Either<String a> object containing either an error message or the reflected result of calling the function.
// */
//
//@Agent
//@ComponentTypes(@ComponentType(name="chat", filename="jadex/platform/service/chat/ChatAgent.class")) //implicit depndency
////Configurations
//@Configurations({
//	@Configuration(name="intern", components=@Component(type="chat", arguments=@NameValue(name="nosave", value="true"), configuration="user")),
//	@Configuration(name="extern")
//})
//@RequiredServices({@RequiredService(name="chat_intern", type=IChatGuiService.class),
//				   @RequiredService(name="chat_extern", type=IChatGuiService.class, scope=ServiceScope.PLATFORM)})
//public class AgentChat {
//	
//	@Agent
//	protected IInternalAccess agent;
//	
//	// The GUI service for controlling the inner chat component.
////	@AgentServiceSearch(name="%{\"chat_\"+$config}")
//	protected IChatGuiService chat;
//	
//	//Just like Android
//	@OnInit
//	public void start()
//	{
//		chat.status(IChatService.STATE_IDLE, null, new IComponentIdentifier[0]); //Change state from away to idle
//		chat.setNickName("EchoRelay").get();
//	
//	final IComponentIdentifier self = ((IService) chat).getServiceId().getProviderId();
//	//subscription to the events
//	//async function
//	chat.subscribeToEvents().addResultListener(new IntermediateDefaultResultListener<ChatEvent>()
//	{
//		public void intermediateResultAvailable(ChatEvent event)
//		{
//			if(ChatEvent.TYPE_MESSAGE.equals(event.getType()) && !self.equals(event.getComponentIdentifier()) && event.isPrivateMessage())
//			{
//				StringBuilder sb = new StringBuilder();
//				sb.append(event.getValue());
//				String s = sb.toString().trim();
//				if(s.length() > 0)
//				{
//					chat.message(s, new IComponentIdentifier[] {event.getComponentIdentifier()}, true);
//					
//				}
//			}
//		}
//		
//		public void exceptionOccurred(Exception exception)
//		{
//			//ignore
//		}
//	
//	});
//}
//	
//	public static void runChatApp()
//	{
//		IExternalAccess pl = Starter.createPlatform(new String[] {"-gui", "false"}).get();
//		for(int i = 0; i < 10000; i++)
//		{
//			System.out.println(".");
//			if(i%100 == 0)
//				System.out.println("\n"+i+":");
//			IComponentIdentifier cid = pl.createComponent(new CreationInfo().setFilename(AgentChat.class.getName() + ".class")).get().getId();
//			try
//			{
//				
//			} 
//			catch(Exception ex)
//			{
//				System.out.println("Ex: " + ex.getMessage());
//			}
//		}
//		System.out.println("Finished task");
//	}
//
//	
//	
//} //class end
