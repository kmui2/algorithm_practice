/*
49. Group Anagrams
DescriptionHintsSubmissionsDiscussSolution
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/

class Solution {
    
    public String create_count_key(String str){
        int[] letters = new int[26];
        char[] ch = str.toCharArray();
        StringBuilder st = new StringBuilder();
        for(int i=0;i<ch.length;i++){
            int index = ch[i]-'a';
            letters[index]++;
        }
        for(int i=0;i<26;i++){
            st.append("#");
            st.append(letters[i]);
        }
        
        return st.toString();
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String,List<String>> mp =new HashMap<String,List<String>>();
        int len = strs.length;
        String count_key ="";
        for(int i=0;i<len;i++){
            count_key=create_count_key(strs[i]);
            if(mp.containsKey(count_key)){
                mp.get(count_key).add(strs[i]);
            }
            else{
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                mp.put(count_key,temp);
            }
        }
        result.addAll(mp.values());
        
        return result;
    }
}