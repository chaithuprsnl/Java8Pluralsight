import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChainConsumers {
	
	public static void main(String[] args){
		
		List<String> list = Arrays.asList("one","two","three");
		List<String> result = new ArrayList<String>();
		
		Consumer<String> c1 = System.out::println;//s -> System.out.println(s);
		Consumer<String> c2 = result::add;
		
		
		System.out.println(result.size());
		
		list.forEach(c1.andThen(c2)); //andThen is default method in consumer interface
		
		System.out.println(result.size());
		
		list.stream().forEach(c1.andThen(c2));
		
		System.out.println(result.size());
		
	}

}
