package com.tu_dresden.ecoreinitializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Desktop;
import java.util.Map;

public class EcoreInit {
	
	private static Logger logger = LoggerFactory.getLogger(EcoreInit.class.getName());
	private final static String FILE_NAME = "crom_composed.ecore";
	private final static String FILE_EXTENSION = "ecore";

	/*
	 * public static EObject loadYourModel(String path) { Initialzie Models
	 * YourPackage.eINSTANCE.eClass();
	 * 
	 * register your xmi resources final Resource.Factory.Registry reg =
	 * Resource.Factory.Registry.INSTANCE; final Map<String, Object> m =
	 * reg.getExtensionToFactoryMap(); put all your different ecore file suffixes in
	 * the map; suffix = YourPackage.eNAME m.put(YourPackage.eNAME, new
	 * XMIResourceFactoryImpl()); you can put all different package names here
	 * 
	 * Create a new Resource set to store the EObjects from the file ResourceSet
	 * resSet = new ResourceSetImpl();
	 * 
	 * get the resource of your ecore file Resource resource =
	 * resSet.getResource(URI.createURI(path), true); Get the first element = root
	 * of your model hierachy EObject root = resource.getContents().get(0); return
	 * root; }
	 */

	// Write a test function in order to open a regular file
	
	public EObject registerMetaModel(String filePath)
	{
		logger.info("Register the meta model");
		ResourceSet resSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(EcoreInit.FILE_EXTENSION, new XMLResourceFactoryImpl() );
		BasicExtendedMetaData basicExtendedValue = new BasicExtendedMetaData(resSet.getPackageRegistry());
		resSet.getLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, basicExtendedValue);
		Resource r = resSet.getResource(URI.createFileURI(filePath), true);
		EObject eObject = r.getContents().get(0);
		logger.info("eObject is: " + eObject);
		return eObject;
	}
	
	
	public EObject loadTheModel(String filePath) {
		// EcoreInit.eINSTANCE.class();
		
		try {
			ResourceSet resSet = new ResourceSetImpl();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(EcoreInit.FILE_EXTENSION, new XMLResourceFactoryImpl() );
			Resource resource = resSet.getResource(URI.createURI(filePath), true);
			logger.info("resource is: " + resource);
			EObject root = resource.getContents().get(0);
			logger.info("root object in XMI :" + root);
			
			Iterator<EObject> iter = resource.getAllContents();
			while(iter.hasNext())
			{
				logger.info("Elements are: " + iter.next());
			}
			return root;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		return null;

	}
	
	public boolean fileOpener(String filePath) throws IOException 
	{
		//File file = new File(filePath);
		//logger.info("File Object" + file);
		List<String> result = new ArrayList<String>();
		BufferedReader bufferReader = new BufferedReader(new FileReader(filePath));

		try {
			if(bufferReader != null)
			{
				logger.info("File existed ");
				String line = null;
				while((line = bufferReader.readLine()) != null)
				{
					result.add(line); // we added the last line into it.
				}
				logger.info("result: {} .\n" + result);
				return true;
			}

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(bufferReader != null)
			{
				bufferReader.close();
			}
		}
		
		return false;
	}

}
