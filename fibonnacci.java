
/* Please implement a function which returns the nth number in Fibonacci sequences with an input n.

*/

public int fib(int n){

if(n<=0){return 0;}
if(n==1){return 1;}
if(n>1){
	int a=0;
	int b=1;
    int c=0;
	for(int i=2;i<=n;i++){
		c=a+b;
		a=b;
		b=c;
	}
	return b;
}
else return 0;
}

/*
print fibonacci sequence
input: n = 5
output: 1 1 2 3 5 8
*/

package interview;

public class practice{
	
	public static void fibUtil(int n, int[]arr) {
		for(int i=0;i<=n;i++) {
			if(i==0 || i==1) {
				arr[i]=1;
			}
			else {
				arr[i]=arr[i-1]+arr[i-2];
			}
		}
	}
	
	
	public static void fib(int n) {
		
		int[] arr = new int[n+1];
		fibUtil(n,arr);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("index"+i+" :"+arr[i]);
		}
	}
	
	
	
		public static void main(String[] args){
	
			fib(5); //fib(0);
		}
}

/*
print fibonacci series where the final number is less than or equal to the given input number

input: fib(5) => 0,1,1,2,3,5
fib(9) => 0,1,1,2,3,5,8
fib(1) => 0,1,1
*/

public class Practice {

	public static List<Integer> fib(int n){

		List<Integer> res = new ArrayList<Integer>();

		int a=0;
		int b=1;
		int c=0;
		res.add(a);

		while(b<=n){
			res.add(b);
			c=a+b;
			a=b;
			b=c;
			
		}
		return res;
		}
	
	
	
	public static void main(String[] args) {

		System.out.println("fib series:"+fib(9));

	}

}

