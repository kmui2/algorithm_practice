

//NOT Correct.  Need to swap connected indices only and sort only those in descending order.
/*
Given a string str and array of pairs that indicates which indices in the string can be swapped, return the lexicographically largest string that results from doing the allowed swaps. You can swap indices any number of times.

Example

For str = "abdc" and pairs = [[1, 4], [3, 4]], the output should be
swapLexOrder(str, pairs) = "dbca".

By swapping the given indices, you get the strings: "cbda", "cbad", "dbac", "dbca". The lexicographically largest string in this list is "dbca".
*/

char[] swap_char(char[] ch, ArrayList<Integer> ind){
	Collections.sort(ind);
	ArrayList<Character> ch_to_swap = new ArrayList<Character>(ind.size());
	for(int i=0;i<ind.size();i++){
		ch_to_swap.add(ch[ind.get(i)-1]); //pairs in question are provided assuming index starts from 1
	}
	Collections.sort(ch_to_swap); 
        Collections.reverse(ch_to_swap); //sort descending order
	for(int i=0;i<ind.size();i++){
		ch[ind.get(i)-1] = ch_to_swap.get(i);
	}
	return ch;
	
}

String swapLexOrder(String str, int[][] pairs) {
	Map<Integer, Integer> combine_pair_count = new HashMap<Integer, Integer>();
	Map<Integer, ArrayList<Integer>> indices = new HashMap<Integer, ArrayList<Integer>>();
	
	int count =0;
	for(int i=0;i<pairs.length;i++){
		int temp=0; int key_for_indices=0;
		if(combine_pair_count.containsKey(pairs[i][0])){
			temp = combine_pair_count.get(pairs[i][0]);
		}
		else{
			if(combine_pair_count.containsKey(pairs[i][1])){
			temp = combine_pair_count.get(pairs[i][1]);
			}
		}
		if(temp!=0){ //found the key
			combine_pair_count.put(pairs[i][0],temp);
			combine_pair_count.put(pairs[i][1],temp);
			key_for_indices=temp;
		}
		else{ //key not found
			count++;
			combine_pair_count.put(pairs[i][0],count);
			combine_pair_count.put(pairs[i][1],count);
			key_for_indices=count;
		}
		//enter in indices map
		ArrayList<Integer> templist = new ArrayList<Integer>();		
		if(indices.containsKey(key_for_indices)){			
			templist=indices.get(key_for_indices);
			if(!templist.contains(pairs[i][0])){ //include unique indices only
				templist.add(pairs[i][0]);
			}
			if(!templist.contains(pairs[i][1])){ //include unique indices only
				templist.add(pairs[i][1]);
			}
			indices.put(key_for_indices,templist);			
		}
		else{
			templist.add(pairs[i][0]);
			templist.add(pairs[i][1]);
			indices.put(key_for_indices,templist);
		}
		
	}
	
	char[] ch = str.toCharArray();
	Iterator it = indices.entrySet().iterator();
	while(it.hasNext()){
		Map.Entry pair = (Map.Entry)it.next();
		ch=swap_char(ch,(ArrayList<Integer>)pair.getValue());        
	}
	
	return String.valueOf(ch);
}



////////////////////////////////////////////////////////////////////////


public class practice_2017 {

   String swapLexOrder(String str, int[][] pairs) {
    
    char[] ch = str.toCharArray();
    String orig=str;
    char temp;
    Map<String,Boolean> mp = new TreeMap();
    Boolean found=false;
    while(!found){
        for(int i=0;i<pairs.length;i++){
                temp = ch[pairs[i][0]-1];                
                ch[pairs[i][0]-1]=ch[pairs[i][1]-1];
                ch[pairs[i][1]-1]=temp;  
                str=String.valueOf(ch);                
                if(!mp.containsKey(str)){
                mp.put(str,true);
                }
                //System.out.println("str keys="+str);
        }
        
        if(str.equals(orig)){
            //System.out.println("str ="+str);
            //System.out.println("orig="+orig);
        found=true;
        }
    }
    Iterator it = mp.entrySet().iterator();
    String res="";
     while(it.hasNext()){
        Map.Entry<String,Boolean> pair = (Map.Entry)it.next();
        res=pair.getKey();   
         //System.out.println("keys="+res);
     }
    return res;
}

    
    
    
   public static void main(String[] args){
	practice_2017 obj= new practice_2017();
        String str="acxrabdz";
        int[][] pairs={{1,3},{6,8},{3,8},{2,7}};
	System.out.println(obj.swapLexOrder(str, pairs));
}
}