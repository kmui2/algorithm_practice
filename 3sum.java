/*
Find a triplet that sum to a given value
Given an array and a value, find if there is a triplet in array whose sum is equal to the given value. If there is such a triplet present in array, then print the triplet and return true. Else return false. For example, if the given array is {12, 3, 4, 1, 6, 9} and given sum is 24, then there is a triplet (12, 3 and 9) present in array whose sum is 24.
*/

public static boolean sum3(int[] arr,int given_sum){
	Arrays.sort(arr);
	for(int i=0;i<arr.length-2;i++){
		int j=i+1;
		int k=arr.length-1;
		
		while(j<k){
			
			int sum = arr[i]+arr[j]+arr[k];
			if(sum==given_sum){
				System.out.println(arr[i]+","+arr[j]+","+arr[k]);	
				return true;
			}
			else if (sum <given_sum){
				j++;
			}
			else if (sum >given_sum){
				k--;
			}
			
		}
		
	}
    
    return false;
				
}

public static void main(String[] args){
	int[] arr=12,3,4,1,6,9};
	int given_sum=24;
	System.out.println(sum3(arr,given_sum));
	
}

