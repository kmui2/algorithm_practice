/*
LeetCode – Minimum Window Substring (Java)
 
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example, S = "ADOBECODEBANC", T = "ABC", Minimum window is "BANC".

output from program below: 
[ADOBEC, BECODEBA, CODEBA, BANC]
BANC

*/

package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class practice{
	Map<Character, Integer> mp_T = new HashMap<Character,Integer>();
	Map<Character, Integer> mp_T_exist_in_S = new HashMap<Character,Integer>();
	int unique_in_T=0;
	int unique_T_in_S=0;
	List<String> result = new ArrayList<String>();
	
	public void put_T_in_map(String T, Map<Character, Integer> mp_T){
		for(int i=0;i<T.length();i++){
			if(!mp_T.containsKey(T.charAt(i))){
				mp_T.put(T.charAt(i),1);
				unique_in_T++;
			}
			else {
				mp_T.put(T.charAt(i),mp_T.get(T.charAt(i))+1);
			}
		}
	}
	
	public int trim_beginning(int index,char[] ch) {
		
		while(!mp_T.containsKey(ch[index])) {
			index++;
		}
		
		return index;
	}
	
	public List<String> minimum_window(String S, String T){
		put_T_in_map(T,mp_T);
		
		int start_index=-1,runner=0;
		char[] ch_S =S.toCharArray();
		int len_S = ch_S.length;
		while(runner<len_S){
			if(mp_T.containsKey(ch_S[runner])){
				if(start_index==-1){
					start_index=runner;
				}
				if(mp_T_exist_in_S.containsKey(ch_S[runner])){
					mp_T_exist_in_S.put(ch_S[runner], mp_T_exist_in_S.get(ch_S[runner])+1);
				}
				else{
					mp_T_exist_in_S.put(ch_S[runner],1);
				}
				
				if(mp_T.get(ch_S[runner])== mp_T_exist_in_S.get(ch_S[runner])){
					
					unique_T_in_S++;
				}
				
				while(unique_in_T==unique_T_in_S){ // we have a sub string with all letters from T.
					result.add(S.substring(start_index,runner+1));
					//remove first character's count from substring
					mp_T_exist_in_S.put(ch_S[start_index], mp_T_exist_in_S.get(ch_S[start_index])-1);
					if(mp_T_exist_in_S.get(ch_S[start_index]) < mp_T.get(ch_S[start_index])){
						unique_T_in_S--;
						if(start_index<runner){
						    start_index = trim_beginning(start_index+1,ch_S);
                        }
					}
					else{
						start_index=trim_beginning(start_index+1,ch_S);	
					}
					
				}
			}
			runner++;
		}
		return result;
	}
	
	public static void main(String[] args){
		practice obj = new practice();
		
//		String S="ADOBECODEBANC";
//		String T="ABC";
		
		String S="aa";
		String T="aa";
		
		List<String> output = obj.minimum_window(S, T);
		System.out.println(output);
		
		int min_length =Integer.MAX_VALUE;
		int min_length_index =0;
		for(int i=0;i<output.size();i++) {
			if(output.get(i).length()<min_length) {
				min_length = output.get(i).length();
				min_length_index = i;
			}
		}
		System.out.println(output.get(min_length_index));
		
	}
	
	
	
}