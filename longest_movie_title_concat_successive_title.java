/*
Print (or return) the longest movie title found by successively matching the last and first words in each title, joining to form new titles, given a file containing a list of movie titles. 
For example: 'OF MICE AND MEN' and 'MEN IN BLACK' join to form 'OF MICE AND MEN IN BLACK'. 
You could further join 'OF MICE AND MEN IN BLACK' wth 'BLACK MASS' to form 'OF MICE AND MEN IN BLACK MASS'. 

The longest title I found (at 143 characters is): WENT TO CONEY ISLAND ON A MISSION FROM GOD BE BACK BY FIVE WIVES THREE SECRETARIES AND ME WITHOUT YOU CANT TAKE IT WITH YOU WERE NEVER LOVELIER

Assumption:
movie names are more than 1 word long.
each word separated with space
*/


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;



public class practice{
	
	String get_last_word(String movie_name){
		String[] movie = movie_name.split(" ");
		return movie[movie.length-1];
	}
	String get_first_word(String movie_name){
		String[] movie = movie_name.split(" ");
		return movie[0];
	}
	String get_word_except_first(String movie_name){
		int i=0;
		while(movie_name.charAt(i)!=' '){
			i++;
		}
		return movie_name.substring(i+1,movie_name.length());
	}

	String movie_name_concat(String filename) throws Exception{
		File f = new File(filename);
		BufferedReader br = new BufferedReader(new FileReader(f));
		String first_movie_name = br.readLine();
		String last_word = get_last_word(first_movie_name);
		
		ArrayList<String> result_arr = new ArrayList<String>();
		String second_movie_name = br.readLine();
		
		System.out.println("1st= "+first_movie_name+" 2nd= "+second_movie_name);
		
		while(second_movie_name!=null){
			String first_word = get_first_word(second_movie_name);
			
			if(last_word.equals(first_word)){
				first_movie_name = first_movie_name + " "+get_word_except_first(second_movie_name);
				last_word = get_last_word(second_movie_name);				
			}
			else{
				result_arr.add(first_movie_name);
				first_movie_name = second_movie_name;
				last_word = get_last_word(second_movie_name);
			}
			second_movie_name = br.readLine();
		}
		result_arr.add(first_movie_name); //may have duplicate for last movie name 
										//if last_word of previous was != first word of last movie name. 
										//i.e: if the process went through else block
		br.close();
		
		int max_val = Integer.MIN_VALUE;
		int max_index=0;
		for(int i=0;i<result_arr.size();i++){
			if(result_arr.get(i).length()>max_val){
				max_val = result_arr.get(i).length();
				max_index =i;
			}
		}
		return result_arr.get(max_index);	
	}
	
	public static void main(String[] args){
	practice obj = new practice();
	String filename = "E:\\eclipse-workspace\\interview\\src\\external_files\\names.txt";
	
	try {
	System.out.println(obj.movie_name_concat(filename));
	}
	catch(Exception e) {
		e.printStackTrace();
	}

	}
}	