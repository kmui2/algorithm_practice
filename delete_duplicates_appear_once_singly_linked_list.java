/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

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
	public ListNode deleteDuplicates(ListNode a) {
	    
		if(a==null){return null;}
	    ListNode result =a;
	    ListNode prev=a;
	    ListNode runner =a.next;
	    
	    while(runner!=null ){
	        
	        if(runner.val == prev.val){
	            runner = runner.next;
	        }
	        else{
	            prev.next = runner;
	            prev=prev.next;
	            runner = runner.next;
	        }
	        
	    }
	    prev.next=runner;
	    
	    
	    
	    return result;
	}
}
