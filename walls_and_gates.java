/*
Leetcode: Walls and Gates
You are given a m x n 2D grid initialized with these three possible values.
-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
Understand the problem:
It is very classic backtracking problem. We can start from each gate (0 point), and searching for its neighbors. We can either use DFS or BFS solution.
*/

void fill_matrix(int[][] matrix){
	
	if(matrix==null || matrix.length==0 || matrix[0].length==0){
		return;
	}
		
	int m=matrix.length;
	int n=matrix[0].length;
	
	int inf = INTEGER.MAX_VALUE;
	Queue<Integer> q= new LinkedList<Integer>();
	for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){
			if(matrix[i][j]==0){
				q.add(i*n+j); //save the index of this row and column
			}
		}
	}
	
	while(!q.isEmpty()){
			
			int index = q.remove();
			int r = index/n;
			int c = index%n;
			
			//add position with increase in row
			if((r+1)<m && matrix[r+1][c]==inf){
				q.add((r+1)*n+c);
				matrix[r+1][c]=matrix[r][c]+1;
			}
			//add position with decrease in row
			if((r-1)>=0 && matrix[r-1][c]==inf){
				q.add((r-1)*n+c);
				matrix[r-1][c]=matrix[r][c]+1;
			}
			//add position with increase in column
			if((c+1)<n && matrix[r][c+1]==inf){
				q.add(r*n+(c+1));
				matrix[r][c+1]=matrix[r][c]+1;
			}
			//add position with decrease in column
			if((c-1)>=0 && matrix[r][c-1]==inf){
				q.add(r*n+(c-1));
				matrix[r][c-1]=matrix[r][c]+1;
			}
	}
}

























