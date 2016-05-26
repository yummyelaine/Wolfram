/**
 * DeleteDuplicates: 
 * Returns a new List containing the objects of the input list in 
 * order of first appearance,  with subsequent duplicates removed. 
 * <p>
 * I use HashSet to store the elements. Scan every element one by
 * one, when this element is contained in the HashSet, then do not
 * add this element into the new list. When this element is not in
 * the HashSet, then add this element into the new list and also
 * add it to HashSet. Return the new list finally.
 * 
 * 
 * Gather:
 * returns a new List<List> containing the objects of the input 
 * list in order of first appearance, where each sublist contains 
 * the identical elements.  
 * <p>
 * I use HashMap to store the elements. Key is the number shown in
 * the list and value is the list with all duplicate elements. Finally,
 * put all values into a new list and return this list.
 * 
 * Tally:
 * returns a java.util.Map whose keys are the unique objects of the 
 * input list and whose values are the corresponding count of the 
 * number of those objects that were in the input list. The iteration 
 * order of the Map should be the same as the order of appearance of 
 * the objects in the input list.
 * <p>
 * I use HashMap to store the elements. Key is the number shown in
 * the list and value is the number of appearance of each elements. 
 * I put all pairs of element and appearance number in a new map
 * and finally return it.
 * 
 * @author Suhan Liu
 * @param	list	Input a list of elements
 * @return			Return a list of elements without duplicates
 * @return			Return a new List<List> where each sublist 
 * 					contains the identical elements.
 * @return			Return a map whose keys are the unique objects
 * 					of the input list and whose values are the count
 * 					of number of those objects
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Challenge2 {
	
	public static List<Object> deleteDuplicates(List<?> list){
		List<Object> temp = new ArrayList<Object>();
		if(list == null){
			return temp;
		}
		
		HashSet<Object> set = new HashSet<Object>();
		
		List<Object> noDup = new ArrayList<Object>();
		
		for(Object k : list){
			if(!set.contains(k)){
				noDup.add(k);
				set.add(k);
			}
			
		}
		
		
		return noDup;
	}
	
	public static List<List<Object>> gather(List<?> list){
		List<List<Object>> result = new ArrayList<List<Object>>();
		
		if(list == null){
			return result;
		}
		
		HashMap<Object, List<Object>> map = new HashMap<Object, List<Object>>();
		
		for(Object k : list){
			if(map.containsKey(k)){
				map.get(k).add(k);
			}else{
				List<Object> newlist = new ArrayList<Object>();
				newlist.add(k);
				map.put(k, newlist);
			}
		}
		
		
		
		for(Object i : map.keySet()){
			result.add(map.get(i));
		}
		
		return result;
	}
	
	public static Map<Object, Integer> tally(List<Integer> list){
		Map<Object, Integer> map = new HashMap<Object, Integer>();
		
		if(list == null){
			return map;
		}
		
		for(int k : list){
			if(map.containsKey(k)){
				int temp = map.get(k);
				temp++;
				map.put(k, temp);
			}else{
				map.put(k, 1);
			}
		}
		
		return map;
	}
	
	public static void main(String[] args){
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(5);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(0);
		list.add(2);
		list.add(5);
		
		// Test for "deleteDuplicates" function
		System.out.println("Delete Duplicates: ");
		
		List<Object> deleteDup = deleteDuplicates(list);
		
		System.out.println(deleteDup);
		
		System.out.println(" ");
		
		// Test for "gather" function
		System.out.println("Gather: ");
		
		List<List<Object>> gather = gather(list);
		
		System.out.println(gather);
		System.out.println(" ");
		
		// Test for "tally" function
		System.out.println("Tally: ");
		
		Map<Object,Integer> map = tally(list);
		
		System.out.println(map);
		
	}
	
}
