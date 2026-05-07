/**
 * File Name: hashMap
 * Author: Tom Leung
 * Date Created: May 7, 2026
 * Date Last Edited: May 7, 2026
 */
import java.util.HashMap;
public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static HashMap <String,Integer> combineParallelArrays(String[] arr, int[] arr1){
		HashMap <String,Integer> map = new HashMap<String, Integer>() ;
		for (int i = 0; i < arr.length;i++){
			map.put(arr[i], arr1[i]);
		}
		return map;
	}

	public static void increaseAge(HashMap <String,Integer> map, String name){		
		int i1 = map.get(name);
		map.put(name, i1+1);

	}

	public static void replaceName(HashMap <String,Integer> map, String name, String name1){		
		int i1 = map.get(name);
		map.remove(name);
		map.put(name1, i1);

	}



}
