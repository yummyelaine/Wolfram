/**
 * Challenge 3 - Java version of "GatherBy" function
 * <p>
 * It takes a List and an Arbitrary Function, and returns a new 
 * List of Lists contains the objects of the input list in order 
 * of first appearance where each sublist contains those elements 
 * for which the function returned the same result.
 * <p>
 * The methods to be invoked are stored in a separate class called
 * "methodCls" for testing. 
 * <p>
 * I use HashMap to solve this problem. Key is the unique objects
 * in the given list. Values are lists containing elements who has 
 * the same values after running the given function using those
 * elements as input values.
 * 
 * @author Suhan Liu
 * @param list  	a list of inputs for the function
 * @param funcName  the method name 			
 */


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Challenge3 {
	public static List<List<Object>> gatherBy(List<?> list, String funcName) 
											throws IllegalAccessException, 
												   IllegalArgumentException, 
												   InvocationTargetException{
		
		List<List<Object>> result = new ArrayList<List<Object>>();
		HashMap<Object,List<Object>> map = new HashMap<Object,List<Object>>();
		try {
			Class<?> cls = Class.forName("methodCls");
			Object obj = cls.newInstance();
			Method[] method = cls.getMethods();
			int index = 0;
			
			for(int i = 0; i < method.length; i++){
				if(funcName.equals(method[i].getName())){
					
					index = i;
					break;
				}
			}
			
			for(int j = 0; j < list.size(); j++){
				Object value = method[index].invoke(obj, list.get(j));
				if(map.containsKey(value)){
					List<Object> temp = map.get(value);
					Object o = list.get(j);
					temp.add(o);
					map.put(value, temp);
				}else{
					List<Object> temp = new ArrayList<Object>();
					Object o = list.get(j);
					temp.add(o);
					map.put(value, temp);
				}
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("No class found!");
		} catch (InstantiationException e) {
			System.out.println("Instantiation Exception!");
		} catch (IllegalAccessException e){
			System.out.println("Illegal Access");
		}
		
		for(Object val : map.keySet()){
			result.add(map.get(val));
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IllegalAccessException, 
												  IllegalArgumentException, 
												  InvocationTargetException{
		/*
		 * Testcase 1 for "OddQ" Method 
		 * Input is an integer
		 * Return "true" if the number is odd
		 * Return "false if the number is even 
		 */
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(32);
		list.add(11);
		list.add(22);
		list.add(24);
		list.add(75);
		list.add(77);
		list.add(99);
		list.add(102);
		
		List<List<Object>> gatherby = gatherBy(list, "OddQ");
		System.out.println("Testcase 1: OddQ ");
			
		System.out.println(gatherby);
		
		System.out.println("");
		
		/*
		 * Testcase 2 for "First" Method 
		 * Input is a list of characters
		 * Return the first character in the list
		 */
		
		List<Character> firstList1 = new ArrayList<Character>();
		firstList1.add('a');
		firstList1.add('1');
		List<Character> firstList2 = new ArrayList<Character>();
		firstList2.add('b');
		firstList2.add('2');
		List<Character> firstList3 = new ArrayList<Character>();
		firstList3.add('a');
		firstList3.add('0');
		List<Character> firstList4 = new ArrayList<Character>();
		firstList4.add('c');
		firstList4.add('2');
		List<Character> firstList5 = new ArrayList<Character>();
		firstList5.add('a');
		firstList5.add('3');
		List<Character> firstList6 = new ArrayList<Character>();
		firstList6.add('b');
		firstList6.add('6');
		
		List<List<Character>> firstList= new ArrayList<List<Character>>();
		firstList.add(firstList1);
		firstList.add(firstList2);
		firstList.add(firstList3);
		firstList.add(firstList4);
		firstList.add(firstList5);
		firstList.add(firstList6);
		
		List<List<Object>> first = gatherBy(firstList, "First");
		
		System.out.println("Testcase 2: First ");
		
		System.out.println(first);
		
		
		List<Integer> testSet3 = new ArrayList<Integer>();
		for(int i=0;i<100;i++)
			testSet3.add(i);
		
		System.out.println("Testcase 3: %3 ");
		System.out.println(gatherBy(testSet3, "modThree"));
		
	}
}
