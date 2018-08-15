
/*
Given a list 1,0,3,5,0,0,34,5,0,36 push all the zeroes to  the end. Develop an in-place algorithm

Expected output: 1,3,5,34,5,36,0,0,0,0
*/

public static void main(String[] args){
	int[] num_arr={0,0,0,0,0,3,5,0,0,34,5,0};
	int len = num_arr.length;
	int zero_index=0;
	
	for(int i=0;i<len;i++){
		if(num_arr[i]!=0){
			num_arr[zero_index]=num_arr[i];
			if(i>zero_index){
				num_arr[i]=0;
			}
			zero_index++;
		}
	}
	System.out.println(Arrays.toString(num_arr));	
}