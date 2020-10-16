package tu_dresden.reflections;

public class Car extends Vehicle{
	int speed;
	char driveType;
	String[] people;
	
	//constructor
	public Car() {
		this(4);
	}
	
	public Car(int doors)
	{
		people = new String[4];
	}
	
	public int drive(char driveType, int desiredSpeed)
	{
		selectDrive(driveType);
		
		while(speed != desiredSpeed)
		{
			accelerate();
		}
		
		return speed; //return value is speed
	}
	
	private int accelerate() 
	{
		return ++speed;
	}
	
	private void selectDrive(char driveType)
	{
		this.driveType = driveType;
	}
	
	//print function is here
	public static void print()
	{
		System.out.println("Hello Reflection");
	}
}
