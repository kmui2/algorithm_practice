/*
Lowest Common Ancestor in a Binary Search Tree.
Given values of two values n1 and n2 in a Binary Search Tree, find the Lowest Common Ancestor (LCA). You may assume that both the values exist in the tree.

BST_LCA
LCA of 10 and 14 is 12
LCA of 14 and 8 is 8
LCA of 10 and 22 is 20
*/
class Node 
{
    int data;
    Node left, right;
  
    Node(int item) 
    {
        data = item;
        left = right = null;
    }
}

public class practice {
    
	    Node root;
	      
	    /* Function to find LCA of n1 and n2. The function assumes that both
	       n1 and n2 are present in BST */
	    Node lca(Node node, int n1, int n2) 
	    {
	        if (node == null)
	            return null;
	  
	        if ((n1>= node.data && n2<=node.data) || (n1<=node.data && n2>=node.data)){
	        	return node;
	        }


	        
	        // If both n1 and n2 are smaller than root, then LCA lies in left
	        if (node.data > n1 && node.data > n2)
	            return lca(node.left, n1, n2);
	  
	        // If both n1 and n2 are greater than root, then LCA lies in right
	        if (node.data < n1 && node.data < n2) 
	            return lca(node.right, n1, n2);
	  
	       return node;
	    }
	  
	    /* Driver program to test lca() */
	    public static void main(String args[]) 
	    {
	        // Let us construct the BST shown in the above figure
	    	practice tree = new practice();
	        tree.root = new Node(20);
	        tree.root.left = new Node(8);
	        tree.root.right = new Node(22);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(12);
	        tree.root.left.right.left = new Node(10);
	        tree.root.left.right.right = new Node(14);
	  
	        int n1 = 10, n2 = 14;
	        Node t = tree.lca(tree.root, n1, n2);
	        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
	  
	        n1 = 14;
	        n2 = 8;
	        t = tree.lca(tree.root, n1, n2);
	        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
	  
	        n1 = 10;
	        n2 = 22;
	        t = tree.lca(tree.root, n1, n2);
	        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
	  
	    }
}

