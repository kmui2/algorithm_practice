/*
Dynamic Programming | Set 6 (Min Cost Path)
Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost to traverse through that cell. Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination). You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.

For example, in the following figure, what is the minimum cost path to (2, 2)?
1	2	3
4	8	2
1	5	3

The path with minimum cost is highlighted in the following figure. The path is (0, 0) –> (0, 1) –> (1, 2) –> (2, 2). The cost of the path is 8 (1 + 2 + 2 + 3).
*/
int min(int a, int b, int c){
	if(a<b && a<c){
		return a;
	}
	if(b<a && b<c){
		return b;
	}
	if(c<a && c<b){
		return c;
	}
}


int min_cost(int[] cost_arr){
	
	int r = cost_arr.length;
	int c = cost_arr[0].length;
	
	int[][] min_cost_arr = new int[r][c];
	
	//assign minimum cost for the first row
	min_cost_arr[0][0] = cost_arr[0][0];
	for(int i=1;i<c;i++){
		min_cost_arr[0][i] = min_cost_arr[0][i-1]+cost_arr[0][i];
	}
	
	//assign minimum cost for the first column
	for(int i=1;i<r;i++){
		min_cost_arr[i][0] = min_cost_arr[i-1][0]+cost_arr[i][0];
	}
	
	//assign minimum cost for rest of the min_cost array
	for(int i=1;i<r;i++){
		for(int j=1;j<c;j++){
			min_cost_arr[i][j] = min(min_cost_arr[i][j-1],min_cost_arr[i-1][j],min_cost_arr[i-1][j-1])+cost_arr[i][j];
		}
	}
	
	return min_cost_arr[r-1][c-1];
}



//////////if we need to provide the path too: then we can use code below, put it before return call in method: min_cost. Or put in other place. This is just a module of how it can be achieved. Used bottom up approach.//////////////////

int m = r-1;  //may be different based on question
int n = c-1;  //may be different based on question

System.out.println(find_path(m,n));



ArrayList<ArrayList<Integer>> find_path(int m, int n){
	ArrayList<ArrayList<Integer>> result_path = new ArrayList<ArrayList<Integer>>();
	while(m>0 || n>0){
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(m);
		path.add(n);
		
		result_path.add(path);
		
		if((n-1)>=0){
			left_col = min_cost_arr[m][n-1];
		}
		else{
			left_col=Integer.MAX_VALUE;
		}
		if((m-1)>=0){
			top_row = min_cost_arr[m-1][n];
		}
		else{
			top_row=Integer.MAX_VALUE;
		}
		if((n-1)>=0 && (m-1)>=0){
			diagonal = min_cost_arr[m-1][n-1];
		}
		else{
			diagonal=Integer.MAX_VALUE;
		}
		
		if(left_col <= top_row && left_col<=diagonal){
			n=n-1;
		}
		else if(diagonal<=left_col && diagonal<=top_row){
			m=m-1; n=n-1;
		}
		else{
			m=m-1;
		}
	}
	
	Collections.reverse(result_path);
	return result_path;
	
}









