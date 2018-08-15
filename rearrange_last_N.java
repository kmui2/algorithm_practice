
/*
Note: Try to solve this task in O(list size) time using O(1) additional space, since this is what you'll be asked during an interview.

Given a singly linked list of integers l and a non-negative integer n, move the last n list nodes to the beginning of the linked list.

Example

For l = [1, 2, 3, 4, 5] and n = 3, the output should be
rearrangeLastN(l, n) = [3, 4, 5, 1, 2];

Concept: 
new tail to attach = 1
2.next = null
3 is new head
5.next = new tail


For l = [1, 2, 3, 4, 5, 6, 7] and n = 1, the output should be
rearrangeLastN(l, n) = [7, 1, 2, 3, 4, 5, 6].
*/

// Definition for singly-linked list:
 class ListNode<T> {
   ListNode(T x) {
     value = x;
   }
   T value;
   ListNode<T> next;
 }
 
 ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
    int len =0;
    ListNode<Integer> head = l;
    ListNode<Integer> runner = l;
    while(l!=null){
        len++;
        l=l.next;
    }
    if(n==0 || n>=len){return head;}
    int new_last_node= len-n;
    
    for(int i=0;i<new_last_node-1;i++){
        runner=runner.next;
    }
    ListNode<Integer> new_head_runner = runner.next;
    ListNode<Integer> new_head = runner.next;
    runner.next=null;
    
    while(new_head_runner.next!=null){
        new_head_runner = new_head_runner.next;
    }
    new_head_runner.next = head;
    
    return new_head;
}
