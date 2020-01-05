import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuildingBiMap {

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
		
		Map<Integer, List<Persons>> map = mapByAge(persons);
		Map<Integer, Map<String, List<Persons>>> bimap = new HashMap<>();
		persons.stream().forEach(
				p->bimap.computeIfAbsent(p.getAge(), HashMap::new).merge(p.getGender(), new ArrayList<Persons>(Arrays.asList(p)), 
						(l1,l2) -> {
				l1.addAll(l2);
				return l1;
				
						}
				));
		
		bimap.forEach((age, bmap)->System.out.println("age: "+age+" Map: "+bmap));
	}
	
	private static Map<Integer, List<Persons>> mapByAge(List<Persons> list) {
		Map<Integer, List<Persons>> map = list.stream().collect(Collectors.groupingBy(Persons::getAge));
		return map;
	}

}
