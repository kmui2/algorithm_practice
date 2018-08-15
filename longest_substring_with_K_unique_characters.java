/*
Find the longest substring with k unique characters in a given string
Given a string you need to print longest possible substring that has exactly M unique characters. If there are more than one substring of longest possible length, then print any one of them.

Examples:

"aabbcc", k = 1
Max substring can be any one from {"aa" , "bb" , "cc"}.

"aabbcc", k = 2
Max substring can be any one from {"aabb" , "bbcc"}.

"aabbcc", k = 3
There are substrings with exactly 3 unique characters
{"aabbcc" , "abbcc" , "aabbc" , "abbc" }
Max is "aabbcc" with length 6.

"aaabbb", k = 3
There are only two unique characters, thus show error message. 
*/

//////////////////////////brute force solution///////////////////////


public class practice{
	

	int unique_count(int start_index, int end_index, String s){
		int count=0;
		Map<Character, Boolean> mp = new HashMap<Character,Boolean>();
		for(int i=start_index;i<=end_index;i++){
			if(!mp.containsKey(s.charAt(i))){
				count++;
				mp.put(s.charAt(i), true);
			}
		}
		return count;
	}

	String longest_substring_unique_chars(String s, int k){

		String result="";
		
		if(s.length()<k){
			return result;
		}

		int start_index =0;
		int end_index = k-1;
		int max_length=0;
		while(end_index<s.length()){
			int unique_chars = unique_count(start_index, end_index, s);
			//System.out.println("unique_chars= "+unique_chars);
			if(unique_chars==k){
				int len = end_index-start_index+1;
				if(len>max_length){
					max_length = len;
					result =s.substring(start_index,end_index+1);
					//System.out.println("result= "+result+" unique chars= "+unique_chars+"start="+start_index+" end= "+end_index);
				}
				
				end_index++;
				
			}
			else if(unique_chars>k){
				start_index++;
			}
			else if(unique_chars<k){ // unique_chars<k
				end_index++;
			}
			
		}
		
		return result;
	}

	public static void main(String[] args){
	practice obj = new practice();
	String s="aabbcc";
	int k=1;
	
	System.out.println(obj.longest_substring_unique_chars(s, k));
	
	}
}	

///////////////////////////Optimized////////////////////

package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class practice{

	    public String lengthOfLongestSubstring(String s,int k) {
	        if(s.length()==0){
	            return null;
	        }
	        
	        if(s.length()==1 || k==1){
	            return s.substring(0,1);
	        }
	        
	        char[] ch =s.toCharArray();
	        
		int first =0;
		int runner =1;
		int count=1;
		int max=0;
		String max_substring="";
		ArrayList<String> substrings = new ArrayList<>();
		
		Map<Character, Integer> mp = new HashMap<Character,Integer>();
		
		mp.put(ch[first],0);
		
		while(runner<ch.length){
			if(!mp.containsKey(ch[runner]) || mp.get(ch[runner])<first){
				count++;
				mp.put(ch[runner],runner);
			}
			else{
				if(count==k){
					//max=count;
					max_substring = s.substring(first,runner);
					String all_substring = s.substring(first,runner);
				substrings.add(all_substring);
				}
				
	            first=mp.get(ch[runner])+1;	
				mp.put(ch[runner],runner);
	            count=runner-first+1;
						
			}
	        
	        runner++;
		}
	    
	    if(count==k){
					//max=count;
					max_substring = s.substring(first,runner);
					 String all_substring = s.substring(first,runner);
		substrings.add(all_substring);   
		}
	    
	        
		System.out.println(max_substring);
		System.out.println(substrings);
	        
	        
		return max_substring;
	    }
	
	public static void main(String[] args){
		practice obj = new practice();
		String s="pwwkew";
		int k=2;
		
		System.out.println(obj.lengthOfLongestSubstring(s,k));
	}
}	
