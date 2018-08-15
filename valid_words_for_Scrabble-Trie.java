/*
Print all valid words that are possible using Characters of Array
Given a dictionary and a character array, print all valid words that are possible using characters from the array. 
modified: print words with longest length.

Examples:

Input : Dict - {"go","bat","me","eat","goal", 
                                "boy", "run"} 
        arr[] = {'e','o','b', 'a','m','g', 'l'} 
Output : go, me, goal => goal

Input : Dict - {"go","bat","me","eat","goala", 
                                "boy", "run"} 
        arr[] = {'e','o','b', 'a','m','g', 'l','a'} 
Output : go, me, goala => goala

More questions: word cannot repeat the characters in arr[] unless more of same character is provided in arr[].
*/

package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Trie{
	
	boolean leaf=false;
	
	Trie[] child = new Trie[26];
	
	public Trie(){
		for(int i=0;i<26;i++){
			child[i] = null;
		}
	}
}

public class practice{

	//construct Trie
		public void construct_trie(String word, Trie root){
			
			for(int i=0;i<word.length();i++){
				int index = word.charAt(i)-'a';
				if(root.child[index]==null){
					root.child[index] = new Trie();
					root = root.child[index];
				}
				else{
					root=root.child[index];
				}
			}
			//System.out.println("trie for word="+word);
			root.leaf=true;
		}

		//traverse Trie util
		public void traverse_trie_util(Trie root, Map<Character,Integer> mpp,String complete_word,List<String> result_valid_words){
			if(root.leaf==true){
				result_valid_words.add(complete_word);
				//return;
				//System.out.println("complete word="+complete_word);
			}
			for(int i=0;i<26;i++){
				char ch = (char)(i+'a');
				if(root.child[i]!=null && mpp.get(ch)!=null && mpp.get(ch)>0){
					mpp.put(ch,mpp.get(ch)-1);
					String letter = ""+(char)(i+'a');
					complete_word=complete_word+letter;
					root = root.child[i];
					traverse_trie_util(root,mpp,complete_word,result_valid_words);
				}
			}
		}
		
		//traverse Trie
		public List<String> traverse_trie(Trie root, Map<Character,Integer> mp){
			List<String> result_valid_words = new ArrayList<String>();		
			//loop for each word. This is the beginning character per word
			for(int i=0;i<26;i++){
				//copy the hashmap. Each starting child will have new hashmap
				Map<Character, Integer> mpp = new HashMap<Character,Integer>();
				mpp.putAll(mp);
				char ch = (char)(i+'a');
				if(root.child[i]!=null && mpp.get(ch)!=null && mpp.get(ch)>0){
					mpp.put(ch,mpp.get(ch)-1);
					String letter = ""+(char)(i+'a');	
					//System.out.println("traverse_trie_util called for="+mpp+" start letter="+letter);
					traverse_trie_util(root.child[i],mpp,letter,result_valid_words);
				}
			}
			
			
			//System.out.println("result valid words inside traverse trie="+result_valid_words);
			return result_valid_words;
		}

		
	public static void main(String[] args) {
		
		String[] dict = {"go","bat","me","eat","goala","boy", "run"};
		char[] arr = {'e','o','b', 'a','m','g', 'l','a'};

		practice obj = new practice();
		//create a HashMap for all characters in arr[]. Put count of characters as value.
		Map<Character,Integer> mp = new HashMap<Character,Integer>();
		for(int i=0;i<arr.length;i++){
			if(!mp.containsKey(arr[i])){
				mp.put(arr[i],1);
			}
			else{
				int c = mp.get(arr[i]);
				c=c+1;
				mp.put(arr[i],c);
			}
		}
		System.out.println("map of characters="+mp);

		//Construct Trie tree for words in dictionary
		//if first letter of dictionary is one of the character in arr[] then construct Trie for that word.
		Trie root = new Trie();
		for(int i=0;i<dict.length;i++){
			char first_letter = dict[i].charAt(0);
			if(mp.containsKey(first_letter)){
				obj.construct_trie(dict[i],root);
			}
		}
		
		
		//traverse Trie and see if the characters are in HashMap for a complete word.	
		//if valid word found, save in a list.	
		List<String> valid_words = obj.traverse_trie(root,mp);
		
		
		//compare the length of valid words and return the longest ones.
		int max_length=Integer.MIN_VALUE;
		for(int i=0;i<valid_words.size();i++){
			if(valid_words.get(i).length()>max_length){
				max_length=valid_words.get(i).length();
			}
			//System.out.println("valid_words="+valid_words.get(i));
			
		}
		
		for(int i=0;i<valid_words.size();i++){
			if(valid_words.get(i).length()!=max_length){
				valid_words.remove(i);
			}
		}
		
		System.out.println("List of valid words with longest length="+valid_words);
		
	}

	}
	
	