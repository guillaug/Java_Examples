package com.tu_dresden.mas.tests;

import org.junit.Test;

import com.tu_dresden.ecoreinitializer.EcoreInit;

import java.io.IOException;

import org.junit.Assert;


public class ModelTest {
	static String filePath = "./resources/crom_composed.ecore";
	static String testFilePath = "./crom_composed.ecore";


	@Test
	public void testModelImporter()
	{
		EcoreInit ecore = new EcoreInit();
		Assert.assertNotNull(ecore.loadTheModel(filePath));
	}
	
	@Test
	public void testFileOpener() throws IOException
	{
		EcoreInit core = new EcoreInit();
		Assert.assertTrue(core.fileOpener(filePath));
	}
	
	@Test
	public void testModelRegister()
	{
		EcoreInit ecore = new EcoreInit();
		Assert.assertNotNull(ecore.registerMetaModel(filePath));
	}
}
