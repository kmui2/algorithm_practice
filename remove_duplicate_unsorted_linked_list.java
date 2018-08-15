

/* remove duplicate from unsorted linked list
*/

  class LinkedListNode{
	String data;
	LinkedListNode next;
}
  
public class practice_2017 {

public LinkedListNode remove_duplicate(LinkedListNode n){
	HashMap<String,Boolean> hm= new HashMap<String,Boolean>();
	LinkedListNode head = n;
	hm.put(n.data,true);
	while(n.next!=null){
		if(hm.containsKey(n.next.data)){
			n.next = n.next.next;
		}
		else{
			hm.put(n.next.data,true);
			n=n.next;
		}
	}
	return head;
}
    public static void main(String[] args){
        LinkedListNode ln4 = new LinkedListNode();
        ln4.data ="a";
        ln4.next=null;
        LinkedListNode ln3 = new LinkedListNode();
        ln3.data ="t";
        ln3.next=ln4;
        LinkedListNode ln2 = new LinkedListNode();
        ln2.data ="a";
        ln2.next=ln3;
        LinkedListNode ln = new LinkedListNode();
        ln.data ="p";
        ln.next=ln2;
        practice_2017 obj= new practice_2017();
        LinkedListNode output= obj.remove_duplicate(ln);
        
        while(output!=null){
            System.out.println(output.data);
            output=output.next;
        }
        
    }
}