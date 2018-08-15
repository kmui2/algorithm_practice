/*
LRU Cache

LeetCode – LRU Cache (Java)
 
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.


Analysis

The key to solve this problem is using a double linked list which enables us to quickly move nodes.


LRU-Cache


The LRU cache is a hash table of keys and double linked nodes. The hash table makes the time of get() to be O(1). The list of double linked nodes make the nodes adding/removal operations O(1).
*/
package interview;

import java.util.HashMap;
import java.util.Map;

class Node{
	Node next;
	Node pre;
	String key;
	String val;
	public Node(String k, String v) {
		this.key=k;
		this.val=v;
		this.next=null;
		this.pre=null;
	}
}


public class practice{
	int Cache_Capacity=2;
	Node head=null;
	Node tail=null;
	Map<String, Node> mp = new HashMap<String,Node>();
	
	
	void sethead(Node n) {
		if(head==null) {
			head=n;
			tail=n;
			n.next=null;
			n.pre=null;
		}
	
		else {
			n.next=head;
			n.pre=null;
			head.pre=n;
			head=n;
		}
	
	}
	
	void remove(Node n) {
		
		if(n.pre==null && n.next==null) {
			head=null;
			tail=null;
		}
		else if(n.pre==null) {
			n.next.pre=null;
			head=n.next;
		}
		else if(n.next==null) {
			n.pre.next=null;
			tail=n.pre;
		}
		
		else {
			n.pre.next=n.next;
			n.next.pre=n.pre;
		}
		
	}
	
	
	void set_data(String k, String v) {
		
		if(mp.containsKey(k)) {
			Node existing = mp.get(k);
			existing.val=v;
			remove(existing);
			sethead(existing);
			
		}
		
		else {
			if(mp.size()<Cache_Capacity) {
				Node created = new Node(k,v);
				sethead(created);
				mp.put(k,created);
			}
			else {
				remove(tail);
				mp.remove(tail.key);
				Node created = new Node(k,v);
				sethead(created);
				mp.put(k,created);
			}
			
		}
	}
	
	//get data means getting and removing from Cache
	String get_data(String k) {
		if(mp.containsKey(k)) {
			Node existing = mp.get(k);
			remove(existing);
			mp.remove(k);
			return existing.val;
		}
		else{
			return null;		
		}
	}

	public static void main(String[] args){
	practice obj = new practice();
	
	obj.set_data("foo", "bar");
	obj.set_data("hello", "World");
	System.out.println(obj.get_data("foo"));
	System.out.println(obj.get_data("hello"));
	//obj.set_data("foo", "bar");
	obj.set_data("third", "Value");
	System.out.println(obj.get_data("foo"));
	}
}	
