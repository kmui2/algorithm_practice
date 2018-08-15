
/* if the given string is palindrome*/

public boolean ispalindrome(String st){
	int half_len = st.length()/2;
	int first_index = 0;
	int last_index = st.length()-1;
	
	for(int i=0;i<half_len;i++){
		if(st.charAt(first_index) !=st.charAt(last_index)){
			return false;
		}
		first_index++;
		last_index--;
	}
	return true;
	
}

-----------------------

public boolean is_palindrome(String st){

int len = st.length();
int end = len-1;
for(int i=0;i<len/2;i++){
	if(!st.charAt(i).equals(st.charAt(end))){
		reurn false;
	}
	end--;
}
return true;

}