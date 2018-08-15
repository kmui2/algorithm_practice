/*
LeetCode – Wildcard Matching (Java)
 
Implement wildcard pattern matching with support for '?' and '*'.

To understand this solution, you can use s="aab" and p="*ab".
s="abcdefggh" p="a?cd*gh"

Hint:
Need to have 2 kind of main indexes and based on these, other indexes varies.
main indexes: index where we find *. index from where the comparison started in s string.
*/

public class practice{
	
	public static boolean wildcardPatternMatch(String s, String p){
		int starIndex =-1;
		int iIndex=-1;
		
		int i=0;
		int j=0;
		
		while(i<s.length()){
			if(j<p.length() && (p.charAt(j)=='?' || p.charAt(j)==s.charAt(i))){
				j++;
				i++;
			}
			else if(j<p.length() && p.charAt(j)=='*'){
				starIndex=j;
				iIndex=i;
				j++;
			}
			else if(starIndex!=-1){
				j=starIndex+1;
				i=iIndex+1;
				iIndex++;
			}
			else{
				return false;
			}
		
		}
		
		while(j<p.length() && p.charAt(j)=='*'){
			j++;
		}
		
		if(j==p.length()){
			return true;
		}
		else{
			return false;
		}
	}
	
		public static void main(String[] args){
			
			String s="aeaabcdab";
			String p="a?a*ab"; //*ab
			System.out.println(wildcardPatternMatch(s,p));
			
		}
}
