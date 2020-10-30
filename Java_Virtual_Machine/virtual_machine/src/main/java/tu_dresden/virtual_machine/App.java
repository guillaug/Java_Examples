package tu_dresden.virtual_machine;

//import java.lang.reflect.Array;
//import java.lang.reflect.Field;

//import tu_dresden.reflections.Car;
import java.lang.reflect.*;

import tu_dresden.reflections.Car;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InstantiationException, IllegalAccessException, SecurityException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException
    {
        System.out.println( "Hello Java Application!" );
        
        Class clazz = Car.class;  //Should we cast this statement
        @SuppressWarnings("deprecation")
		Car car = (Car) clazz.newInstance();
        App.invokingMethods(clazz);
        
        
        Field field = clazz.getDeclaredField("people"); //take all fields of a class 
        
        Array.set(field.get(car), 1, "Kevin");  //Assign some values to the Array.
         
        Object obj = Array.get(field.get(car), 1);  //getter of the run-time environment
        
        System.out.println(obj);
        
//        Class clazz = String[].class; // assign the class of String
//        clazz = Class.forName("[Ljava.lang.String;");
//        System.out.println(clazz.getName());
        
    }
    
    private static void Fields (Class cls, Car car) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    	Field field = cls.getDeclaredField("speed"); //Speed is one of the attributes
    	Object obj = field.get(car);
    	System.out.println(obj);
    	
    	car.drive('D', 33);
    	
    	obj = field.get(car);
    	System.out.println(obj);
    	
    	field.set(car, 44);  //setter for values
    	obj = field.get(car);
    	System.out.println(obj);
    }
    
    private static void invokingMethods(Class<Car> cls) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException 
    {
    	Constructor[] ctors = cls.getDeclaredConstructors();
    	Car car = (Car) ctors[1].newInstance();
    	Method method = cls.getDeclaredMethod("drive", char.class, int.class);
    	method.invoke(car, 'D', 6);
    	
//    	method = cls.getDeclaredMethods("print");
    	
    }
    
//    private static void typesOfAttributes(Class cls) throws NoSuchFieldException 
//    {
//    	Field field = 
//    }
}
