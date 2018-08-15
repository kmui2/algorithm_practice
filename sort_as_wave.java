/*
Given an array of integers, sort the array into a wave like array and return it, 
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

Example

Given [1, 2, 3, 4]

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]
NOTE : If there are multiple answers possible, return the one thats lexicographically smallest. 
So, in example case, you will return [2, 1, 4, 3]
*/

public class Solution {
	public ArrayList<Integer> wave(ArrayList<Integer> a) {
	    
	    if(a.size()<=1){
	        return a;
	    }
	    
	    //sort arraylist in ascending order
	    Collections.sort(a);
	    //swap 2 elements
	    int temp1,temp2;
	    int sz = a.size();
	    int i=0,j=1;
	    while(i<sz-1 && j<sz){
	        temp1 = a.get(i);
	        temp2 = a.get(j);
	        a.set(i,temp2);
	        a.set(j,temp1);
	        i=i+2;
	        j=j+2;
	        
	    }
	    
	    return a;
	}
}
