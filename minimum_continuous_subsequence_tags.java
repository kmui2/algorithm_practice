/*
Input:
targetList=["made","in","Spain"]  (//unique elements)
availableTagList=["made","weather","forecast","says","that",made","rain","in","Spain","stays"] (//may contain duplicate)

Output: [5,8]
Explanation: there are 2 possible answers: 
[0,8] i.e: size=9 ("made" is in index 0 and "Spain" is in index 8 "in" is inclusive in this index) 
[5,8] i.e: size=4 ("made" is in index 5 and "Spain" is in index 8 "in" is inclusive in this index) 

*/

List<Integer> subSequenceTags(List<String> targetList, List<String> availableTagList){
	
	//put availableTagList in HashMap with string and index
	Map<String, ArrayList<Integer>> mp = new HashMap<>();
	for(int i=0;i<availableTagList.length;i++){
		ArrayList<Integer> temp = new ArrayList<>();
		if(!mp.containsKey(availableTagList[i])){			
			temp.add(i);
			mp.put(availableTagList[i],temp);
		}
		else{
			temp.add(mp.get(availableTagList[i]));
			temp.add(i);
			mp.put(availableTagList[i],temp);
		}
	}
	
	//find the list for number of times the first target word is repeated in availableTagList
	int len_first_target=0;
	if(!mp.containsKey(targetList[0])){
			List<Integer> empt = new ArrayList<>();
			return empt;
		}
	else{
			len_first_target = (mp.get(targetList[0])).size();
		}
	
	int prev;
	int last;
	List<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
	//loop list for number of times the first target word is repeated in availableTagList
	for(int i=0;i<len_first_target;i++){
		//get the first index from the arraylist
			prev=(mp.get(targetList[0])).get(i);
			last=loop_to_get_last(mp,prev);
			
			if(last!=-1){
				List<Integer> temp = new ArrayList<>();
				temp.add(prev);
				temp.add(last);
				resultList.add(temp);
			}
	}
		

}


int loop_to_get_last(Map<String, ArrayList<Integer>> mp, int prev){
	int last=-1;
	for(int i=1;i<targetList.length;i++){
		//if mp does not contain targetlist, return -1
		if(!mp.containsKey(targetList[i])){
			return -1;
		}
		
		//if mp contains, see the index is > prev
		if(mp.containsKey(targetList[i])){
			int index=(mp.get(targetList[i])).get(0); //get the first saved index
			
			if(prev>index){
				
			}
		}
		//if >prev, prev=index
		
		//if i=targetList-1; last = index
		
		//remove index
	}
	return last;
}





