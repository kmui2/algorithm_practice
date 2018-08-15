/*
You have a method rand7() that generates a random integer from 1 to 7. Use it to write a method rand5() that generates a random integer from 1 to 5.
*/

int rand5(){

int result = 6;

while(result>5){
result = rand7();
}

return result;

}

/*
You have a method rand5() that generates a random integer from 1 to 5. Use it to write a method rand7() that generates a random integer from 1 to 7.
*/

int rand7(){
	
	int[][] arr = new int[][]{
		{1,2,3,4,5},
		{6,7,1,2,3},
		{4,5,6,7,1},
		{2,3,4,5,6},
		{7,0,0,0,0}
	};
	
	while(true){
		int row = rand5() -1;
		int col = rand5() -1;
	
		if(arr[row][col]==0){
			continue;
		}
		
		return arr[row][col];
}










