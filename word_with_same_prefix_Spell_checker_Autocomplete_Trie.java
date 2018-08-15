/*
word with same prefix
*/

package interview;

import java.util.ArrayList;
import java.util.List;

class TrieNode{
	
	TrieNode[] child = new TrieNode[26];
	boolean leaf;
	String word;
	
	public TrieNode() {
		this.leaf= false;
		this.word="";
		for(int i=0;i<26;i++) {
			child[i]=null;
		}
	}		
	
}



public class practice{

	public void constructTrie(String s,TrieNode root) {
		char[] ch_arr = s.toCharArray();
		int len = ch_arr.length;
		
		for(int i=0;i<len;i++) {
			int ch_index = ch_arr[i]-'a';
			if(root.child[ch_index]==null) {
				root.child[ch_index] = new TrieNode();
				root= root.child[ch_index];
			}
			else {
				root = root.child[ch_index];
			}
			
		}
		root.leaf=true;
		root.word=s;
	}
	
	public List<String> wordsWithSamePrefix(String prefix,TrieNode root){
		
		List<String> res = new ArrayList<String>();
		char[] ch_arr = prefix.toCharArray();
		
		//find the last common root i.e: last character from given prefix.
		for(int i=0;i<ch_arr.length;i++) {
			int ch_index = ch_arr[i]-'a';
			if(root.child[ch_index]==null) {
				return res;
			}
			else {
				root = root.child[ch_index];
			}
		}
		
		//dfs to find leaf and word from this root.
		dfs(root,res);
		
		return res;
	}
	
	public void dfs(TrieNode root,List<String> res){
		
		if(root.leaf==true) {
			res.add(root.word);
		}
		
		for(int i=0;i<26;i++) {
			if(root.child[i]!=null) {
				dfs(root.child[i],res);
			}
			else {
				//return;
			}
		}
	}
	
	public static void main(String[] args){
		practice obj = new practice();
		TrieNode root = new TrieNode();
		String[] s1= {"car","carpet","call","aero"};
		for(String s : s1) {
			obj.constructTrie(s,root);
		}
		String prefix ="ca";
		System.out.println(obj.wordsWithSamePrefix(prefix,root));

	}
	
	
	
}