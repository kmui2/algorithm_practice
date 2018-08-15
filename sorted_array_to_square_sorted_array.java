/*
given sorted input, square them and provide sorted output.
constraint: must be O(n)

hint: separate the given array into 2 arrays (negative and positive groups)
*/

public static void main(String[] args){

	int[] inp = {-5,-3,1,4,5,10};
	//expected output: {1,9,16,25,25,100}
	
	List<Integer> neg = new ArrayList<Integer>();
	List<Integer> pos = new ArrayList<Integer>();
	
	for(int i=0;i<inp.length;i++){
		if(inp[i]<0){
			neg.add(inp[i]*inp[i]);
		}
		else{
			pos.add(inp[i]*inp[i]);
		}
	}
	
	List<Integer> output = new ArrayList<Integer>(inp.length);
	
	int neg_size = neg.size();
	int pos_size = pos.size();
	int neg_start_index = neg_size-1;
	int pos_start_index = 0;
	
	while(neg_start_index>=0 || pos_start_index<pos_size){
		if(neg_start_index>=0 && pos_start_index<pos_size){
			if(neg.get(neg_start_index)<=pos.get(pos_start_index)){
				output.add(neg.get(neg_start_index));
				neg_start_index--;
			}
			else{
				output.add(pos.get(pos_start_index));
				pos_start_index++;
			}
		}
		else if(neg_start_index>=0){
			output.add(neg.get(neg_start_index));
			neg_start_index--;
		}
		else{
			output.add(pos.get(pos_start_index));
			pos_start_index++;
		}
	}

	System.out.println("Output:"+output);
}