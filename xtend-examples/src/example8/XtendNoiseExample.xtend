package example8
import java.util.List;
import java.util.stream.Collectors;


class XtendNoiseExample {
	
	def public List<String> initialExample(List<?> list)
	{
		return list.stream()
				.filter([object | object instanceof String])
				.map([object | object as String])
				.filter([s | s.length() == 2])
				.map([s | s.toUpperCase()])
				.collect(Collectors.toList());
			
	}
	
	def FinalExample(List<?> list)
	{
		list.filter(String)
			.filter[length == 2]
			.map[toUpperCase]
			.toList
	}
}