/*
Write an efficient method that checks whether any permutation ↴ of an input string is a palindrome. ↴

You can assume the input string only contains lowercase letters.

Examples:

"civic" should return true
"ivicc" should return true
"civil" should return false
"livci" should return false
*/

boolean has_any_palindrome(String st){
	
	Set<Character> hs = new HashSet<Character>();
	char[] ch_arr = st.toCharArray();
	
	for(char c: ch_arr){
		if(hs.contains(c)){
			hs.remove(c);
		}
		else{
			hs.add(c);
		}
	}
	
	if(hs.size()>1){
		return false;
	}
	else {
		return true;
	}
	
}