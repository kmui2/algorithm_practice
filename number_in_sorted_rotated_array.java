/*
Rotated Sorted Array Search
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

You are given a target value to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Input : [4 5 6 7 0 1 2] and target = 4
Output : 0

NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*

3) Note: If there are duplicates, making either decision might be difficult and hence linear search might be required.

               mid
               
                |
                
1 1 1 1 2 0 1 1 1 1 1 1 1 1 1 1 1 
arr[mid] = arr[end]

Indecisive. We would need to explore the whole array.
*/

public class practice {
	

	public int search(final List<Integer> a, int b) {

		int start = 0, end = a.size()-1;
		
		while(start<=end){
			int mid = (end-start)/2+start;
			int a_mid = a.get(mid);
			int a_start = a.get(start);
			int a_end = a.get(end);
			
			
			System.out.println("a_start= "+a_start);
			System.out.println("a_mid= "+a_mid);
			System.out.println("a_end= "+a_end+"\n");
			
			
			if(a_mid==b){return mid;}
			
			if(b>a_mid){
				if(b<=a_end){start = mid+1;}
				else if(a_end<a_mid){start = mid+1;}
				else{end = mid-1;}
			}
			else if(b<a_mid){
				if(b>=a_start){end=mid-1;}
				else if(a_start>a_mid){end=mid-1;}
				else{start=mid+1;}
			}
		}
		return -1;

	}

	public static void main(String[] args){
		practice obj = new practice();
			int[] a = {101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100};
			List<Integer> ll = new ArrayList<Integer>();
			ll.add(101);
			ll.add(103);
			ll.add(106);
			ll.add(109); ll.add(158); ll.add(164); ll.add(182); ll.add(187);ll.add(202);ll.add(205);ll.add(2);ll.add(3);ll.add(32);ll.add(57);ll.add(69);ll.add(74);ll.add(81);
			ll.add(99);ll.add(100);
			
			
			System.out.println(obj.search(ll,202));
		
	}
	
}