/*
Kth Row of Pascal's Triangle
Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1]. 
Note:Could you optimize your algorithm to use only O(k) extra space?
*/

public class Solution {
    public ArrayList<Integer> getRow(int A) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        result.add(1);
        if(A==0){
            return result;
        }
        
        int row=1;
        while(A>=row){
            int col = 1;
            int prev_col=1;
            while(col<row){
                int val = result.get(col)+prev_col;
                prev_col = result.get(col);
                result.set(col,val);  //replacing value
                col++;
            }
            result.add(1);
            row++;
        }
        
        
        
        
        return result;
    }
}
