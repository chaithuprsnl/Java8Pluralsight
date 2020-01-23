import java.io.File;
import java.io.FileFilter;

//One way of Implementing and using an interface
public class JavaFileFilter implements FileFilter{

	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		return pathname.getName().endsWith(".txt");
	}
	
	
}
