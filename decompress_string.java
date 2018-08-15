/*
Decompress String
Given a compressed string in which a number followed by [] indicate how many times those characters occur, decompress the string
Eg. : a3[b2[c1[d]]]e will be decompressed as abcdcdbcdcdbcdcde.
Assume the string is well formed and number will always be followed by a [].
*/
public class DeCompressString {

	private static String result="";
	
	public static void main(String[] args) {
		String arg = "a3[b2[c1[d]]]e";
		Decompress(arg, 1);
		System.out.println(result);
	}
	
	private static void Decompress(String str, int times){
		List<Character> list = new ArrayList<Character>();
		list.add('1');list.add('2');list.add('3');list.add('4');list.add('5');list.add('6');list.add('7');list.add('8');list.add('9');
		while(times>0){
			times--;
			
			for(int i=0; i<str.length(); i++){
				char temp= str.charAt(i);
				
				if(list.contains(temp)){
					
					int endOffset = bracketSize(str, i+1);
					Decompress(str.substring(i+1, endOffset), Character.getNumericValue(temp));
					
					// Update i here to avoid reprocessing of the valueinside []
					// -1 is done as endoffset brings us to the value next to ']'
					i = endOffset-1; 

				} else if(str.charAt(i)=='[' || str.charAt(i)==']'){
					// do nothing
				} else{
					result = result + str.charAt(i);
				}
			}
			
			
		}
	}
	
	// Function to calculate the offset at which the bracket closes ']'
	private static int bracketSize(String str, int offset){
		
		int ctr=0;
		char ch = str.charAt(offset);
		
		while(!(ch==']' && ctr==0)){
			ch = str.charAt(offset);
			if(ch == '['){
				ctr++;
			} else if(ch == ']'){
				ctr--;
			} 
			offset++;
		}

		return offset;
	}
}
