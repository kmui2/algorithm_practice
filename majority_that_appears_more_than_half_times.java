/*
MAJORITY
Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example :

Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2. 
*/

//since the question says that it guarantees the majority element always exist in the array, we can do as below. Else, the alternative solution is universal.

public class Solution {
	public int majorityElement(final List<Integer> a) {
	    
	    int majority_element = a.get(0);
	    int count=1;
	    
	    for(int i=1;i<a.size();i++){
	        
	        if(majority_element==a.get(i)){
	            count++;
	        }
	        else if(count==1){
	            majority_element = a.get(i);
	        }
	        else {
	            count--;
	        }
	    }
	    
	    return majority_element;
	}
}

//alternative universal solution





public class Solution {
	public int majorityElement(final List<Integer> A) {
	    
	    if (A == null)
	        return -1;
	        
	    int maj = A.get(0);
	    int count = 1;
	    int n = A.size();
	    
	    for (int i = 1; i < n; i++) {
	        if (A.get(i) == maj) {
	            count++;
	        } else if (count == 1) {
	            maj = A.get(i);
	        } else {
	            count--;
	        }
	    }
	    
	    count = 0;
	    
	    for (int i = 0; i < n; i++) {
	        if (A.get(i) == maj)
	            count++;
	    }
	    
	    if (count > n / 2)
	        return maj;
	        
	    return -1;
	    
	    
	}
}
