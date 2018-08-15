/*
Implement a Queue using an Array in Java
 
There following Java code shows how to implement a queue without using any extra data structures in Java. We can implement a queue by using an array.

Idea: tail is at the beginning and head is at the end of the array

*/

public class Queue<E>{
	
	E[] arr;
	int full;
	int head=-1;
	int tail=-1;
	
	public Queue(Class<E> c, int arr_size){
		E[] newarr = (E[])Array.newInstance(c,arr_size);
		this.arr=newarr;
		this.full=0;
	}
	
	public boolean push(E e){
		if(full==arr.length){
			return false;
		}
		head=(head+1)%arr.length;  //%arr.length: if head+1 is > arr.length, it will give the index less than arr.length: 15%5 = 0, 16%5=1
		arr[head]=e;
		full++;
		
		if(tail==-1){
			tail=head;
		}
		
		return true;
	}
	
	public boolean pop(){
		if(full==0){
			return false;
		}
		E pop_result = arr[tail];
		arr[tail]=null;
		tail=(tail+1)%arr.length;
		full--;
		
		if(full==0){
			tail=-1;
			head=-1;
		}
		
		return true;
	}
	
	public E peek(){
		if(full==0){
			return null;
		}
		return arr[tail];
	}
	
	public static void main(String[] args){
		Queue<Integer> q = new Queue<Integer>(Integer.class,5);
		q.push(2);
		q.push(5);
		q.pop();
		q.push(4);
		q.push(66);
		q.push(43);
		q.push(76);
		q.pop();
		
	}
}