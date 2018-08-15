
/*
Determine if a given singly linked list is a circular linked list or has null node.
*/

boolean is_circular(LinkedListNode n1){
	LinkedListNode runner1 = n1.next;
	if(runner1==null){
		return false;
	}
	LinkedListNode runner2 = n1.next.next;
	
	while(runner2!=null && runner2.next!=null){
		if(runner1==runner2){
			return true;
		}
		runner1=runner1.next;
		runner2=runner2.next.next;
	}
	return false;
}

/////////////////

boolean is_circular(LinkedListNode n1){
	LinkedListNode runner1 = n1;
	LinkedListNode runner2 = n2;
	
	
	while(runner2!=null && runner2.next!=null){
		
		runner2=runner2.next.next;
		if(runner1==runner2){
			return true;
		}
		else{
			runner1=runner1.next;
		}
		
	}
	return false;
}