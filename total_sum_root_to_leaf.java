/*
Sum Root to Leaf Numbers
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers % 1003.

Example :

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.
*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
 public  int sumNumbers(TreeNode a) {
            if(a==null)
                return 0;
            int sum=0;
            int result = (postOrderSum(a,0))%1003;
            return result;

        }

        public  int  postOrderSum(TreeNode treenode, int str)
        {
            int left =0;
            int right =0;
            if(treenode.left== null && treenode.right== null)
                return (str*10+treenode.val)%1003;
            if(treenode.left!=null)
                left =   postOrderSum(treenode.left, (str*10+treenode.val)%1003);

            if(treenode.right!=null)
                right  =   postOrderSum(treenode.right, (str*10+treenode.val)%1003);

            return (right+left)%1003;
        }
}



////////////////  did not pass extreme test case . This is written by me ///////////////

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    
    ArrayList<Integer> sum_each_path = new ArrayList<Integer>();
    
    public void sumNumbersUtil(TreeNode root, ArrayList<Integer> path){
        
        if(root==null){
            return;
        }
        path.add(root.val);
        if(root.left==null && root.right==null){
            //compute each path
            long sum=0;
            for(int i=0;i<path.size();i++){
                sum= sum*10 + (long)path.get(i);
            }
            sum_each_path.add((int)sum%1003);
            
        }
        sumNumbersUtil(root.left,path);
        sumNumbersUtil(root.right,path);
        path.remove(path.size()-1);
    }
    
    public int sumNumbers(TreeNode A) {
        
        ArrayList<Integer> each_path = new ArrayList<Integer>();
        sumNumbersUtil(A,each_path);
        
        //calculate sum of all paths
        int total_sum=0;
        for(int i=0;i<sum_each_path.size();i++){
            total_sum = total_sum+sum_each_path.get(i);
        }
        
        return total_sum%1003;
    }
}
