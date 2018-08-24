

/*reverse in K-groups

1->2->3->4->5->6->7->null

pre->fake->1->2->3->4->5->6->7->null

pre->fake<-1<-2<-3  4->5->6->7->null
	  |_____________^



*/


class Node{

	int data;
	Node next;

	public Node(int d){
		this.data=d;
		this.next=null;
	}
	}

public class Practice {

		public Node reverse(Node fake, int k){
			
			//initializations for reversing the nodes
			Node reverseNode = fake;
			Node currentNode = fake.next;
			Node nextNode = fake.next.next;
			
			int i=1;
			
			while(i<k){
			
				currentNode.next=reverseNode;
				reverseNode=currentNode;
				currentNode = nextNode;
				nextNode= nextNode.next;
				
				i++;
			}
			
			currentNode.next=reverseNode;
			fake.next=nextNode;
			
			return currentNode;

		}

		public Node reverseKGroups(Node head, int k){

			Node pre =new Node(0);
			Node fake =new Node(0);
			int sz=0;
			int group_to_reverse=1; // group to reverse helps in calculating if we need to reverse the group i.e: if there are k items.
			
			Node result_head=null;
			
			pre.next=fake;
			fake.next=head;
			
			//get size of the list
			Node sz_runner = head;
			while(sz_runner!=null){
				sz++;
				sz_runner = sz_runner.next;
			}
			
			
			
			while(k*group_to_reverse<=sz){ // if this is true then there are enough elements to reverse
			
				//reverse the group	
				pre.next=reverse(fake, k);  // returns head of reversed group
				//pre.next= currentNode;
				
				//System.out.println("fake.next= "+fake.next.data); // test of fake node is updated here
				if(group_to_reverse==1) {//this is the first group and we have the result head
				
					result_head = pre.next;
				}
				//traverse pre node till before the fake node
				while(pre.next!=fake){
					pre=pre.next;
				}
			
			group_to_reverse++; // increase the group count
			}

			// we stop and do not reverse further
				pre.next = fake.next;
			
			
			return result_head;
			
		}

	
	
	public static void main(String[] args) {

		Practice obj = new Practice();
		int k=3;
		Node n = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		
		n.next=n2;
		n2.next=n3;
		n3.next=n4; 
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		n7.next=null;
		
		Node res = obj.reverseKGroups(n,k);
		
		while(res!=null){
			System.out.println(res.data);
			res=res.next;
		}
	}

}
