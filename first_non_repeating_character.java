
/*
First non-repeating character
*/

public class practice_2017 {

  int first_non_repeating_character(String st){
	int[] arr = new int[256];
	
	for(int i=0;i<st.length();i++){
		arr[st.charAt(i)]++;
	}
	
	for(int i=0;i<st.length();i++){
		if(arr[st.charAt(i)]==1){
			return i;
		}
	}
	return -1;
	
}

public static void main(String[] args){
	String st ="ieie";
        practice_2017 obj = new practice_2017();
        int index = obj.first_non_repeating_character(st);
        if(index==-1){
	System.out.println("first non repeating character is: does not exist");
        }
        else{
            System.out.println("first non repeating character is: "+st.charAt(index));
        }
}
}