import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/*

1) Capitalization
Dictionary: {red, blue, green,rod}
Input: Red -> red,rod
Input: REd -> red


Dictionary: {red, blue, Green}
Input: green -> Green


2) Mixed up vowels
Vowel: a, e, i, o, u

Dictionary: {red, blue, Green, rod}
Input: rid -> red
Input: blaa -> blue
Input: Rid -> red, rod

r#d -> red, rod
bl## -> blue ,bloe


https://thumbtack.com/engineering/

*/





public class Solution {
  
  Map<String, List<String>> dictionary = new HashMap<String,List<String>>();
  
  public void putDictToMap(String[] dict){
      
      for(int i=0;i<dict.length;i++){
          String key = convertLowerandHash(dict[i]);
          //System.out.println("key:"+key);
          
          if(!dictionary.containsKey(key)){
              List<String> values = new ArrayList<String>();
              values.add(dict[i]);
              dictionary.put(key,values);
              //System.out.println("dict:"+dictionary);
          }
          else{
              List<String> values = new ArrayList<String>();
              values.addAll(dictionary.get(key));
              values.add(dict[i]);
              dictionary.put(key,values);
          }
      }
      
      
      
  }
  
  public List<String> spellChecker(String input_spell){
      String converted = convertLowerandHash(input_spell);
      //System.out.println("converted:"+converted);
      
      List<String> result = new ArrayList<String>();
      if(dictionary.containsKey(converted)){
          result.addAll(dictionary.get(converted));
      }
      return result;
  }
  
  public String convertLowerandHash(String toconvert){
      
      String lower = toconvert.toLowerCase();
      
      char[] ch_arr = lower.toCharArray();
      for(int i=0;i<ch_arr.length;i++){
          if(ch_arr[i]=='a' || ch_arr[i]=='e' || ch_arr[i]=='i' || ch_arr[i]=='o' || ch_arr[i]=='u'){
              ch_arr[i]='#';
          }
      }
      
      return String.valueOf(ch_arr);
  }
    
    
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Solution obj = new Solution();
        String[] dictionary_input ={"red","blue","Green","rod"};
        String input_spell ="";
        
        obj.putDictToMap(dictionary_input);
        List<String> output = new ArrayList<String>();
        output.addAll(obj.spellChecker(input_spell));
        
        for(int i=0;i<output.size();i++){
            System.out.println(output.get(i));
        }
    }
}













