/*
List of object is provided. The objects are either Integer or list of integers. Return a list of all integers.
example: given: [11,4,[2,5,6],[18]] => output: [11,4,2,5,6,18]
*/

package interview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class practice {

	List<Integer> combined_values(List<Object> arg_lst){

		int sz = arg_lst.size();
		List<Integer> result = new ArrayList<>();
		
		for(int i=0;i<sz;i++){
			Object temp = arg_lst.get(i);
			if(temp instanceof Integer){
				result.add((Integer)temp);
			}
			else {
				ArrayList<Object> tt = new ArrayList<>();
				//you can always cast any object to any type by up-casting it to Object first. like: (List<Customer>)(Object)list;
				tt.addAll((ArrayList<Integer>)(Object)temp);
			for(int j=0;j<tt.size();j++) {
				result.add((Integer)tt.get(j));
			}
			}
		}

		return result;
		}
	
	public static void main(String[] args) {
		practice obj = new practice();
		
		List<Object> inp = new ArrayList<Object>();
		inp.add(11);
		inp.add(4);
		
		ArrayList<Integer> inp_type2 = new ArrayList<>();
		inp_type2.add(2);
		inp_type2.add(5);
		inp_type2.add(6);
		
		inp.add(inp_type2);
		
		ArrayList<Integer> inp_type3 = new ArrayList<>();
		inp_type3.add(18);
		
		inp.add(inp_type3);
		
		
		
		
		List<Integer> output = obj.combined_values(inp);
		
		for(int i=0;i<output.size();i++) {
			System.out.println(output.get(i));
		}
	}

}
