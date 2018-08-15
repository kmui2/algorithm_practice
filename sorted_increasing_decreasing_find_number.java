/*
- Given an array, increasing first then descending. Find a given element

int[] arr = {5, 20, 30, 50, 40, 35, 20, 10, 7, 2, 1}
find index for b = 7
*/


package interview;


public class practice{
	
	public static int findIndex(int[] arr, int b){
		
		int last_index_in_sorted = findMax(arr);
		int res1 = findInAscending(arr,0,last_index_in_sorted,b);
		if(res1==-1){
			int res2 = findInDescending(arr,last_index_in_sorted+1,arr.length-1,b);
			return res2;
		}
		return res1;
	}

	public static int findMax(int[] arr){
		int start =0;
		int end = arr.length-1;
		int mid;	
		while(start<end){
			mid=(end-start)/2+start;
			
			if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
				return mid; //found max element
			}
			if(arr[mid]>arr[mid-1]){ //we are on left side of arr. It is Ascending sorted
				start=mid+1;
			}
			else{ 
				end=mid-1;
			}
		}
		return start;  //start==end and max must exist in an array so can return any index start or end
	}

	public static int findInAscending(int[] arr,int start,int end, int b){
		
		while(start<=end){
			int mid=(end-start)/2 + start;
			
			if(arr[mid]==b){
				return mid;
			}
			if(arr[mid]>b){
				end=mid-1;
			}
			else{
				start = mid+1;
			}
		}
		
		return -1; // b not found
	}


	public static int findInDescending(int[] arr,int start,int end, int b){
		
		while(start<=end){
			int mid=(end-start)/2 + start;
			
			if(arr[mid]==b){
				return mid;
			}
			if(arr[mid]>b){
				start = mid+1;
			}
			else{
				end = mid-1;
			}
		}
		
		return -1; // b not found
	}


	
		public static void main(String[] args){
			
			int[] arr = {5, 20, 30, 50, 40, 35, 20, 10, 7, 2, 1};
			int b=7;
			System.out.println(findIndex(arr,b));
		}
}
