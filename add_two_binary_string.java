/*
Program to add two binary strings
Given two binary strings, return their sum (also a binary string).

Example:

Input:  a = "11", b = "1"
Output: "100" 

Explanation: Because the values of '0', '1', '2', ... in ascii are ascending. So e.g. '0' in ascii is 48, '1' is 49, etc. So if you take '2' - '0' you really just get 50 - 48 = 2.
*/

String add_two_binary(String s1, String s2){
		int len1 = s1.length()-1;
		int len2 = s2.length()-1;
		StringBuilder res = new StringBuilder();
		int carry=0;
		int sum=0;
		
		while(len1>=0 || len2>=0){
			int temp1, temp2;
			if(len1>=0){
				temp1 = s1.charAt(len1)-'0';
				len1--;
			}
			else{
				temp1=0;
			}
			
			if(len2>=0){
				temp2=s2.charAt(len2)-'0';
				len2--;
			}
			else{
				temp2=0;
			}
			
			sum=temp1+temp2+carry;
			if(sum==2){
				sum=0;
				carry=1;
			}
			if(sum>2){
				sum=sum-2;
				carry=1;
			}
			res.append(sum==0?'0':'1');
			
			
		}
		if(carry!=0){
			res.append('1');
		}
		res.reverse();
		return res.toString();
	}
	