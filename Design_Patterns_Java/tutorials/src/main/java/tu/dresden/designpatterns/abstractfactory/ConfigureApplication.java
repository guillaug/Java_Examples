package tu.dresden.designpatterns.abstractfactory;

public class ConfigureApplication {

	//Application picks the factory type and creates it run time
	// depending on the configuration or environment values.
	private static Application configureApplication() {
		Application application; 
		GUIFactory guiFactory; 
		
		String osName = "OperatingSystemX";
		//if you want to take a real operating system name
		//String osName = System.getProperty("os.name").toLowerCase();
		if(osName.contains("OperatingSystemX")) {
			guiFactory = new OperatingSystemXFactory();
			application = new Application(guiFactory);
		} else 
		{
			guiFactory = new OperatingSystemYFactory();
			application = new Application(guiFactory);
		}
		return application;
		
	}
	
	public static void main(String[] args) {
		Application application = configureApplication(); 
		application.doSomeAction();
	}
}
