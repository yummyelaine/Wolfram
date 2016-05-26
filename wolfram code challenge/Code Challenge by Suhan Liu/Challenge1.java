/**
 * Write a utility class/method that takes an int[] and returns the sum 
 * of the largest three even numbers in the array. If there are fewer 
 * than three even numbers, return 0.
 * <p>
 * First, I sort the array by ascending order. Then I scan the array one
 * by one from the end to the start. Find the largest three even numbers
 * and calculate the sum.
 * 
 * @author Suhan Liu
 * @param	num		An array of integers
 * @return			If there are less than two even numbers in the array,
 * 					return 0. If there are more than three even numbers. 
 * 
 */

import java.util.Arrays;

public class Challenge1 {

	public static int Max3Sum(int[] num){
		
		if(num.length < 3){
			return 0;
		}
		
		Arrays.sort(num);
		
		int countEven = 0;
		int sum = 0;
		int index = num.length - 1;
		
		while(countEven < 3 && index >= 0){
			if(num[index] % 2 == 0){
				countEven++;
				sum += num[index];
			}
			
			index--;
		}
		
		if(countEven < 3){
			return 0;
		}
		
		return sum;
	}
		
	public static void main(String[] args){
	
		//Testcase 1
				int[] num = {0,1};
				System.out.println("Testcase 1: " + "[0,1] Sum: " + 
									Max3Sum(num));
		
		//Testcase 2
		int[] num2 = {4,2,2,3,5,0};
		System.out.println("Testcase 2: " + "[4,2,2,3,5,0] Sum: " + 
							Max3Sum(num2));
		
		//Testcase 3
		int[] num3 = {3,5,0,2,7,11};
		System.out.println("Testcase 3: " + "[3,5,0,2,7,11] Sum: " + 
							Max3Sum(num3));
		
		//Testcase 4
		int[] num4 = {1,1,2,1,2,2};
		System.out.println("Testcase 4: " + "[1,1,2,1,2,2] Sum: " + 
							Max3Sum(num4));
		
	}
		
	

}
