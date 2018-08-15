
/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input : 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 
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
	public ListNode detectCycle(ListNode a) {
	    
	    ListNode runner1 = a;
	    ListNode runner2 = a;
	    boolean cyclic = false;
	    
	    while(runner2!=null && runner2.next!=null){
	        
	        runner1=runner1.next;
	        runner2=runner2.next.next;
	        
	        if(runner1==runner2){
	            cyclic = true; break;
	        }
	    }
	    
	    ListNode cycle_begin=a;
	    if(cyclic){
	        
	        while(runner1!=cycle_begin){
	            cycle_begin=cycle_begin.next;
	            runner1=runner1.next;
	        }
	    }
	    else return null;
	    
	    return cycle_begin;
	}
}
////////////////////alternate solution if we can use extra space as HashSet////////////////////

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode detectCycle(ListNode A) {

	    HashSet<ListNode> hashSet = new HashSet<>();
	    
	    while (A != null) {
	        if (hashSet.contains(A)) {
	            return A;
	        } else {
	            hashSet.add(A);
	        }
	        A = A.next;
	    }
	    
	    return null;
	}
}
