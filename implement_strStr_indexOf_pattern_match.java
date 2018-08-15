/*
LeetCode – Implement strStr() (Java)
 
Problem:

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

In Java it is "indexOf()"

The KMP (Knuth-Morris-Pratt) algorithm has a better worst-case performance than the straightforward algorithm. KMP spends a little time precomputing a table (on the order of the size of W[], O(n)), and then it uses that table to do an efficient search of the string in O(k). 

=> O(k+n) for table creation and search using KMP.

if we do simple naive method, it will be O(mn).

Nice explanation of KMP algorithm in: https://www.youtube.com/watch?v=GTJr8OvyEVQ&t=51s
*/

//create an array to store the prefix, suffix matching logic based on KMP algorithm
public void compute_temp_sufix_prefix_array_for_needle(char[] needle_arr, int[] suffix_prefix_needle_arr){
	
	int j=0;
	int i=1;
	int len_needle = needle_arr.length;	
	//when int array is initialized, all values are 0. hence suffix_prefix_needle_arr[0] =0
	
	while(i<len_needle){
		if(needle_arr[j]==needle_arr[i]){
			suffix_prefix_needle_arr[i] = j+1;
			i++; j++;
		}
		else{
			if(j!=0){
				j=suffix_prefix_needle_arr[j-1];
			}	
			else{
				suffix_prefix_needle_arr[i]=0;
				i++;
			}
		}
	}
}


public int strStr(String haystack, String needle) {
	
	int result_index=-1;
	
	int[] suffix_prefix_needle_arr = new int[needle.length()]; 
	char[] needle_arr = needle.toCharArray();
	compute_temp_sufix_prefix_array_for_needle(needle_arr,suffix_prefix_needle_arr);
	
	char[] haystack_arr = haystack.toCharArray();
	int len_haystack = haystack_arr.length;
	
	int len_needle = needle_arr.length;
	
	int haystack_index=0;
	int needle_index=0;
	
	while(haystack_index<len_haystack && needle_index<len_needle){
		
		if(needle_arr[needle_index]==haystack_arr[haystack_index]){
			needle_index++; haystack_index++;
		}
		else{
			if(needle_index>0){
				needle_index=suffix_prefix_needle_arr[needle_index-1];
			}
			else{
				haystack_index++;
			}
		}
	}
	
	//all in needle is in haystack
	if(needle_index==len_needle){
		//index of needle in haystack
		result_index=haystack_index-needle_index;
	}
	
	return result_index;
	
}

public static void main(String[] args){
	practice obj = new practice();
	System.out.println(obj.strStr("abcdabctyabctxabyrabctxabmkh","abctxabm"));
}


//output: 18










