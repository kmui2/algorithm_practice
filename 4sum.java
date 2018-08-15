/*
4 Sum
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
Example : 
Given array S = {1 0 -1 0 -2 2}, and target = 0
A solution set is:

    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    (-1,  0, 0, 1)
Also make sure that the solution set is lexicographically sorted.
Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR (Solution[i][0] == Solution[j][0] AND ... Solution[i][k] < Solution[j][k])

time: N to the power (k-1)
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if(A==null || A.size()<4){
            return res;
        }
        
        
        Collections.sort(A);
        int sz =A.size();
        for(int i=0;i<sz-3;i++){
            for(int j=i+1;j<sz-2;j++){
                int k=j+1;
                int l=sz-1;
                
                int sum1 = A.get(i)+A.get(j);
                int diff = B-sum1;
                
                
                while(k<l){
                    int sum_k_l =A.get(k)+A.get(l);
                    if(sum_k_l==diff){
                        //enter in Arraylist
                        ArrayList<Integer> sub = new ArrayList<Integer>();
                        sub.add(A.get(i));
                        sub.add(A.get(j));
                        sub.add(A.get(k));
                        sub.add(A.get(l));
                        //to get unique sub array
                        if(!res.contains(sub)){
                            res.add(sub);
                        }
                        
                        
                        k++;
                        l--;
                        
                        
                    }
                    else if(sum_k_l>diff){
                        l--;
                    }
                    else{
                        k++;
                    }
                    
                    
                }
                
            }
        }
        return res;
    }
}
