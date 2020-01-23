
public class NestedInterface implements Showable.NestedInterface{

	public void message(){
		System.out.println("Implemented Interface Nested Interface method");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NestedInterface().message();
		new A().message();
	}

}

class A implements Show.NestedInterface{
	public void message(){
		System.out.println("Implemented Class Nested Interface method");
	}
}

interface Showable{
	void show();
	interface NestedInterface{
		void message();
	}
}

class Show{

	interface NestedInterface{
		void message();
	}
}

interface Test{
	class SNC{
		
	}
}
