/*
725. Split Linked List in Parts
DescriptionHintsSubmissionsDiscussSolution
Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".

The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.

The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

Return a List of ListNode's representing the linked list parts that are formed.

Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
Example 1:
Input: 
root = [1, 2, 3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The input and each element of the output are ListNodes, not arrays.
For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but it's string representation as a ListNode is [].
Example 2:
Input: 
root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
Explanation:
The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
Note:

The length of root will be in the range [0, 1000].
Each value of a node in the input will be an integer in the range [0, 999].
k will be an integer in the range [1, 50].

Time Complexity: O(N+K) where NN is the number of nodes in the given list. If kk is large, it could still require creating many new empty lists.
Space Complexity: O(max(N, k))O(max(N,k)), the space used in writing the answer.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode increase_runner(ListNode r, int iterate){
        while(iterate>1){
            r=r.next;
            iterate--;
            
        }
        ListNode res = r.next;
        r.next=null;
        return res;
    }
    
    public ListNode[] splitListToParts(ListNode root, int k) {
                
        ArrayList<ListNode> result_util = new ArrayList<>();
        
        int sz = 0;
        ListNode sz_runner=root;
        while(sz_runner!=null){
            sz++;
            sz_runner=sz_runner.next;
        }
        
        int count_per_group = sz/k;
        int extra = sz%k;
        
        ListNode runner = root;
        while(runner!=null){
            if(extra>0){
                result_util.add(runner);
                runner=increase_runner(runner,count_per_group+1);
                extra--;
            }
            else{
                result_util.add(runner);
                runner=increase_runner(runner,count_per_group);                
            }
        }
        
        int result_util_sz = result_util.size();
        while(result_util_sz<k){   //if(given node size is smaller than k)
            result_util.add(null);
            result_util_sz++;
        }
        
        ListNode[] result = new ListNode[result_util.size()];
        for(int i=0;i<result_util.size();i++){
            result[i] = result_util.get(i);
        }
        
        return result;
    }
}