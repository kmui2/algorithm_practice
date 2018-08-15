/*
Build Lowest Number by Removing n digits from a given number
Given a string ‘str’ of digits and an integer ‘n’, build the lowest possible number by removing ‘n’ digits from the string and not changing the order of input digits.

Examples:

Input: str = "4325043", n = 3
Output: "2043"

Input: str = "765028321", n = 5
Output: "0221"

Input: str = "121198", n = 2
Output: "1118" 

Idea: instead of thinking which one to remove, think which one will be in result. We need to pick the first number in the result.
steps for last example "856394789"
1) what can the result start from: 8, 5, 6, 3 . this mean, if we start from "3" , it implies previous 3 digits are deleted. so pick the maximum from 8, 5, 6 to minimize the output num value. we pick 8.
2) now S= 56394789, d=2.  what can the result start from: 5, 6, 3 . this mean, if we start from "3" , it implies previous 2 digits are deleted. so pick the maximum from 5, 6 to minimize the output num value. we pick 6.
3) now S= 5394789, d=1.  what can the result start from: 5, 3 . this mean, if we start from "3" , it implies previous 1 digits are deleted. so pick the maximum from 5 to minimize the output num value. we pick 5.
4) now S=394789, d=0. we cannot delete any more as d=0. This is the result.

*/


public class practice{
	
	String min_num(String num, int digit, String result_prefix){

		if(digit>=num.length()){
			return result_prefix;
		}

		if(digit==0){
		return result_prefix+num;
		}
		int min=Integer.MAX_VALUE;
		int min_index=0;
		for(int i=min_index;i<=digit;i++){
			int each_value = Character.getNumericValue(num.charAt(i));
			if(each_value<min){
				min=each_value;
				min_index=i;
			}
		}

		return min_num(num.substring(min_index+1,num.length()),digit-min_index,result_prefix+num.charAt(min_index));

		}
	
	public static void main(String[] args){
	practice obj = new practice();
	String s1="4325043";
	int d1=3;
	String s2="765028321";
	int d2=5;
	String s3="121198";
	int d3=2;
	System.out.println(obj.min_num(s3,d3,""));
	}
}	
