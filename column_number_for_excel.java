/*
Given a column title as appears in an Excel sheet, return its corresponding column number.

Example:

    A -> 1
    
    B -> 2
    
    C -> 3
    
    ...
    
    Z -> 26
    
    AA -> 27
    
    AB -> 28 
*/

public class Solution {
	public int titleToNumber(String a) {
	    
	    int len = a.length();
	    int result=0;
	    
	    for(int i=0;i<len;i++){
	        result = result*26 + (a.charAt(i)-'A'+1); //becasue 'A' = 65 and we need 'A'=1 i.e: 65-64 OR our character -64 OR our character - 'A'+1
	    }
	    
	    return result;
	    
	    
	    
	}
}
