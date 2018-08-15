/*
LeetCode – Find Median from Data Stream (Java)
 
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Analysis

First of all, it seems that the best time complexity we can get for this problem is O(log(n)) of add() and O(1) of getMedian(). This data structure seems highly likely to be a tree.

We can use heap to solve this problem. In Java, the PriorityQueue class is a priority heap. We can use two heaps to store the lower half and the higher half of the data stream. The size of the two heaps differs at most 1.
*/


 public class practice_2017 {
	 PriorityQueue<Integer> maxheap;
	 PriorityQueue<Integer> minheap;
	 
	 public practice_2017(){
		maxheap = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return -1* a.compareTo(b);
			}
		});
		minheap= new PriorityQueue<Integer>();
	 }
	 
	public void addNumber(int n){
		if(maxheap.peek()==null || n<maxheap.peek()){
			maxheap.add(n);
		}
		else{
			minheap.add(n);
		}
	}
	
	public void balance_heap(){
		while(maxheap.size()>minheap.size()+1){
			minheap.add(maxheap.poll());
		}
		while(minheap.size()>maxheap.size()+1){
			maxheap.add(minheap.poll());
		}
	}
	 
	 public double find_median(){
		balance_heap();
		if(maxheap.size()==minheap.size()){
			return ((double)(maxheap.poll()+minheap.poll())/2);
		}
		else if(maxheap.size()>minheap.size()){
			return (double)maxheap.poll();
		}
		else{
			return (double)minheap.poll();
		}
}

public static void main(String[] args){
	practice_2017 obj = new practice_2017();
	obj.addNumber(2);
	obj.addNumber(10);
	obj.addNumber(9);
	obj.addNumber(8);	
	obj.addNumber(5);
	obj.addNumber(18);
	
	System.out.println("Median is:"+obj.find_median());
	
}
 }
 
-------------------------------------------OR------------------------------------------


package interview;

import java.util.Collections;
import java.util.PriorityQueue;

public class practice {
	 PriorityQueue<Integer> maxheap;
	 PriorityQueue<Integer> minheap;
	 
	 public practice(){
		maxheap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
		minheap= new PriorityQueue<Integer>();
	 }
	 
 
	 public double find_median(int n){
		
		 maxheap.add(n);
		if(maxheap.size()>=minheap.size()+2) {
			int temp = maxheap.poll();
			minheap.add(temp);
		}
		if(maxheap.size()>minheap.size()){
			return (double)(maxheap.peek());
		}
		
		else{
			return ((double)(maxheap.peek()+minheap.peek())/2);
		}
}

public static void main(String[] args){
	practice obj = new practice();
	int[] num= {2,10,9,8,5,18};
	
	for(int i=0;i<num.length;i++) {
		System.out.println("Median is:"+obj.find_median(num[i]));
	}
	
}
}



 