/*
Implement Queue using Stack, (find max??) at given position
*/

class Queue{
	Stack<Integer> s;
	public Queue(){
		s= new Stack<Integer>();
	}
}

public class practice{
	
	void enqueue(Queue q,int num){
		q.s.push(num);
	}
	
	int dequeue(Queue q){
		int x; int res=0; int max=Integer_MIN_VALUE;
		if(q.s.isEmpty()){
			System.out.println("Queue is empty");
			System.exit(0);
		}
		if(q.s.size()==1){
			return (q.s.pop());
		}
		else{
			x=q.s.pop();
			
			res = dequeue(q);
			
			q.s.push(x);					
			
		}
	
		return res;
	}
	
	
	public static void main(String[] args){
		practice obj = new practice;
		Queue q = new Queue();
		obj.enqueue(q,2);
		obj.enqueue(q,1);
		System.out.println("dequeue="+obj.dequeue(q));
		obj.enqueue(q,3);
		obj.enqueue(q,5);
		System.out.println("dequeue="+obj.dequeue(q));
	}
	
}