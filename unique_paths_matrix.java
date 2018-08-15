/*
LeetCode – Unique Paths (Java)
 
A robot is located at the top-left corner of a m x n grid. It can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.

How many possible unique paths are there?
*/

int unique_paths(int[][] matrix){
	if(matrix==null){
		return 0;
	}
	int m=matrix.length;
	int n=matrix[0].length;
	
	if(m==1 || n==1){
		return 1;
	}
	
	//for dynamic programming, create an array to store unique paths per cell
	int[][] unique_path = new int[m][n];
	//assign 1 for left column as there is only 1 path to reach the left column cells from top-left corner
	for(int i=0;i<m;i++){
		unique_path[i][0]=1;
	}
	//assign 1 for top row as there is only 1 path to reach the top row cells from top-left corner
	for(int i=0;i<n;i++){
		unique_path[0][i]=1;
	}
	
	//assign value for all remaining cells
	for(int i=1;i<m;i++){
		for(int j=1;j<n;j++){
			unique_path[i][j]= unique_path[i-1][j]+unique_path[i][j-1];
		}
	}
	
	return unique_path[m-1][n-1];
	
}