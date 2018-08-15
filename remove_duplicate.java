
/* Remove duplicate characters
*/

public String remove_duplicate(String st){
		char[] letters = st.toCharArray();
		int tail=1;
                int j;
		for(int i=1;i<letters.length;i++){
			for(j=0;j<tail;j++){
				if(letters[i]==letters[j]){break;}				
			}
			if(j==tail){
				letters[tail]=letters[i];
				tail++;
			}
		}
		//letters[tail]=0;
		return String.valueOf(letters).substring(0, tail);
}