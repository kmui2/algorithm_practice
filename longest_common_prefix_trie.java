/*
Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

Example:

Given the array as:

[

  "abcdefgh",

  "aefghijk",

  "abcefgh"
]
The answer would be “a”.
*/

class TrieNode{
    TrieNode[] child = new TrieNode[26];
    boolean leaf;
    public TrieNode(){
        for(int i=0;i<26;i++){
            this.child[i]=null;
        }
        this.leaf=false;
    }
}


public class Solution {
    
    int max_visited_node_index =-1;
    public void construct_first_trie(TrieNode root, String word){
        
        int len = word.length();
        for(int i=0;i<len;i++){
            int index = word.charAt(i)-'a';
            root.child[index]=new TrieNode();
            root = root.child[index];
        }
        root.leaf = true;
        max_visited_node_index = len-1;
    }
    
    public void construct_trie(TrieNode root, String word){
        
        int len = word.length();
        for(int i=0;i<len;i++){
            int index = word.charAt(i)-'a';
            if(root.child[index]!=null && i<=max_visited_node_index){
                root = root.child[index];
            }
            else{
                max_visited_node_index=i-1;
                break;
            }
        }
    }
    
    public String longestCommonPrefix(ArrayList<String> A) {
        
        if(A==null){return null;}
        if(A.size()==1){return A.get(0);}
        //find the smallest String
        int smallest_size=Integer.MAX_VALUE;
        int smallest_size_index=0;
        for(int i=0;i<A.size();i++){
			//A.set(i,A.get(i).toLowerCase());
            if(A.get(i).length()<smallest_size){
                smallest_size = A.get(i).length();
                smallest_size_index=i;
            }
        }
        
        //construct trie with the smallest string first
        TrieNode root = new TrieNode();
        construct_first_trie(root,A.get(smallest_size_index));
        
        //construct trie and note max visited node index for remaining strings
        for(int i=0;i<A.size();i++){
            if(i!=smallest_size_index){
                construct_trie(root,A.get(i));
            }
        }
        
        if(max_visited_node_index==-1){
            return "";
        }
        else return A.get(smallest_size_index).substring(0,max_visited_node_index+1);
        
    }
}
