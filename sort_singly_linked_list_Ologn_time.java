/*
Sort List
Sort a linked list in O(n log n) time using constant space complexity.

Example :

Input : 1 -> 5 -> 4 -> 3

Returned list : 1 -> 3 -> 4 -> 5

Need to use Merge Sort.
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
}



public class practice {
	
public ListNode merge_sort(ListNode left, ListNode right){
        
        if(left==null){return right;}
        if(right==null){return left;}
        
        ListNode result_head = left;
        if(left.val<=right.val){
            result_head=left;
            left=left.next;
        }
        else{
            result_head = right;
            right= right.next;
        }
        
        ListNode result_runner = result_head;
        while(left!=null && right!=null){
            if(left.val<=right.val){
                result_runner.next = left;
                result_runner = result_runner.next;
                left = left.next;
            }
            else{
                result_runner.next = right;
                result_runner = result_runner.next;
                right = right.next;
            }
        }
        if(left==null){
            result_runner.next = right;
        }
        else{
            result_runner.next = left;
        }
        
        return result_head;
    }
    
    public ListNode get_middle(ListNode M){
        
        ListNode runner1 = M;
        ListNode runner2 = M;
        
        while(runner2.next!=null && runner2.next.next!=null){
            runner1 = runner1.next;
            runner2 = runner2.next.next;
        }
        
        return runner1;
    	
   }
    
    public ListNode sortList(ListNode A) {
        
        if(A==null || A.next==null){
            return A;
        }
        
        //make the list half
        ListNode first_half_head = A;
        ListNode middle = get_middle(A);
        ListNode second_half_head = middle.next;
        middle.next = null;
        
        ListNode left_merge = sortList(first_half_head);
        ListNode right_merge = sortList(second_half_head);
        
        ListNode sorted_head = merge_sort(left_merge, right_merge);
        
        return sorted_head;
    }
	public static void main(String[] args){
		practice obj = new practice();					
			ListNode A= new ListNode(1);
			ListNode B= new ListNode(5);
			ListNode C= new ListNode(4);
			ListNode D= new ListNode(3);
			A.next = B;
			B.next = C;
			C.next = D;
			
			ListNode res = obj.sortList(A);
			while(res!=null) {
			
			System.out.println(res.val);
			res = res.next;
			}
		
	}
	
}