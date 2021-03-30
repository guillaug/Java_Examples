package tu.dresden.designpatterns.abstractfactory;


// Factory users don't care which concrete factory they use because they work with factories
// factories and products through abstract interfaces.
public class Application {

	private Button button; 
	private Checkbox checkbox; 
	
	public Application(GUIFactory guiFactory) {
		button = guiFactory.createButton();
		checkbox = guiFactory.createCheckbox(); 
	}
	
	public void doSomeAction() {
		button.doAnAction(); // from the Button class
		checkbox.doSomeAction(); // from the Checkbox class
	}
	
}
