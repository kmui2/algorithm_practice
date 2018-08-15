/*
You have an array of integers nums and an array queries, where queries[i] is a pair of indices (0-based). Find the sum of the elements in nums from the indices at queries[i][0] to queries[i][1] (inclusive) for each query, then add all of the sums for all the queries together. Return that number modulo 109 + 7.

Example

For nums = [3, 0, -2, 6, -3, 2] and queries = [[0, 2], [2, 5], [0, 5]], the output should be
sumInRange(nums, queries) = 10.

The array of results for queries is [1, 3, 6], so the answer is 1 + 3 + 6 = 10.
*/

int sumInRange(int[] nums, int[][] queries) {
    int sum=0;
    for(int i=0;i<queries.length;i++){
        int start_index = queries[i][0];
        int end_index = queries[i][1];
        while(start_index<=end_index){
            sum=sum+nums[start_index];
            start_index++;
        }
    }
    if(sum<0){
        sum=1000000000+7+sum;
    }
    return sum;
}
