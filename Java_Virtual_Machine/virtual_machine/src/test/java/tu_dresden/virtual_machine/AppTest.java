package tu_dresden.virtual_machine;

//import junit.framework.Test;
import org.junit.Test;

import tu_dresden.reflections.Car;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;

import org.junit.Assert;
import org.junit.Ignore;

//import junit.framework.TestCase;
//import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
{	
		public AppTest() { // no argument 
			
		}
		@Ignore
		@Test
		public void reflectionPerformanceTest() throws Exception
		{
			// Call doRegular and doReflection method respectively.
			AppTest.doRegular();
			AppTest.doReflection();
		}
		
		@Test
		public void reflectionClassTest() throws Exception 
		{
			AppTest cls = new AppTest();
			Class clazz = cls.getClass();
			
			Method[] method = clazz.getDeclaredMethods();
			for(int i = 0; i < method.length; i++)
			{
				System.out.println("All methods are here: " + method[i].toString());
			}
			Assert.assertNotNull(method);
		}
		
		@Test
		public void processTest() throws InterruptedException, IOException 
		{
			File installationFolder = new File(System.getProperty("user.dir")); //for MacOS
			ProcessBuilder pb = new ProcessBuilder("open", installationFolder.toString());  
			//Take the pb to a process
			Process p = pb.start();
			int exitCode = p.waitFor();
//			Process p = Runtime.getRuntime().exec(""); //which application  @Deprecated
			System.out.println("What is the exit code: " + exitCode);
			System.out.println("Waiting ....");
			Thread.sleep(1000); //1 second
			
			p.destroy();  //here should be tested
			
			Assert.assertFalse(p.isAlive());
		}
		
		public static void doRegular() throws Exception 
		{
			long start = System.currentTimeMillis();
			for(int i = 0; i < 10000000; i++)
			{
				Car car = new Car(4);
			}
			System.out.println(System.currentTimeMillis() - start);
		}
		
		public static void doReflection() throws Exception 
		{
			long start = System.currentTimeMillis();
			for(int i = 0; i < 10000000; i++)
			{
				@SuppressWarnings("deprecation")
				Car car = (Car) Class.forName("Car").newInstance();  // you should cast this function		
			}
			System.out.println(System.currentTimeMillis() - start);
		}
		
	
}
