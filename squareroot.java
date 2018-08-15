

/*
calculate square root
*/

package interview;

public class practice{
	
	public long getSquarerootOrFloor(long number){

		 long start = 0;
		 long end = number/2;
		 long mid=0;
		 while(start<=end){
			mid = (end-start)/2 + start;
			long squareroot = mid*mid;
			if(number==squareroot){
				return mid;
			}
			else if(number<squareroot){
			//go left
				end=mid-1;
			}
			else{
			//go right
			start=mid+1;
			}
		 }
		 
		 return start-1;

		}
	
	
	
		public static void main(String[] args){
					
			practice obj = new practice();
			long num = 4;//17;25; 
			System.out.println("Square Root of "+num+" is: "+obj.getSquarerootOrFloor(num));
		}
}

