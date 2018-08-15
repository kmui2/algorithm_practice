/*
Convert a sorted Linked List to complete BST

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

Thoughts


If you are given an array, the problem is quite straightforward. But things get a little more complicated when you have a singly linked list instead of an array. Now you no longer have random access to an element in O(1) time. Therefore, you need to create nodes bottom-up, and assign them to its parents. The bottom-up approach enables us to access the list in its order at the same time as creating nodes.
*/

class Treenode{
	TreeNode left;
	TreeNode right;
	int val;
	public TreeNode(int v){
		this.val=v;
		this.left = null;
		this.right=null;
	}
}

class LLnode{
	LLnode next;
	int data;
	public LLnode(int d){
		this.data=d;
		this.next=null;
	}
}

public class practice{

LLnode head;

int get_length(LLnode h){
	int count=0;
	while(h!=null){
		count++;
		h=h.next;
	}
	return count;
}

TreeNode convert_to_bst(LLnode nodehead){
	if(head==null){
		return null;
	}
	head=nodehead;
	int len = get_length(nodehead);
	Treenode r = convert_to_bst_recur(0,len-1);
	return r;
}

TreeNode convert_to_bst_recur(int start, int end){
	if(end<start){
		return null;
	}
	
	int mid=(end-start)/2 + start;
	TreeNode left = convert_to_bst_recur(start,mid-1);
	TreeNode root = new TreeNode(head.data);
	head = head.next;
	TreeNode right = convert_to_bst_recur(mid+1,end);
	
	root.left = left;
	root.right=right;
	
	return root;
}

}