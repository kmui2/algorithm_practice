
// Word Bags

// Given a list of words, group them by the vowels (AEIOUY) they contain. A word with multiple diffe
// rent vowels may appear in multiple groups, but should not appear in a single group more than once.

// Examples:
// ["hot", "cold", "warm", "every"] => { "o": ["hot", "cold"], "a": ["warm"], "e": ["every"], "y": ["every"] }
// [ "cat", "team", "bet"] => { "a": ["cat", "team"], "e": ["team", "bet"] }


package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


import com.google.gson.Gson;

public class practice{


	
	public void add_vowels(Map<Character, HashSet<String>> mp,char[] vowels) {
		
		HashSet<String> temp = new HashSet<String>();
		for(int i=0;i<vowels.length;i++) {
			mp.put(vowels[i], temp);
		}
		
	}

	public void add_words_util(String word, Map<Character, HashSet<String>> mp,char[] vowels) {
		
		for(int i=0;i<vowels.length;i++) {
			if(word.indexOf(vowels[i])!=-1) {
				HashSet<String> temp1 = new HashSet<String>();
				temp1.addAll(mp.get(vowels[i]));						
				temp1.add(word);
				mp.put(vowels[i], temp1);			
			}		
		}
	}

	public void add_words(Map<Character, HashSet<String>> mp, String[] words, char[] vowels) {
		
		for(int i=0;i<words.length;i++) {
			add_words_util(words[i],mp,vowels);
		}
	}
		
		
	public static void main(String[] args) {
		
		String[] given_words= {"hot", "cold", "warm", "every"};
		char[] vowels = {'a','e','i','o','u','y'};
		
		practice obj = new practice();
		Map<Character, HashSet<String>> mp = new HashMap<Character, HashSet<String>>();
		
		obj.add_vowels(mp,vowels);

		
		
		obj.add_words(mp, given_words,vowels);

		
		
		
		Gson gson = new Gson();
		String json = gson.toJson(mp);
		System.out.println(json);
	}

	}

-----------------------------Js-----------------------


function key_value(String[] words)
{
var vowel_words= {};
for(var i=0;i<words.length;i++){
	if(words[i].indexOf('a')!=-1){
		if(vowel_words.hasOwnProperty("a")){
		vowel_words.a.push(words[i]);
		}
		else{
		vowel_words.a=[words[i]];
		}
	}
	if(words[i].indexOf('e')!=-1){
		if(vowel_words.hasOwnProperty("e")){
		vowel_words.e.push(words[i]);
		}
		else{
		vowel_words.e=[words[i]];
		}
	}
	if(words[i].indexOf('i')!=-1){
		if(vowel_words.hasOwnProperty("i")){
		vowel_words.i.push(words[i]);
		}
		else{
		vowel_words.i=[words[i]];
		}
	}
	if(words[i].indexOf('o')!=-1){
		if(vowel_words.hasOwnProperty("o")){
		vowel_words.o.push(words[i]);
		}
		else{
		vowel_words.o=[words[i]];
		}
	}
	if(words[i].indexOf('u')!=-1){
		if(vowel_words.hasOwnProperty("u")){
		vowel_words.u.push(words[i]);
		}
		else{
		vowel_words.u=[words[i]];
		}
	}
	if(words[i].indexOf('y')!=-1){
		if(vowel_words.hasOwnProperty("y")){
		vowel_words.y.push(words[i]);
		}
		else{
		vowel_words.y=[words[i]];
		}
	}
}

console.log(JSON.stringify(vowel_words));
}

var given_words1= ["hot", "cold", "warm", "every"];
var given_words2= [ "cat", "team", "bet"];
key_value(given_words1);
key_value(given_words2);
