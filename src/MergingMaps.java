import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergingMaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Persons> persons = new ArrayList<>();
		Path path = Paths.get("C:\\Users\\krishsravs\\Documents\\workspace-sts-3.9.2.RELEASE", "Java8Practice\\src",
				"people.txt");
		try (Stream<String> stream = Files.lines(path);) {
			stream.map(line -> {
				String[] arr = line.split(" ");
				String name = arr[0];
				int age = Integer.parseInt(arr[1]);
				String gender = arr[2];
				Persons p = new Persons(name, age, gender);
				persons.add(p);
				return p;
			}).forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Persons> list1 = persons.subList(0, 5);
		List<Persons> list2 = persons.subList(5, persons.size());
		Map<Integer, List<Persons>> map1 = mapByAge(list1);
		Map<Integer, List<Persons>> map2 = mapByAge(list2);
		System.out.println("Map1");
		map1.forEach((age, list) -> System.out.println("age " + age + " list " + list));

		System.out.println("Map2");
		map2.forEach((age, list) -> System.out.println("age " + age + " list " + list));

		map2.entrySet().stream().forEach(entry -> map1.merge(entry.getKey(), entry.getValue(), (l1, l2) -> {
			l1.addAll(l2);
			return l1;
		})

		);
		
		System.out.println("After merge Map1");
		map1.forEach((age, list)->System.out.println("age: "+age+" list: "+list));
	}

	private static Map<Integer, List<Persons>> mapByAge(List<Persons> list) {
		Map<Integer, List<Persons>> map = list.stream().collect(Collectors.groupingBy(Persons::getAge));
		return map;
	}

}
