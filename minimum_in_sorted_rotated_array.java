/*
Find the minimum element in a sorted and rotated array
A sorted array is rotated at some unknown point, find the minimum element in it.

Following solution assumes that all elements are distinct.

Examples

Input: {5, 6, 1, 2, 3, 4}
Output: 1

Input: {1, 2, 3, 4}
Output: 1

Input: {2, 1}
Output: 1
*/

public int find_min(int[] arr, int start, int end){

//if array not rotated
if(end<start){
	return arr[0];
}
//if only 1 element left
if(start == end){
	return arr[start];
}

int mid = (end-start)/2 + start;

if((mid>start) && arr[mid]<arr[mid-1]){
	return arr[mid];
}
else if((mid<end) && arr[mid]>arr[mid+1]){
	return arr[mid+1];
}
else{
	if(arr[mid]<arr[end] ){
		return find_min(arr,start,mid-1);
	}
	else{
		return find_min(arr,mid+1,end);
	}
}

}
////////////////////

public int find_min(int[] arr){
	
	int start=0; int end = arr.length-1;
	
	while(start<=end){
		int mid = (end-start)/2 + start;
		
		if(start==end){return arr[start];}
		else if ((mid>start) && arr[mid]<arr[mid-1]) {return arr[mid];}
		else if((mid<end) && arr[mid]>arr[mid+1]){return arr[mid+1];}
		else {
			if(arr[mid]<arr[end] ){
				end=mid-1;
			}
			else{
				start = mid+1;
			}
		}

	}
	return -1;  //if no return from while
}