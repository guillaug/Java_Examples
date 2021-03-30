package tu.dresden.designpatterns.abstractfactory;

//Abstract factory knows about all product types
public interface GUIFactory {
	Button createButton(); 
	Checkbox createCheckbox();
}
