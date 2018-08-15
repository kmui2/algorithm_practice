/*
You are climbing a staircase that has n steps. You can take the steps either 1 or 2 at a time. Calculate how many distinct ways you can climb to the top of the staircase.

Example

For n = 1, the output should be
climbingStairs(n) = 1;

For n = 2, the output should be
climbingStairs(n) = 2.

You can either climb 2 steps at once or climb 1 step two times.
*/
//same like Fibonnacci
int climbingStairs(int n) {
    int[] store = new int[n];    
    if(n<=2){
        return n;
    }
    store[0]=1;
    store[1]=2;
    for(int i=2;i<n;i++){
        store[i]=store[i-1]+store[i-2];
    }
    return store[n-1];
}

//----------------------OR-------------------
public static int[] A = new int[100];
 
public static int f3(int n) {
	if (n <= 2)
		A[n]= n;
 
	if(A[n] > 0)
		return A[n];
	else
		A[n] = f3(n-1) + f3(n-2);//store results so only calculate once!
	return A[n];
}