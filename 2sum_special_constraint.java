/*
2 Sum
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based. 
Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.

Input: [2, 7, 11, 15], target=9
Output: index1 = 1, index2 = 2

Test case:
A : [ 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8 ]
B : -3
The expected returned value :
4 8 
*/


public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
       
       ArrayList<Integer> output = new ArrayList<Integer>();
	    HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
	    for(int i = 0 ; i < A.size() ; i++ ){
	        if(m.get(B-A.get(i)) == null){
	            if(m.get(A.get(i)) == null)
	                m.put(A.get(i),i);
	        } 
	        else{
	            output.add(1+m.get(B-A.get(i)));
	            output.add(i+1);
	            return output;
	        }
	    }
	    return output;
    }

////////////////////////Below code did not pass test case provided in question/////////////////

public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
       
       ArrayList<Integer> output = new ArrayList<Integer>();
	    HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
	    for(int i = 0 ; i < A.size() ; i++ ){
	        if(!m.containsKey(A.get(i))){
	            m.put(A.get(i),i);
	        }
	        
	    }
	    for(int i = 0 ; i < A.size() ; i++ ){
	        int c= B-A.get(i);
	        if(m.containsKey(c)){
	            output.add(i+1);
	            output.add(m.get(c)+1);
	            break;
	        }
	    }
	    return output;
    }
	
	////////////////////////////2 sum////////////////////////
	public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}