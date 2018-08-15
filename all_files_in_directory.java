/*
show all files in the given directory.

	d1/
		a.txt
		bb/
			c.txt
			d.log

Output: a.txt, c.txt, d.log			

*/

package interview;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class practice{

	List<String> log_names(String start_filepath){
		
		Stack<String> s = new Stack<String>();
		List<String> result = new ArrayList<String>();
		s.push(start_filepath);
		while(!s.isEmpty()) {
			String path = s.pop();
			File f= new File(path);
			
			if(f.isDirectory()) {
				File[] list_of_files = f.listFiles();
				for(File lst : list_of_files) {
					s.push(lst.getPath());
				}
			}
			
			else {
				result.add(f.getName());
			}
		}
		
		return result;
	}
	
	public static void main(String[] args){
		practice obj = new practice();
		String filepath = "E:\\eclipse-workspace\\interview\\src\\external_files";
		System.out.println(obj.log_names(filepath));
	}
	
	
	
}