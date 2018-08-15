
/*
LeetCode – Swap Nodes in Pairs (Java)
 
Given a linked list, swap every two adjacent nodes and return its head.

For example, given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

// Definition for singly-linked list:
 class ListNode {
   ListNode(int x) {
     value = x;
   }
   int value;
   ListNode next;
 }
 
 public class practice_2017 {

    public ListNode swap_pair(ListNode head){
        if(head==null){return null;}
        if(head.next==null){return head;}
        ListNode el1 = head;
        ListNode el2 = head.next;
        ListNode el3 = head.next.next;
        
        ListNode reshead = el2;
        while(el1!=null && el2!=null){
            el2.next = el1;
            if(el3==null){ 
                el1.next=null;
                break;
            }
            else if (el3.next==null){
                el1.next=el3;
                break;
            }
            else{
                el1.next=el3.next;
            }
            el1=el3;
            el2=el3.next;
            el3=el3.next.next;
        }
        return reshead;
    }
     
public static void main(String[] args){
	 
        ListNode ln7 = new ListNode(7);
        ln7.next=null;
        ListNode ln6 = new ListNode(6);
        ln6.next=ln7;
        ListNode ln5 = new ListNode(5);
        ln5.next=ln6;
        ListNode ln4 = new ListNode(4);
        ln4.next=ln5;
        ListNode ln3 = new ListNode(3);
        ln3.next=ln4;
        ListNode ln2 = new ListNode(2);
        ln2.next=ln3;
        ListNode ln = new ListNode(1);
        ln.next=ln2;
        practice_2017 obj= new practice_2017();
        ListNode output= obj.swap_pair(ln);
        
        while(output!=null){
            System.out.println(output.value);
            output=output.next;
        }
}
 }