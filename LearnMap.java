package week3.day4;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LearnMap {

	public static void main(String[] args) {
		
		
		// Get all the Train Names  
		Map<String,String> mp = new HashMap<String,String>();
		
		mp.put("A001", "Test1");
		mp.put("A002", "Test2");
		mp.put("A003", "Test3");
		
		// Printing all available items
		for(Entry<String,String> eachItem : mp.entrySet()) {
			System.out.println(eachItem);
			System.out.println(eachItem.getKey());
			System.out.println(eachItem.getValue());
		}
		
		// To remove specific item
		mp.remove("A003");
		
		// Checking whether it is empty
		System.out.println(mp.isEmpty());
		
		// Count
		System.out.println(mp.size());
		
		// Contains specific key
		boolean pre = mp.containsKey("A003");
		System.out.println(pre);
		
		boolean pre1 = mp.containsKey("A002");
		System.out.println(pre1);
	}

}
