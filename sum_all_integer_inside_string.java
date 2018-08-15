/*
Given string, find sum of all integers inside.
"1abcd45" return 1+45 =46;
"233bc-23" return 233 + 23 = 256;
*/

package interview;

import java.util.ArrayList;
import java.util.List;

public class practice{
	
	public static int sumInt(String st){
		List<Integer> lst = new ArrayList<>();
		int i=0;
		int ind_sum=0; 
		while(i<st.length()){
			ind_sum=0;
			while(i<st.length() && Character.isDigit(st.charAt(i))){
				ind_sum=ind_sum*10 + Character.getNumericValue(st.charAt(i));
				i++;
			}
			lst.add(ind_sum);
			i++;
		}
		
		int result=0;
		for(int j:lst){
			result=result+j;
		}
		
		return result;
	}
	
	
		public static void main(String[] args){
					
			System.out.println(sumInt("233bc4a"));
		}
}
