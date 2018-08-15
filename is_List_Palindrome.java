
/*
Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in l, since this is what you’ll be asked to do during an interview.

Given a singly linked list of integers, determine whether or not it’s a palindrome.

Example

For l = [0, 1, 0], the output should be
isListPalindrome(l) = true;
For l = [1, 2, 2, 3], the output should be
isListPalindrome(l) = false.
*/


// Definition for singly-linked list:
 class ListNode<T> {
   ListNode(T x) {
     value = x;
   }
   T value;
   ListNode<T> next;
 }

  
public class practice_2017 {

 boolean isListPalindrome(ListNode<Integer> l) {
    
      int length=0;
    ListNode<Integer> head=l;
    ListNode<Integer> currentNode =l;
    ListNode<Integer> reverseNode=null;
    ListNode<Integer> second_half_start=l;
    while (l!=null){
        length++;
        l=l.next;
    }
    if(length==0 || length==1){return true;}
    int half_len = length/2;
    
    for(int i=0;i<half_len;i++){        
        second_half_start=second_half_start.next;
    }
        System.out.println("length="+length+"length%2="+length%2);
    if(length%2!=0){
        second_half_start= second_half_start.next;
    }
    
    ListNode<Integer> nextNode=currentNode.next;
    for(int i=1;i<half_len;i++){
        currentNode.next = reverseNode;
        reverseNode=currentNode;
        currentNode=nextNode;
        nextNode=nextNode.next;        
        
    }
    head=currentNode;
    head.next = reverseNode;
     
    
    for(int i=0;i<half_len;i++){
        //System.out.println("Rev:"+head.value);
        //System.out.println("second half:"+second_half_start.value);
        if(!(head.value).equals(second_half_start.value)){
            return false;
        }
        head=head.next;
        second_half_start=second_half_start.next;
    }
    return true;  
}

    public static void main(String[] args){
        
        ListNode<Integer> ln6 = new ListNode<Integer>(1);
        ln6.next=null;
        ListNode<Integer> ln5 = new ListNode<Integer>(10);
        ln5.next=ln6;
        ListNode<Integer> ln4 = new ListNode<Integer>(2);
        ln4.next=ln5;
        ListNode<Integer> ln3 = new ListNode<Integer>(2);
        ln3.next=ln4;
        ListNode<Integer> ln2 = new ListNode<Integer>(10);
        ln2.next=ln3;
        ListNode<Integer> ln = new ListNode<Integer>(1);
        ln.next=ln2;
        practice_2017 obj= new practice_2017();
        
        System.out.println(obj.isListPalindrome(ln));
        
    }
}


------------------------OR----------------------

class ListNode<T> {
   ListNode(T x) {
     value = x;
   }
   T value;
   ListNode<T> next;
 }
 public class practice_2017 {

     ListNode<Integer> reverse(ListNode<Integer> head2){
         ListNode<Integer> revNode = null;
         ListNode<Integer> currNode = head2;
         ListNode<Integer> nextNode = currNode.next;
         
         while(nextNode!=null){
             currNode.next = revNode;
             revNode=currNode;
             currNode=nextNode;
             nextNode=nextNode.next;
         }
         currNode.next=revNode;
         
         return currNode;
     }
     
     boolean isListPalindrome(ListNode<Integer> l) {
     
     if(l==null){return false;}
     ListNode<Integer> head = l;
     
     ListNode<Integer> runner1=l;
     ListNode<Integer> runner2=l;
     ListNode<Integer> head2=l;
     
     while(runner2!=null && runner2.next!=null){
         runner1=runner1.next;
         runner2=runner2.next.next;
     }
     
     if(runner2==null){
        head2=runner1;
     }
     else if(runner2.next==null){
        head2=runner1.next;
     }
        if(head2==null){
            return false;
        }
        else{
            head2=reverse(head2);
        }
        
        while(head2!=null){
        if(!(head.value).equals(head2.value)){
            return false;
        }
        head=head.next;
        head2=head2.next;
        }
        
        return true;
     }
 
public static void main(String[] args){
	ListNode<Integer> ln6 = new ListNode<Integer>(19);
        ln6.next=null;
        ListNode<Integer> ln5 = new ListNode<Integer>(1);
        ln5.next=null;
        ListNode<Integer> ln4 = new ListNode<Integer>(10);
        ln4.next=ln5;
        ListNode<Integer> ln3 = new ListNode<Integer>(2);
        ln3.next=ln4;
        ListNode<Integer> ln2 = new ListNode<Integer>(10);
        ln2.next=ln3;
        ListNode<Integer> ln = new ListNode<Integer>(1);
        ln.next=null;
        
        practice_2017 obj= new practice_2017();
        
        System.out.println(obj.isListPalindrome(ln));
}
 }