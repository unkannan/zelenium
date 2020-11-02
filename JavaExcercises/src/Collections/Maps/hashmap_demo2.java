package Collections.Maps;

import java.util.*;

public class hashmap_demo2 {
	public static void main(String[] args) {

		  HashMap<Integer, String> map = new HashMap<>();
		  map.put(3, "Vinod");
		  map.put(6, "Amol");
		  map.put(8, "Nandan");
		  map.put(12, "Yusuf");

		  // Iterating over hashmap
		  for (Map.Entry<Integer, String> entry : map.entrySet()) {
		   Integer key = entry.getKey();
		   String value = entry.getValue();
		   System.out.println(key + " " + value);
		  }

		  System.out.println("HashMap size= " + map.size());
		  
		  // Checking and searching
		  if (map.containsKey(8)) {
		   System.out.println("HashMap has a given key");
		  } else {
		   System.out.println("HashMap hasn't a given key");
		  }

		  // Remove the content of the hashMap
		  map.clear();

		  // Check if the hashMap empty
		  if (map.isEmpty())
		  {
		   System.out.println("The hashMap is empty");
		  }
		 }
}
