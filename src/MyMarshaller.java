import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MyMarshaller {
	
	public String marshallObj(Object o) {
		StringWriter sw = new StringWriter();
		try {
			JAXBContext jcontext = JAXBContext.newInstance(o.getClass());
			Marshaller marshaller = jcontext.createMarshaller();
			
			marshaller.marshal(o, sw);
			//System.out.println(sw.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sw.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new MyMarshaller().marshallObj(new Persons("Krishna", 32, "Male")));
	}

}
