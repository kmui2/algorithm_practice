/*
LeetCode – String to Integer (atoi) (Java)
 
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

cases: empty, null, positive, negative, more than max integer, less than min integer
*/

int atoi(String str){
	if(str==null || str.length()<1){
		return 0;
	}
	int len = str.length();
	int sign=1; //positive
	
	double result=0;
	int start_index=0;
	
	if(str.charAt(0)=='-'){
		sign=-1;
		start_index=1;
	}
	
	for(int i=start_index;i<len;i++){
		//result = result*10 + Character.getNumericValue(str.charAt(i));
		result = result*10 + (str.charAt(i)-'0');
	}
	
	if(sign==-1){
		result = result*-1;
	}
	if(result>Integer.Max_VALUE){
		result = Integer.MAX_VALUE;
	}
	if(result<Integer.MIN_VALUE){
		result = Integer.MIN_VALUE;
	}
	
	return (int)result;
}