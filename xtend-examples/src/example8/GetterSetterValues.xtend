package example8

class GetterSetterValues {
	def void testPOJO() 
	{
		val pojo = new POJO
		
		//Java like method syntax 
		pojo.setValue("Using method syntax")
		println(pojo.getValue)
		
		//Field syntax 
		pojo.value = "Using filed syntax"
		println(pojo.value)
	}
}