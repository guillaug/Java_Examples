package tu.dresden.designpatterns.abstractfactory;


//Each concrete factory extends basic factory and responsible for creating 
// products of a single variety.
public class OperatingSystemXFactory implements GUIFactory{

	public Button createButton() {
		// TODO Auto-generated method stub
		return new OperatingSystemXButton();  //new object from the class
	}

	public Checkbox createCheckbox() {
		// TODO Auto-generated method stub
		return new OperatingSystemXCheckbox(); //new object from the class
	}

}
