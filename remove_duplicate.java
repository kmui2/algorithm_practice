
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

/* remove duplicate from sorted array of integers*/

public int[] remove_duplicate_num(int[] arr){

	int j=0;
	int i=1;

	while(i<arr.length){
		if(arr[j]==arr[i]){
			i++;
		}
		else{
			j=j+1;
			arr[j]=arr[i];
			i++;
		}
	}
	
	int[] res = arrays.copyof(arr,j+1);
	return res;
	
}