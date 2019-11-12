package day6;


interface A{
	
	void m1();
}

interface B{
	
	void m1();
}
public class Test1 implements A,B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void m1(){
		
		System.out.println("Hello");
	}
	
	public void m1(int a){
		
		System.out.println("Hi");
	}

}
