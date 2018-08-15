/*
LeetCode – Word Ladder II (Java)
 
Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that: 1) Only one letter can be changed at a time, 2) Each intermediate word must exist in the dictionary.

For example, given: start = "hit", end = "cog", and dict = ["hot","dot","dog","lot","log"], return:


   [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
  
  Note: in this program we found all the sequences. we can have a variable to save the min step with min_step as a param in word_cl. OR we can run through the size of final list and get the minimum one.
*/  


class word_cl{
	String word;
	word_cl pre_word;
	
	public word_cl(String w,word_cl pw){
		this.word = w;
		this.pre_word = pw;
	}

}

public class practice{
	

	ArrayList<ArrayList<String>> short_length(String start, String end, Set<String> dict){

		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		if(start.equals(end)){
			return result;
		}
		
		Queue<word_cl> q = new LinkedList<word_cl>();
		dict.add(start);
		dict.add(end);
		
		q.add(new word_cl(start,null));
		
		while(!q.isEmpty()){
			word_cl q_poll = q.remove();
			char[] q_poll_ch = q_poll.word.toCharArray();
			
			
			for(int i=0;i<q_poll_ch.length;i++){
				char temp_for_swap = q_poll_ch[i];
				for(char c='a';c<='z';c++){
					if(temp_for_swap!=c){
						q_poll_ch[i]=c;
						String new_st = new String(q_poll_ch);
																	
						if(new_st.equals(end)){							
							ArrayList<String> path = new ArrayList<String>();
							path.add(new_st);
							word_cl words_in_path = q_poll;
							while(words_in_path.pre_word!=null){
								path.add(0,words_in_path.word);
								words_in_path = words_in_path.pre_word;
							}
							
							path.add(0,words_in_path.word);
							result.add(path);
							break;
						}
						
						if(dict.contains(new_st)){
							q.add(new word_cl(new_st,q_poll));					
						}									
					}
				}
				q_poll_ch[i] = temp_for_swap;
			}
			
			dict.remove(q_poll.word);
		
		}
		
		return result;

	}

	public static void main(String[] args){
	practice obj = new practice();
	Set<String> dict = new HashSet<String>();
	dict.add("hot");
	dict.add("dot");
	dict.add("dog");
	dict.add("lot");
	dict.add("log");
	ArrayList<ArrayList<String>> output = obj.short_length("hit","cog",dict);
	for(int i=0;i<output.size();i++) {
		System.out.println(output.get(i));
	}
	
	}
}	
