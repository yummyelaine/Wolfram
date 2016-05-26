/**
 * Challenge 4
 * 
 * Given a list of integers with n elements, construct an algorithm 
 * that finds two numbers in the list that add up to a given number 
 * m. The algorithm's runtime should be O(n log n). Assuming that there
 * is at most one pair of numbers satisfy that the sum is the exactly 
 * the target number 
 * <p>
 * Solution: 
 * Corner case: The size of list is less than 2, then there is no result.
 * If the list size is greater than or equal to 2, I sort the list first
 * using Collection.sort and the time complexity is O(nlogn). Then I scan
 * every element to suppose it be one of the integer we want, and do the
 * binary search to try whether I could find its partner. This process also
 * cost O(nlogn) time. 
 * <p>
 * Improved Solution:
 * I could scan every element in the list in a HashSet. Then for every 
 * element I could simply search the HashSet to find if its partner is 
 * also in the set. For the search process for every element, it takes
 * O(1) time. If it is then we return those two numbers, if its partner 
 * is not contained in the list then we scan the next element. The time 
 * complexity is just O(n).
 * 
 * @author Suhan Liu
 * @param	list	A list of integers
 * @param	m		The target integer for the sum of two integers
 * @return			Return [0,0] if there is no result in the list, otherwise
 * 					return the two number as an array
 */


import java.util.*;

public class Challenge4 {
	public static int[] twoSum(List<Integer> list, int m){
		int[] result = new int[2];
		
		if(list.size() < 2){
			return result;
		}
		
		//sort the list
		
		Collections.sort(list, new Comparator<Integer>(){
			@Override
			public int compare(Integer x, Integer y){
				return x - y;
			}
		});
		
		//corner cases
		
		if(list.get(list.size() - 1) + list.get(list.size() - 2) < m){
			return result;
		}
		
		if(list.get(0) + list.get(1) > m){
			return result;
		}
		
		//scan every element to try to find a match
		
		for(int i = 0; i < list.size(); i++){
			int low = i + 1;
			int high = list.size() - 1;
			
			int partner = m - list.get(i);
			
			if(list.get(i) > partner){
				break;
			}
			
			if(list.get(low) == partner){
				result[0] = list.get(i);
				result[1] = list.get(low);
				break;
			}
			
			if(list.get(high) == partner){
				result[0] = list.get(i);
				result[1] = list.get(high);
				break;
			}
			
			int mid = low + (high - low) / 2;
			
			
			while(mid != low && mid != high){
				
				if(list.get(mid) == partner){
					result[0] = list.get(i);
					result[1] = list.get(mid);
					break;
				}else if(list.get(mid) > partner){
					high = mid;
					
				}else{
					low = mid;
					
				}
				
				mid = low + (high - low) / 2;
				
			}
		}
		
		return result;
		
	}
	
	public static void main(String[] args){
		//Testcase 1
		List<Integer> list1 = new ArrayList<Integer>();
		list1.addAll(Arrays.asList(-1));
		int[] twoNum1 = twoSum(list1, -1);
		
		System.out.println("Testcase1: " + list1 + " Target: -1");
		System.out.println("[" + twoNum1[0] + " " + twoNum1[1] +"]");
		
		//Testcase 2
		List<Integer> list2 = new ArrayList<Integer>();
		list2.addAll(Arrays.asList(-1,1,1,3,4,-5));
		int[] twoNum2 = twoSum(list2, 2);
		
		System.out.println("Testcase2: " + list2 + " Target: 2");
		System.out.println("[" + twoNum2[0] + " " + twoNum2[1] +"]");
		
		//Testcase 3
		List<Integer> list3 = new ArrayList<Integer>();
		list3.addAll(Arrays.asList(-1,2,8,9,3,6));
		int[] twoNum3 = twoSum(list3, 37);
		
		System.out.println("Testcase3: " + list3 + " Target: 6");
		System.out.println("[" + twoNum3[0] + " " + twoNum3[1] +"]");
		
		//Testcase 4
		List<Integer> list4 = new ArrayList<Integer>();
		list4.addAll(Arrays.asList(0,3,8,5,7,100,56,32));
		int[] twoNum4 = twoSum(list4, 37);
		
		System.out.println("Testcase2: " + list4 + " Target: 37");
		System.out.println("[" + twoNum4[0] + " " + twoNum4[1] +"]");
	}
}
