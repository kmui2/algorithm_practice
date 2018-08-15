/*
group all even numbers first then group all odd numbers. return the head of this linked list
*/

class Node{
	Node next;
	int val;
	
	public Node(int x){
		this.next = null;
		this.val = x;
	}
}

public class practice {
    
	boolean isOdd(int num) {
		if(num%2>0) {
			return true;
		}
		else return false;
	}
	
	
	Node even_odd(Node head){
		if(head==null || head.next==null){
			return head;
		}
		Node odd=null, even=null, oddhead=null, evenhead=null;
		
		
		while(head!=null){
			if(isOdd(head.val)){
				if(odd==null) {odd=head; oddhead=head;}
				else{
					odd.next=head;				
					odd=odd.next;
				}
			}
			else{
				if(even==null) {even=head;evenhead=head;}
				else{
					even.next=head;
					even=even.next;
				}				
			}
			head=head.next;
		}
		
		if(even!=null){
			even.next = oddhead;
			return evenhead;
		}
		else{
			return oddhead;
		}
	}
	  
	    /* Driver program to test lca() */
	    public static void main(String args[]) 
	    {
	        // Let us construct the BST shown in the above figure
	    	practice obj= new practice();
	        Node n1 = new Node(1);
	        Node n2 = new Node(2);
	        Node n3 = new Node(3);
	        Node n4 = new Node(4);
	        Node n5 = new Node(5);
	        n1.next=n2; n2.next=n3;n3.next=n4;n4.next=n5;
	        
	        Node n = obj.even_odd(n1);
	        
	        while(n!=null) {
	        	System.out.println(n.val);
	        	n=n.next;
	        }
	    }
}