/*
Note: Your solution should have O(l1.length + l2.length) time complexity, since this is what you will be asked to accomplish in an interview.

Given two singly linked lists sorted in non-decreasing order, your task is to merge them. In other words, return a singly linked list, also sorted in non-decreasing order, that contains the elements from both original lists.

Example

For l1 = [1, 2, 3] and l2 = [4, 5, 6], the output should be
mergeTwoLinkedLists(l1, l2) = [1, 2, 3, 4, 5, 6];
For l1 = [1, 1, 2, 4] and l2 = [0, 3, 5], the output should be
mergeTwoLinkedLists(l1, l2) = [0, 1, 1, 2, 3, 4, 5].
*/

// Definition for singly-linked list:
 class ListNode<T> {
   ListNode(T x) {
     value = x;
   }
   T value;
   ListNode<T> next;
 }
 
 
ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
    if(l1==null && l2==null){return null;}
    if(l1==null){return l2;}
    if(l2==null){return l1;}
    ListNode<Integer> res=l1;    
     
    if(l1.value<=l2.value){
            res=l1;
            l1=l1.next;
        }
        else {
            res=l2;
            l2=l2.next;
        }
    
    ListNode<Integer> res_head=res;
    
    while(l1!=null && l2!=null){
        if(l1.value<=l2.value){
            res.next=l1;
            l1=l1.next;
            res=res.next;
        }
        else {
            res.next=l2;
            l2=l2.next;
            res=res.next;
        }
    }
    if(l1!=null){res.next=l1;}
    if(l2!=null){res.next=l2;}
    
    return res_head;
}
