/* 
missing number in repeated sorted array
int[] arr= {1,1,1,2,2,2,3,3,3,4,4,4,5,5,6,6,6};
int times = 3;

output = 5

process:
create a index_arr = {1,2,3,4,5,6}
take value in this array to find answer from arr.
*/

public class practice{
	
	int find_last_occurence(int[] arr, int num, int s, int e,int times){
		
		while(s<=e){
			int m=(e-s)/2+s;
			
			if((arr[m]==num) && ((m==arr.length-1) || (arr[m+1]>num))){
				return m;
			}
			else {
				if(arr[m]<=num){
					s=m+1;
				}
				else{
					e=m-1;
				}
			}
		}
		
		return -1; // should never occur
	}


	int missing_in_repeated_Util(int[] arr,int[] index_arr,int times, int start, int end){
		int last_occur=0;
		int calculated=0;
		while(start<=end){
			int mid = (end-start)/2 + start;
			last_occur = find_last_occurence(arr,index_arr[mid],0,arr.length-1,times);
			
			
			
			calculated = index_arr[mid] * times -1;
			
			//System.out.println("last occur for: "+index_arr[mid]+" ="+last_occur+" calculated="+calculated+" start="+start+" end="+end);
			
			if(last_occur == calculated){
				//go right
				start = mid+1;
			}
			else{
				//go left
				end=mid-1;
			}		
		}
		
		return index_arr[start];
		/*if(last_occur==calculated){
				return index_arr[start];
			}
			else{ //if(start==end && last_occur!=calculated)
				return index_arr[start]+1;
			}
			*/
	}


	int missing_in_repeated_sorted(int[] arr,int times){
		int[] index_arr = new int[arr[arr.length-1]];
		for(int i=0;i<index_arr.length;i++){
			index_arr[i]=i+1;
		}
		
		int res = missing_in_repeated_Util(arr, index_arr, times, 0, index_arr.length-1);
		
		return res;

	}

	public static void main(String[] args){
	practice obj = new practice();
	int[] arr= {1,1,1,2,2,2,3,3,3,4,4,4,5,5,6,6,6};
	int times = 3;

	System.out.println(obj.missing_in_repeated_sorted(arr,times));

	}
}	