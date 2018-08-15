/*Second largest element in BST
Given a Binary Search Tree(BST), find the second largest element.

Examples:

Input: Root of below BST
    10
   /
  5

Output:  5


Input: Root of below BST
        10
      /   \
    5      20
             \ 
              30 

Output:  20

Explanation: Need to perform reverse of in-order traversal
Note: using count as int as in "reverse_in_order_traversal2" does not work. But using count an object works fine.
*/


class Node{
	Node left;
	Node right;
	int value;
	
	Node(int value){
		this.value=value;
		left=right=null;
	}
}

class count{
	int c=0;
}
public class practice {

	// works fine
	void reverse_in_order_traversal(Node root, count C, int k){
		
		if(root==null){
			return;
		}
		reverse_in_order_traversal(root.right,C,k);
		C.c=C.c+1;
		//if(count==2)
		{
			System.out.println("2nd largest= "+root.value + "  count="+C.c);
			//return;
		}
		reverse_in_order_traversal(root.left,C,k);
		
	}

	//does not work
	void reverse_in_order_traversal2(Node root, int count, int k){
		
		if(root==null){
			return;
		}
		reverse_in_order_traversal2(root.right,count,k);
		count=count+1;
		//if(count==2)
		{
			System.out.println("2nd largest= "+root.value + "  count="+count);
			//return;
		}
		reverse_in_order_traversal2(root.left,count,k);
		
	}
	

	public static void main(String[] args)    {

	Node r = new Node(8);
	r.left =new Node(4);
	r.right = new Node(16);
	r.left.left = new Node(2);
	r.left.right = new Node(5);
	r.right.left = new Node(10);
	r.right.right = new Node(17);
	r.left.right.right = new Node(7);


	int k = 2;
	count C=new count();
	practice obj = new practice();
	
	obj.reverse_in_order_traversal(r,C,k);
	
	System.out.println("\n\n\n");
	
 	int count=0;
	obj.reverse_in_order_traversal2(r,count,k);


	}
	

}
