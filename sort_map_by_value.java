/*
Java – Sort Map By Value
 
In Java, we can use the TreeMap class to sort a map by its keys. This class is very handy to use. However, sometimes we need to sort a map by its values. How to sort a map by its values is a most frequently asked question by Java programmers. In this post, I will develop the best way to write such a method.
*/

package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class practice {
   
	public void sortByValue(Map<String,Integer> mp) {
		
		List<Map.Entry<String, Integer>> sortedlist = new ArrayList<Map.Entry<String,Integer>>();
		sortedlist.addAll(mp.entrySet());
		
		Collections.sort(sortedlist, new Comparator<Map.Entry<String,Integer>>(){
			
			public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer>o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		for(int i=0;i<sortedlist.size();i++) {
			System.out.println("list element:"+sortedlist.get(i).getKey()+": "+sortedlist.get(i).getValue());
		}
		
		
	}

    
   public static void main(String args[] ) throws Exception {

       practice obj = new practice();
       
       Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 10);
		map.put("b", 30);
		map.put("g", 20);
		map.put("c", 50);
		map.put("d", 40);
		map.put("e", 20);
		
		obj.sortByValue(map);
   }
}