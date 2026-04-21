/**
	* Lesson: Maps/HashMaps
	*	Author: Mr. Kalisz
	* Date Created: May 11, 2023
 	* Date Last Modified: May 11, 2023
	*/

import java.util.HashMap; //need to be imported to use

class Notes {
	public static void main(String args[]) {


		//Createing a HashMap

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//creates an empty HashMap

		//first data type -> Key
		//second data type -> Value (definition)

		//Keys have to be unique
		//Values do not have to unique
		
		//Adding to a HashMap

		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 1);
		
		//Getting a Value from a HashMap -> access by key

		System.out.println(map.get("c"));

		//remove a key and value from a hashmap -> remove on the key

		map.remove("d");
		
		//clearing a hashmap

		// map.clear();

		//size

		System.out.println(map.size());

		//print a hashmap

		System.out.println(map);

		//using hashmap vs parallel arrays/arraylists

		//HashMap -> When we have 2 groups data.  And we don't care about order, HashMaps are faster
		//Parallel Array/Arraylists -> More than 2 groups of data, When Order Matters
		
	}
}