/*
LeetCode – Convert Sorted Array to Binary Search Tree (Java)
 
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

*/

class TreeNode{
	TreeNode left;
	TreeNode right;
	
	int value;
	
	public TreeNode(int value){
		this.left=null;
		this.right=null;
		this.value=value;
	}
	
	//initial values are (arr, 0, arr.length-1)
	public Treenode createBST(int[] arr, int start, int end){
		
		if(end<start){
			return null;
		}
		
		int mid=(end-start)/2 +start;
		
		TreeNode root = new TreeNode(arr[mid]);
		root.left = createBST(arr,start,mid-1);
		root.right=createBST(arr,mid+1,end);
		
		return root;
						
	}
	
}