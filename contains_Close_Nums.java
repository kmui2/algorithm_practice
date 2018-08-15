
/*
Given an array of integers nums and an integer k, determine whether there are two distinct indices i and j in the array where nums[i] = nums[j] and the absolute difference between i and j is less than or equal to k.

Example

For nums = [0, 1, 2, 3, 5, 2] and k = 3, the output should be
containsCloseNums(nums, k) = true.

There are two 2s in nums, and the absolute difference between their positions is exactly 3.

For nums = [0, 1, 2, 3, 5, 2] and k = 2, the output should be

containsCloseNums(nums, k) = false.

The absolute difference between the positions of the two 2s is 3, which is more than k.

*/

boolean containsCloseNums(int[] nums, int k) {  
    int len = nums.length;
    int rem = len-0; //remaining
    
    int it = k;
    
    
    for(int i=0;i<len;i++){
        rem = len-i-1;
        if(rem<k){
            it=rem;
        }
        for(int j=1;j<=it;j++){
            if(nums[i]==nums[i+j]){
                return true;
            }
        }
        
    }
    return false;
}

-------------OR----------------
boolean containsCloseNums(int[] nums, int k) {  
	for(int i=0;i<nums.length;i++){
		int j=1;
		while(j<=k && (i+j)<nums.length){
			if(nums[i]==nums[i+j]){
				return true;
			}
			j++;
		}
	}
	return false;
}
