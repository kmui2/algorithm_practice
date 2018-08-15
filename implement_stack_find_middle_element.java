/*
Implement stack and find middle element in O(1)
*/

class Node{
	Node next;
	Node prev;
	int data;
	
	public Node(int d){
		this.next = null;
		this.prev = null;
		this.data = d;
	}
}

class myStack{
	Node top;
	Node mid;
	int count;
	
	public myStack(){
		this.top=null;
		this.mid=null;
		this.count=0;
	}
}

public class practice{
	
	public static void push(int d,myStack ms){
		Node n = new Node(d);
		if(ms.top==null){
			ms.top = n;
			ms.mid = n;
			count=1;
		}
		else{
			count++;
			ms.top.next = n;
			n.prev = ms.top;
			ms.top = n;
		}
	}
}











