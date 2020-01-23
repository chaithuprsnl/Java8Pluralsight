
public class AnonymousInner {

	public static void main(String[] args){
		Parent p = new Parent(){//Create anonymous inner class to override parent's class method and provide implementation.
			public void display(){
				System.out.println("Anonymous Inner Class extends class");
			}
		};
		
		p.display();
		
		ParentInterface pi = new ParentInterface(){//Create anonymous inner class to override interface's method and provide implementation.
			public void message(){
				System.out.println("Anonymous inner class implementing interface");
			}
		};
		
		pi.message();
	}
}

abstract class Parent{
	abstract void display();
}

interface ParentInterface{
	abstract void message();
}
