
/*Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in the list, since this is what you'll be asked to do during an interview.

Given a singly linked list of integers l and an integer k, remove all elements from list l that have a value equal to k.

Example

For l = [3, 1, 2, 3, 4, 5] and k = 3, the output should be
removeKFromList(l, k) = [1, 2, 4, 5];
For l = [1, 2, 3, 4, 5, 6, 7] and k = 10, the output should be
removeKFromList(l, k) = [1, 2, 3, 4, 5, 6, 7].
Input/Output
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

    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
    if(l==null){return null;}
    ListNode<Integer> head = l;
    while(head!=null && head.value==k){
        head = head.next;
    }
    l=head;
    if(head!=null){
    while(l.next!=null){
        if(l.next.value==k){
            l.next=l.next.next;
        }
        else{
            l=l.next;
        }
    }
    }
    
    return head;
}

    public static void main(String[] args){

        ListNode<Integer> ln4 = new ListNode<Integer>(1);
        ln4.next=null;
        ListNode<Integer> ln3 = new ListNode<Integer>(1);
        ln3.next=ln4;
        ListNode<Integer> ln2 = new ListNode<Integer>(1);
        ln2.next=ln3;
        ListNode<Integer> ln = new ListNode<Integer>(1);
        ln.next=ln2;
        practice_2017 obj= new practice_2017();
        ListNode output= obj.removeKFromList(ln,1);
        
        while(output!=null){
            System.out.println(output.value);
            output=output.next;
        }
        
    }
}
