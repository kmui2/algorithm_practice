
/*
Given an array strings, determine whether it follows the sequence given in the patterns array. In other words, there should be no i and j for which strings[i] = strings[j] and patterns[i] ≠ patterns[j] or for which strings[i] ≠ strings[j] and patterns[i] = patterns[j].

Example

For strings = ["cat", "dog", "dog"] and patterns = ["a", "b", "b"], the output should be
areFollowingPatterns(strings, patterns) = true;
For strings = ["cat", "dog", "doggy"] and patterns = ["a", "b", "b"], the output should be
areFollowingPatterns(strings, patterns) = false.
For strings = ["cat", "dog", "dog"] and patterns = ["a", "b", "c"], the output should be
areFollowingPatterns(strings, patterns) = false;
*/

boolean areFollowingPatterns(String[] strings, String[] patterns) {
    Map<String,String> mp=new HashMap();
    Map<String,String> mp2=new HashMap();
    for(int i=0;i<patterns.length;i++){
        if(!mp.containsKey(patterns[i])){
            mp.put(patterns[i],strings[i]);
        }
        else{
            if(!mp.get(patterns[i]).equals(strings[i])){
                return false;
            }
        }
        
		//for passing 3rd test case  
        if(!mp2.containsKey(strings[i])){
            mp2.put(strings[i],patterns[i]);
        }
        else{
            if(!mp2.get(strings[i]).equals(patterns[i])){
                return false;
            }
        }
        
    }
    return true;
}
