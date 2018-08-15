/*
LeetCode – Validate Binary Search Tree (Java)
 
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/

//Recursive

boolean is_BST(Node root, int min, int max){
	
	if(root==null){
		return true;
	}
	if(root.value<=min){
		return false;
	}
	if(root.value>=max){
		return false;
	}
	
	return is_BST(root.left,min,root.value) && is_BST(root.right,root.value,max);
}

//Iterative
class BNode{
	Node n;
	int min;
	int max;
	public BNode(Node n, int minval, int maxval){
		this.n = n;
		this.min = minval;
		this.max = maxval;
	}
}
boolean is_BST(Node root){

		Queue<BNode> q = new LinkedList<BNode>();
		q.add(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
		
		while(!q.isEmpty()){
			BNode b = q.poll();
			if(b.n.val <=b.min || b.n.val >=b.max){
				return false;
			}
			if(b.n.left!=null){
				q.add(b.n.left,min,b.n.val);
			}
			if(b.n.right!=null){
				q.add(b.n.rigth,b.n.val,max);
			}
		}
		
		return true;
}












