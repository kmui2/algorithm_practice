/*
Least Common Ancestry in Binary tree(not BST)
Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants. 
Example :


        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4
For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor 
Please note that LCA for nodes 5 and 4 is 5.

You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
There are no duplicate values.
You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
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
    static int n11,n22;
	static TreeNode fun(TreeNode root,int n1,int n2){
	    if(root==null)
	        return null;
	    TreeNode left=fun(root.left,n1,n2);
	    TreeNode right=fun(root.right,n1,n2);
	    if(n1==root.val)
	        n11=1;
	    if(n2==root.val)
	       n22=1;
	    if(n1==root.val || n2==root.val)
	        return root;
	    if(left!=null && right!=null)
	        return root;
	    if(left==null && right==null)
	        return null;
	    if(left==null)
	        return right;
	    else 
	        return left;
}
/*	    if(root == null || root.val == n1 || root.val == n2)  return root;
        TreeNode left = fun(root.left, n1, n2);
        TreeNode right = fun(root.right, n1, n2);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
	}
	*/
	public int lca(TreeNode root, int n1, int n2) {
	        n11=n22=0;
	      TreeNode re=fun(root,n1,n2);
	      int a;
	     
	      if(n11==0||n22==0)
	        return -1;
	      if(re==null)
	         a=-1;
	      else
	         a=re.val;
	      return a;
	      
	}
}
