/* 
Find indices for permutation : asked by upstart

Given:  
 string_1: "cat"
 string_2: "btacttbact"
Output => [1, 2, 7]
the letters should exist in 3 characters as length of string_1 =3. 
*/

import java.io.*;
import java.util.*;


class Solution {


  public static ArrayList<Integer> perm(String s1, String s2){
      
    int len_s1 = s1.length();
    int len_s2 = s2.length();
    char[] s1_ch_arr = s1.toCharArray();
    Arrays.sort(s1_ch_arr);
    String s1_sorted = new String(s1_ch_arr);
    
        
    ArrayList<Integer> result_index = new ArrayList<>();
    
    int begin_index=0;
    int end_index=begin_index+len_s1-1;
    
    for(int i=0;i<=len_s2-len_s1;i++){
      String s2_sorted = s2.substring(i,i+len_s1);
      char[] s2_ch_arr = s2_sorted.toCharArray();
      Arrays.sort(s2_ch_arr);
      s2_sorted = new String(s2_ch_arr);
      if(s1_sorted.equals(s2_sorted)){
        result_index.add(i);
      }
      
    }
    
    return result_index;
  }   
  
  
  
  public static void main(String[] args) {
    ArrayList<Integer> index = perm("cat", "btacttbact");
    

    for (Integer ind : index) {
      System.out.println(ind);
    }
    
    
    
  }
}
