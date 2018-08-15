/*
You're given 2 huge integers represented by linked lists. Each linked list element is a number from 0 to 9999 that represents a number with exactly 4 digits. The represented number might have leading zeros. Your task is to add up these huge integers and return the result in the same format.

Example

For a = [9876, 5432, 1999] and b = [1, 8001], the output should be
addTwoHugeNumbers(a, b) = [9876, 5434, 0].

Explanation: 987654321999 + 18001 = 987654340000.

For a = [123, 4, 5] and b = [100, 100, 100], the output should be
addTwoHugeNumbers(a, b) = [223, 104, 105].

Explanation: 12300040005 + 10001000100 = 22301040105.
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

   ListNode<Integer> reverse(ListNode<Integer> n){
	ListNode<Integer> reverseNode = null;
	ListNode<Integer> currentNode = n;
	ListNode<Integer> nextNode = n.next;
	while(nextNode!=null){
		currentNode.next = reverseNode;
		reverseNode = currentNode;
		currentNode = nextNode;
		nextNode = nextNode.next;
	}
	n=currentNode;
	n.next=reverseNode;
	return n;
}
 
   ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
    ListNode<Integer> c=null;
	
	a=reverse(a);
	b=reverse(b);
	int sum=0;
	int carry=0;
	while(a!=null || b!=null){
		if(a!=null && b!=null){
			sum=a.value+b.value+carry;
			carry=sum/10000;
            sum=sum%10000;
			a=a.next;
			b=b.next;
			}
		else if(a!=null && b==null){
			sum=a.value+carry;
			carry=sum/10000;
            sum=sum%10000;
			a=a.next;			
		}
		else if(a==null && b!=null){
			sum=b.value+carry;
			carry=sum/10000;
            sum=sum%10000;
			b=b.next;			
		}
                ListNode<Integer> temp = new ListNode<Integer>(0);
		temp.value=sum;
		temp.next=c;
		c = temp;
	}
	if(carry!=0){
            ListNode<Integer> temp = new ListNode<Integer>(0);
		temp.value=carry;
		temp.next=c;
		c=temp;
	}
	
	return c;
}

    public static void main(String[] args){

        ListNode<Integer> ln5 = new ListNode<Integer>(8001);
        ln5.next=null;
        ListNode<Integer> ln4 = new ListNode<Integer>(1);
        ln4.next=ln5;
        ListNode<Integer> ln3 = new ListNode<Integer>(1999);
        ln3.next=null;
        ListNode<Integer> ln2 = new ListNode<Integer>(5432);
        ln2.next=ln3;
        ListNode<Integer> ln = new ListNode<Integer>(9876);
        ln.next=ln2;
        practice_2017 obj= new practice_2017();

        ListNode<Integer> output= obj.addTwoHugeNumbers(ln,ln4);
        
        while(output!=null){
            System.out.println(output.value);
            output=output.next;
        }
        
    }
}
