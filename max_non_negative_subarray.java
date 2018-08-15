/*
Max Non Negative SubArray
Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

Example:

A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]
NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
NOTE 2: If there is still a tie, then return the segment with minimum starting index
*/

public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(A==null){return result;}
        
        int result_index=0;
        long result_sum=0;
        int result_count=0;
        
        int j=0;
        while(j<A.size()){
            if(A.get(j)<0){
                j++;
            }
            
            else{
            long temp_sum=0;
            int temp_count=0;
            boolean flag_for_index = false;
            int temp_index =0;
            
            while(j<A.size() && A.get(j)>=0){
                if(!flag_for_index){
                    temp_index=j;
                    flag_for_index=true;
                }
                temp_sum=temp_sum + A.get(j);
                temp_count++;
                j++;
            }
            
            if(temp_sum>result_sum || (temp_sum==result_sum && temp_count>result_count)){
                result_index = temp_index;
                result_sum = temp_sum;
                result_count = temp_count;
            }
            }
            
        }
        
        for(int i=result_index;i<A.size();i++){
            if(A.get(i)>=0){
                result.add(A.get(i));
            }
            else{
                break;
            }
        }
        
        return result;
        
    }
}
