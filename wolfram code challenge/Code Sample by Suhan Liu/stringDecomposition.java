/**
 * String Decomposition
 * 
 * Given a string with letters and brackets, '[' and ']'. 
 * The numbers right before '[' represents the number of
 * duplicates for the content within the brackets. This
 * program decompose the original string into the string
 * without any brackets. For example, 2[ab]cd -> ababcd.
 * 2[ab2[c]]d -> abccabccd
 * <p>
 * After reviewing this project, I'm thinking about using
 * recursion or two stacks to do it. In this version, I 
 * used the recursion to do it.
 * 
 * @author  Suhan Liu
 * @param 	str 	The string for decomposition
 * @return  		The string that has been extended
 *
 */

public class stringDecomposition {
	
	public static int index;
	
	/*
	 * The function to consider the corner case and 
	 * initialize the recursion function
	 */
	
	public static String decomposition(String str){
		if(str == null || str.length() == 0){
			return null;

		}
		
		int duplicate = 1;
		index = 0;
		
		StringBuilder finalString = new StringBuilder();
		
		while(index < str.length()){
			if(str.charAt(index) <= '9' && str.charAt(index) >= 2){
				duplicate = str.charAt(index) - '0';
				index += 2;
			}
			
			finalString.append(findDec(str, duplicate));
			
			index++;
			
			duplicate = 1;
		}
		
		return finalString.toString();
		
	}
	
	/*
	 * Recursion function to find decomposition
	 */
	
	public static String findDec(String str, int duplicate){
		StringBuilder sb = new StringBuilder();
		while((index < str.length()) && 
				str.charAt(index) != ']'){
			if((str.charAt(index) <= 'z' && str.charAt(index) >= 'a') || 
				(str.charAt(index) <= 'Z' && str.charAt(index) >= 'A')){
				sb.append(str.charAt(index));
				index++;
			}else if(str.charAt(index) <= '9' && str.charAt(index) >= '2'){
				char ch = str.charAt(index);
				index += 2;

				String recur = findDec(str, ch - '0');
				sb.append(recur);
				
				index++;
			}
			
			
		}
		
		StringBuilder result  = new StringBuilder();
		
		for(int i = 0; i < duplicate; i++){
			result.append(sb);
		}
		
		return result.toString();
	}
	
	public static void main(String[] args){
		
		//Testcases
		String str = "2[ab3[d]z]2[cc]";
		System.out.println(decomposition(str));
		System.out.println(decomposition(""));
		System.out.println(decomposition("aaa"));
		System.out.println(decomposition("a9[a]"));
		System.out.println(decomposition("2[2[3[2[a]b]c]d]e"));
	}
}
