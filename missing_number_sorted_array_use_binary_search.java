/*
missing number in sorted array
input: 0,1,2,4,5,6,7,8,9,10,11,12,13
input: 0,1,2,3,4,5,7,8,9,10,11,12,13
input: 1,2,3,4,5,6,7,8,9,10,11,12,13
input: 0,1,2,3,4,5,6,7,8,9,10,11,12
*/

int missing_number_util(int[] arr_num, int start, int end){
	
	while(start<end){
		int mid = (end-start)/2 + start;
		
		//go left
		if(mid<arr_num[mid]){
			end=mid-1;
		}
		//go right
		else{
			start=mid+1;
		}
	}
	//is start is >= end, then we have the answer 
	if(arr_num[start]!=start){
		return start;
	}
	else{
		return start+1;
	}
}

int missing_number(int[] arr_num){
	return missing_number_util(arr_num,0,arr_num.length-1);
}