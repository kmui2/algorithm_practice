/*
PRIMESUM
Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d] 

If a < c OR a==c AND b < d. 
*/

//Big O = O(n.log.logn)
public class Solution {
	//this is O(n)
     public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int[] primes_marked = isPrime(A);
        for (int i = 2; i < A; i++) {
            if (primes_marked[i]==0 && primes_marked[A - i]==0) {
                arr.add(i);
                arr.add(A - i);
                break;
            }
        }
        return arr;
    }

	//this is O(n.log.logn) => for loop will run: n/2 + n/3 + n/5 + n/7 + ... all prime as denominations
    public int[] isPrime(int number) {
        int[] prime_marking = new int[number+1];
        
        prime_marking[0]=1; // not prime
        prime_marking[1]=1; // not prime
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(prime_marking[i]==0){ //do only for index not marked as 1 yet
            for(int j=2;i*j<=number;j++){
                prime_marking[i*j]=1; // not prime
            }
            }
        }
        return prime_marking;
    }
}


/////// using extra space of HashMap(TreeMap) ////////////////

public class practice {
	
	 public ArrayList<Integer> primesum(int a) {
	        Map<Integer,Boolean> prime = all_prime(a);
	        ArrayList<Integer> result = sum(prime, a);
	        
	        return result;
	        
	    }
	    
	    public Map<Integer,Boolean> all_prime(int a){
	        Map<Integer,Boolean> prime_result = new TreeMap<Integer,Boolean>();
	        int[] prime_marking = new int[a+1];
	        
	        //if value =1  then not prime.
	        prime_marking[0]=1;
	        prime_marking[1]=1;
	        
	        int sqrt_a = (int)(Math.sqrt(a));
	        for(int i=2;i<=sqrt_a;i++){
				//process this if not yet marked as 1
	            if(prime_marking[i]==0){
	            for(int j=2;i*j<=a;j++){
	                prime_marking[i*j]=1;
	            }
				}
	        }
	        
	        for(int i=0;i<prime_marking.length;i++){
	            if(prime_marking[i]==0){
	                prime_result.put(i,true);
	            }
	        }
	        
	        return prime_result;
	    }
	    
	    public ArrayList<Integer> sum(Map<Integer,Boolean>prime, int a){
	        ArrayList<Integer> sum_result = new ArrayList<Integer>();
	        
	        Iterator it = prime.entrySet().iterator();
	        while(it.hasNext()){
	            Map.Entry<Integer,Boolean> pair = (Map.Entry)it.next();
	            int second_num = a-pair.getKey();
	            if(prime.containsKey(second_num)){
	                sum_result.add(pair.getKey());
	                sum_result.add(second_num);
	                break;
	            }
	        }
	        
	        return sum_result;
	    }
	    

	public static void main(String[] args){
		practice obj = new practice();
		
		
			System.out.println(obj.primesum(16777214));
		
	}
	
	}
   
