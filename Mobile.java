package week1.day1;

public class Mobile {

	//Declaring variables
	boolean mobWorking=true;
	int charge = 80;
	String model="Oneplus5t";
	
	public static void main(String[] args) {
		// Printing system - shortcut syso
		// Run application - Ctrl + F11
		System.out.println("Learning Java");
		
		// Creating object for class
		Mobile mob= new Mobile();
		
		// calling the variable and assigning to local variable
		boolean mobWorking2 = mob.mobWorking;
		
		// Printing the value of the variable
		System.out.println(mobWorking2);
		
		int charge2 = mob.charge;
		System.out.println(charge2);
		
		String model2 = mob.model;
		System.out.println(model2);
	}
}
