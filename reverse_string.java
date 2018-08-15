
/* Reverse a string in place
*/

public String reverse(String st){
	char[] letters = st.toCharArray();
	char temp;
	int last_index=letters.length-1;
	for(int i=0;i<letters.length/2;i++){
		temp=letters[i];
		letters[i]=letters[last_index];
		letters[last_index]=temp;
		last_index--;
	}
	return String.valueOf(letters);
}