import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstPredicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<String> stream1 = Stream.of("one","two","three","four","five");
		
		Predicate<String> p1 = s -> s.length()>3;
		
		Predicate<String> p2 = Predicate.isEqual("one");
		Predicate<String> p3 = Predicate.isEqual("five");
		
		/*Stream<String> stream2 = stream1.filter(p1);
		stream2.forEach(System.out::println);*/
		
		//stream1.filter(p1).forEach(System.out::println);
		
		stream1.filter(p2.or(p3)).forEach(System.out::println);
	}

}
