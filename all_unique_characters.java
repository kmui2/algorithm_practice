
/* if string has all unique characters
*/

public boolean all_unique(String st){
	boolean[] letters = new boolean[256];
	for(int i=0;i<st.length();i++){
		if(letters[st.charAt(i)]){
			return false;
		}
		else {
			letters[st.charAt(i)]=true;
		}
	}
	return true;
	
}