/*
Find if given matrix is Toeplitz or not
Given a square matrix, find if it’s a Toeplitz matrix or not. A Toeplitz (or diagonal-constant) matrix is a matrix in which each descending diagonal from left to right is constant, i.e., all elements in a diagonal are same.

In general, any n×n matrix mat[][] is a Toeplitz matrix if every cell mat[i][j] is same as mat[i-1][j-1], mat[i+1][j+1], mat[i-2][j-2], mat[i+2][j+2], .. for every cell mat[i][j] and all the valid cells mat[i+k][j+k] or mat[i-k][j-k]

Examples :

Input: mat[N][N] = {{ 6, 7, 8},
                    { 4, 6, 7},
                    { 1, 4, 6}},
Output : True;
Values in all diagonals are same.

Input: mat[N][N] = {{ 6, 7, 8, 9 },
                    { 4, 6, 7, 8 },
                    { 1, 4, 6, 7 },
                    { 0, 1, 4, 6 },
                    { 2, 0, 1, 4 }};
Output : True;

Input: mat[N][N] = {{ 6, 3, 8},
                    { 4, 9, 7},
                    { 1, 4, 6}},
Output : False;
*/



public class practice{
	
	boolean is_Toeplitz(int[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		
		//for each col in first row
		for(int i=0;i<col;i++){
		int temp_row=0,temp_col=i;
		int temp_init = matrix[temp_row][temp_col];
		temp_row++;
		temp_col++;
			
			while(temp_row<row && temp_col<col){
			int temp = matrix[temp_row][temp_col];
			if(temp_init==temp){
			temp_row++;
			temp_col++;
			}
			else{return false;}
			}
		}	
			
		//for each row in first col
		for(int i=1;i<row;i++){
		int temp_row=i,temp_col=0;
		int temp_init = matrix[temp_row][temp_col];
		temp_row++;
		temp_col++;
			
			while(temp_row<row && temp_col<col){
			int temp = matrix[temp_row][temp_col];
			if(temp_init==temp){
			temp_row++;
			temp_col++;
			}
			else{return false;}
			}
		}
		
		return true;
	}


	public static void main(String[] args){
	practice obj = new practice();
	int[][] arr= { 
			{ 6, 7, 8, 9 },
            { 4, 6, 7, 8 },
            { 1, 4, 6, 7 },
            { 0, 1, 4, 6 },
            { 2, 0, 1, 4 }
          };
	
	System.out.println(obj.is_Toeplitz(arr));

	}
}	

















