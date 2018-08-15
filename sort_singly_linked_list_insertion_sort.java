/*
Insertion Sort List
Sort a linked list using insertion sort.

We have explained Insertion Sort at Slide 7 of Arrays

Insertion Sort Wiki has some details on Insertion Sort as well.

Example :

Input : 1 -> 3 -> 2

Return 1 -> 2 -> 3
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode A) {
        
        ListNode sorted_head = A;
        ListNode sorted_tail = A;
        ListNode unsorted_head = A.next;
        
        while(unsorted_head!=null){
            
            if(unsorted_head.val>=sorted_tail.val){
                sorted_tail = sorted_tail.next;
                unsorted_head = unsorted_head.next;
            }
            else{
                int value_for_insert = unsorted_head.val;
                unsorted_head = unsorted_head.next;
                sorted_tail.next = unsorted_head;
                //insert
                ListNode runner =sorted_head;
                if(value_for_insert<runner.val){
                    ListNode newnode = new ListNode(value_for_insert);
                    newnode.next = runner;
                    sorted_head = newnode;
                }
                else{
                    while(runner.next.val<value_for_insert){
                        runner = runner.next;
                    }
                    ListNode newnode = new ListNode(value_for_insert);
                    newnode.next = runner.next;
                    runner.next = newnode;
                }
                
            }
            
        }
        
        return sorted_head;
    }
}
