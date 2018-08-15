/*
Search for a Range
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm’s runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example:

Given [5, 7, 7, 8, 8, 10]

and target value 8,

return [3, 4].
*/


public class Solution {
	// DO NOT MODIFY THE LIST
	 public int find_first_occurence(final List<Integer> a, int x, int start, int end){
	  
	  if(end<start){
		  return -1;
	  }
	  
	  
	  int mid=(end-start)/2 + start;
	  
	  if(a.get(mid)==x && (mid==0 || a.get(mid-1)<x) ){
		  return mid;
	  }
	  else{
		  if(a.get(mid)<x){
				return find_first_occurence(a,x,mid+1,end);
		  }
		  else {
				return find_first_occurence(a,x,start,mid-1);
		  }
	  }
  }
	
	public int find_last_occurence(final List<Integer> a, int n, int x, int start, int end){
	  
	  if(end<start){
		  return -1;
	  }
	  
	  
	  int mid=(end-start)/2 + start;
	  
	  if(a.get(mid)==x && (mid==n-1 || a.get(mid+1)>x) ){
		  return mid;
	  }
	  else{
		  if(a.get(mid)>x){
				return find_last_occurence(a,n,x,start,mid-1);
		  }
		  else {
				return find_last_occurence(a,n,x,mid+1,end);
		  }
	  }
  }
	
	public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
	    
	    //first occurencce
	    int first = find_first_occurence(a, b, 0, a.size()-1);
	    int last = find_last_occurence(a, a.size(), b, 0, a.size()-1);
	    
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    result.add(first);
	    result.add(last);
	    
	    return result;
	}
}
