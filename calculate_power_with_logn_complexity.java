/*
calculate power of number.
Can you do it better than O(n) i.e in O(log n) complexity?
*/

////////////////////  O(n)  //////////////////////
int pow(int a,int n){

if(n==0){
	return 1;
}

else{
	return a x pow(a,n-1);
}

}

/////////////   O(Log n)  /////////

public int pow(int a, int n){

		if(n==0){
			return 1;
		}

		else{
			if(n%2==0){
			int y= pow(a,n/2);
			return y*y;
			}
			else{
			return a*pow(a,n-1);
			}
		}

}