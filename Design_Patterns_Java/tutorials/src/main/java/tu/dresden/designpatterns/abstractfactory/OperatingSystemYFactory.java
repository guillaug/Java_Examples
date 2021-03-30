package tu.dresden.designpatterns.abstractfactory;

public class OperatingSystemYFactory implements GUIFactory{

	public Button createButton() {
		// TODO Auto-generated method stub
		return new OperatingSystemYButton();
	}

	public Checkbox createCheckbox() {
		// TODO Auto-generated method stub
		return new OperatingSystemYCheckbox();
	}
	
}
