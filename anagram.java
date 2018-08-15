
/* if given strings are anagram or not 
*/

public boolean isanagram(String st1, String st2){
	if(st1==st2){return true;}
	if(st1.length()!=st2.length()){ return false;}
	int[] letters = new int[256];
	for(int i=0;i<st1.length();i++){
		letters[st1.charAt(i)]++;
	}
	for(int i=0;i<st2.length();i++){
		if(letters[st2.charAt(i)]==0){return false;}
		else {letters[st2.charAt(i)]--;}
	}
	return true;
}
