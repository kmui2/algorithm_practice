/*
Write a function that takes an unsigned integer and returns the number of 1 bits it has.

Example:

The 32-bit integer 11 has binary representation

00000000000000000000000000001011
so the function should return 3.

Note that since Java does not have unsigned int, use long for Java
*/


public class Solution {
	public int numSetBits(long a) {
	    int result_count =0;
	    while(a>0){
	        int mod=(int)(a%2);
	        if(mod==1){
	            result_count++;
	        }
	        a=a>>1;
	    }
	return result_count;
	    
	}
	
}
////////////// alternate with & logic/////////////

public class Solution {
	public int numSetBits(long A) {
	    
	    int count = 0;
	    
	    while (A > 0) {
	        if ( (A & 1) != 0)
	            count++;
	        A >>= 1;
	    }
	    
	    return count;
	    
	}
}
