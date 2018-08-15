/*
Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example :

Input :

A : [1 5 3]
k : 2
Output :

1
as 3 - 1 = 2

Return 0 / 1 for this problem.
*/

public class Solution {
	public int diffPossible(final List<Integer> a, int b) {
	    
	    Map<Integer,Integer> mp = new HashMap<Integer,Integer>();
	    
	    for(int i=0;i<a.size();i++){
	        int k = a.get(i);
	        if(!mp.containsKey(k)){
	            mp.put(k,1);
	        }
	        else{
	            mp.put(k,mp.get(k)+1);
	        }
	    }
	    
	    for(int i=0;i<a.size();i++){
	        int ai =a.get(i);
	        mp.put(ai,mp.get(ai)-1);
	        int aj = ai-b;
	        if(mp.containsKey(aj) && mp.get(aj)>=1){
	            return 1;
	        }
	        mp.put(ai,mp.get(ai)+1);
	    }
	    
	    return 0;
	}
}
