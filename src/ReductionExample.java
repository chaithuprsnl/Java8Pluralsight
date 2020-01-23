import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = Arrays.asList();//Arrays.asList();//Arrays.asList(12,23,45,23,556,23);
		
		int sum = list.stream().reduce(0, Integer::sum);
		
		System.out.println("Sum: "+sum);
		
		Optional<Integer> max = list.stream().reduce(Integer::max);
		
		System.out.println("Max: "+ max);
		
		System.out.println(max.orElse(100));

	}

}
