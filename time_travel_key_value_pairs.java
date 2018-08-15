/*
time travel in key value pair.
get the value per searched key and time. If time is not provided, get the last value. If exact time does not exist, return the closest one in the past.
*/



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node{
    long timestamp;
    String val;
    
    public Node(long t, String v){
        this.timestamp=t;
        this.val=v;
    }
}


public class Solution {
    
    
    
    static Map<String,List<Node>> mp = new HashMap<String,List<Node>>();
    
    public static long create_sec_now_time(){
        Date now = new Date();
        long msec = now.getTime();
        return msec;
    }
    
    
    
    public static void set_keys(String key, String value){
        long timestamp = create_sec_now_time();
        Node tempNode = new Node(timestamp,value);
        if(!mp.containsKey(key)){
            List<Node> tempList = new ArrayList<>();
            tempList.add(tempNode);
            mp.put(key,tempList);
        }
        else{
            mp.get(key).add(tempNode);
        }
        
    }
    
    public static String get_value(String key, long time){
        
        String result ="";
        if(!mp.containsKey(key)){
            return null;
        }
        
        if(time>0){
            List<Node> all_nodes= mp.get(key);
            
            for(int i=0;i<all_nodes.size();i++){
                if(time>=all_nodes.get(i).timestamp){
                    result = all_nodes.get(i).val;
                }
                
            }
        }
        else{
           List<Node> all_nodes= mp.get(key); 
           result = all_nodes.get(all_nodes.size()-1).val;
        }
        
        return result;
        
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        set_keys("foo","bar");
        set_keys("foo","bar2");
        //System.out.println(get_value("foo",0));
        long now_millisec = create_sec_now_time();
        System.out.println("millisec="+now_millisec);
        Thread.sleep(500);
        set_keys("foo","bar3");
        System.out.println(get_value("foo",now_millisec));
    }
}
