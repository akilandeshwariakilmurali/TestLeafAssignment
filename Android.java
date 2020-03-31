package week1.day1;

public class Android {

	//Declaring variables
	long build= 5787798;
	boolean screenRecording=true;
	int apiLevel = 19;
	String codeName="Kitkat";
	float version = 4.4f;
	
	public static void main(String[] args) {
	
		// Creating object for class
		Android and= new Android();
		
		// calling the variable and assigning to local variable
		boolean screenRecording2 = and.screenRecording;
		 
		// Printing the value of the variable
		System.out.println("Screen Recording feature is " +screenRecording2);
		
		long build2 = and.build;
		System.out.println("Build number is " +build2);
		
		int apiLevel2 = and.apiLevel;
		System.out.println("Api Level is " +apiLevel2);
		
		String codeName2 = and.codeName;
		System.out.println("Name is " +codeName2);
		
		float version2 = and.version;
		System.out.println("Version is " +version2);
	}
}
