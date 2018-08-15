/*
PASCAL1
Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
*/

public class Solution {
	public ArrayList<ArrayList<Integer>> generate(int a) {
	    
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    if (a==0){ 
	        return result;
	    }
	    
	    //for first list
	    ArrayList<Integer> row = new ArrayList<Integer>();    
	    row.add(1);
	    result.add(row);
	        
	    
	    
	    int i=1;
	    
	    while(i<a){
	        ArrayList<Integer> row2 = new ArrayList<Integer>();    
	        ArrayList<Integer> prev_row = result.get(i-1); 
	        //first element
	        row2.add(1);
	        for(int j=1;j<prev_row.size();j++){
	            row2.add(prev_row.get(j)+prev_row.get(j-1));
	        }
	        //last element
	        row2.add(1);
	        result.add(row2);
	        i++;
	    }
	    
	    return result;
	}
}
