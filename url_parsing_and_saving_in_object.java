import java.io.*;
import java.util.*;


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 * 
 * https://branch.io/path/to/content?
 * http://branch.io?query=para&q2=para2
 * http://branch.io
 * {
   "schema": "http",
   "domain": "branch.io",
   "query_params": {
       "query": "para"
     }
  }
 */

class NodeUrl{

    String schema;
    String domain;
    Map<String,String> query_params;
  
    public NodeUrl(){
      
      this.query_params = new HashMap<String,String>();
    }

}


class Solution {
  
  public static NodeUrl parse_url(String url){
  
    NodeUrl nu = new NodeUrl();
    
    int index_colon = url.indexOf(':');
    nu.schema = url.substring(0,index_colon);
  
    int index_domain_end = url.indexOf('?');
    if(index_domain_end==-1){
      index_domain_end = url.indexOf('/');
      if(index_domain_end==-1){
          index_domain_end = url.length()-1;
      }
    }
    
    nu.domain = url.substring(index_colon+3,index_domain_end);
    
     int index_query_param_start = url.indexOf('?');
      if(index_query_param_start!=-1){
      
        int start = index_query_param_start+1;                
        
        parse_query_string(url.substring(start),nu);
                
      }
    
  return nu;
  }
  
  
  public static void parse_query_string(String qst,NodeUrl nu){
  
        int start=0;
        while(start<qst.length()-1){
          int end= qst.indexOf('&',start);
          if(end==-1){
            end=qst.length();
          }
        
          String pair = qst.substring(start, end);
          String key_value[] = pair.split("=");
          String key =key_value[0];
          String value = key_value[1];
          //map store
          nu.query_params.put(key,value);

            start = end+1;                      
        }
  
  }
  
  
  
  
  
  public static void main(String[] args) {
    
    String url="http://branch.io?query=para&q2=para2";
    
    NodeUrl output = parse_url(url);
    System.out.println(output.schema);
    System.out.println(output.domain);
    System.out.println(output.query_params);
    
    
//     ArrayList<String> strings = new ArrayList<String>();
//     strings.add("Hello, World!");
//     strings.add("Welcome to CoderPad.");
//     strings.add("This pad is running Java 8.");

//     for (String string : strings) {
//       System.out.println(string);
//     }
  }
}
