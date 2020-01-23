import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Person> list = new ArrayList<Person>();
		
		try(
				BufferedReader br = new BufferedReader(new InputStreamReader(CollectorsExample.class.getResourceAsStream("persons.txt")));
				Stream<String> stream = br.lines();
		){		
				//Save file data to List of Person
				stream.map(line -> {
					String[] per = line.split(" ");
					Person p = new Person(per[0].trim(), Integer.parseInt(per[1]));
					list.add(p);
					return p;
				}).forEach(System.out::println);
				
				//Find oldest person
				Optional<Person> maxPerson = list.stream().max(Comparator.comparing(Person::getAge));
				
				//Find young person
				Optional<Person> minPerson = list.stream().min(Comparator.comparing(Person::getAge));
				
				//Find young person with age greater than 20
				Optional<Person> yperson = list.stream().filter(p -> p.getAge() > 20).min(Comparator.comparing(Person::getAge));
							
				System.out.println("Max: "+maxPerson.get().getName());
				System.out.println("Min: "+minPerson.get().getName());
				System.out.println("Yperson: "+yperson.get().getName());
				
				//Collector
				
				Map<Integer, List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getAge));
				
				Map<Integer, Long> lmap = list.stream().collect(
						Collectors.groupingBy(Person::getAge, Collectors.counting())
						);
				
				Map<Integer, List<String>> listmap = list.stream().collect(
						Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList()))
						);
				
				Map<Integer, Set<String>> setmap = list.stream().collect(
						Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toCollection(TreeSet::new)))
						);
				
				Map<Integer, String> strmap = list.stream().collect(
						Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.joining(",")))
						);
				
				System.out.println(map);
				System.out.println(lmap);
				System.out.println(listmap);
				System.out.println(setmap);
				System.out.println(strmap);
				
				
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
