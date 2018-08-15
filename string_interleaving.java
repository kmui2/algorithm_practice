/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example,
Given:

s1 = "aabcc",
s2 = "dbbca",
When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/

public class Solution {
	public int isInterleave(String a, String b, String c) {
	   //check null case
	   if(a==null || b==null){
	       if (a==null && b.equals(c)){
	           return 1;
	       }
	       else if(b==null && a.equals(c)){
	           return 1;
	       }
	       else return 0;
	   }
	   //if sum of length is not same to length of C
	   if(c.length()!=a.length()+b.length()){
	       return 0;
	   }
	   
	   //create matrix for dP
	   int row=b.length()+1;
	   int column=a.length()+1;
	   int[][] mat = new int[row][column];
	   char[] a_arr=a.toCharArray();
	   char[] b_arr=b.toCharArray();
	   char[] c_arr=c.toCharArray();
	    
	    //put mat[0][0] = true as it is interleave in all case.
	    mat[0][0]=1;
	    
	    //value for first row and all column
	    for(int j=1;j<column;j++){
	        if(c_arr[j-1]==a_arr[j-1] && mat[0][j-1]==1){
	            mat[0][j]=1;
	        }
	        else{
	            mat[0][j]=0;
	        }
	    }
	    //value for first column and all row
	    for(int i=1;i<row;i++){
	        if(c_arr[i-1]==b_arr[i-1] && mat[i-1][0]==1){
	            mat[i][0]=1;
	        }
	        else{
	            mat[i][0]=0;
	        }
	    }
	    
	    //assign value for remaining cells in matrix mat[][]
	    for(int i=1;i<row;i++){
	        for(int j=1;j<column;j++){
	            if(c_arr[i+j-1]==a_arr[j-1] && mat[i][j-1]==1){
	                mat[i][j]=1;
	            }
	            else if(c_arr[i+j-1]==b_arr[i-1] && mat[i-1][j]==1){
	                mat[i][j]=1;
	            }
	            else{
	                mat[i][j]=0;
	            }
	        }
	    }
	    
	    return mat[row-1][column-1];
	    
	    
	    
	}
}
