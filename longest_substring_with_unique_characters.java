/*
3. Longest Substring Without Repeating Characters
DescriptionHintsSubmissionsDiscussSolution
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/


package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class practice{

	    public int lengthOfLongestSubstring(String s) {
	        if(s.length()==0){
	            return 0;
	        }
	        
	        if(s.length()==1){
	            return 1;
	        }
	        
	        char[] ch =s.toCharArray();
	        
		int first =0;
		int runner =1;
		int count=1;
		int max=0;
		//String max_substring="";
		//ArrayList<String> substrings = new ArrayList<>();
		
		Map<Character, Integer> mp = new HashMap<Character,Integer>();
		
		mp.put(ch[first],0);
		
		while(runner<ch.length){
			if(!mp.containsKey(ch[runner]) || mp.get(ch[runner])<first){ //count if unique in this substring
				count++;
				mp.put(ch[runner],runner);
			}
			else{
				if(count>max){
					max=count;
					//max_substring = s.substring(first,runner);
					
				}
				//String all_substring = s.substring(first,runner);
				//substrings.add(all_substring);
	            first=mp.get(ch[runner])+1;	//next character index from previous found one
				mp.put(ch[runner],runner);
	            count=runner-first+1; // also include count of characters in between first index and runner index
						
			}
	        
	        runner++;
		}
	    
	    if(count>max){
					max=count;
					//max_substring = s.substring(first,runner);
					
		}
	    //String all_substring = s.substring(first,runner);
		//substrings.add(all_substring);    
	        
		//System.out.println(max_substring);
		//System.out.println(substrings);
	        
	        
		return max;
	    }
	
	public static void main(String[] args){
		practice obj = new practice();
		String s="pwwkew";		
		
		System.out.println(obj.lengthOfLongestSubstring(s));
	}
}	
