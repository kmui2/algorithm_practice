
/*
Question:

prog ::= expr
expr ::= int | '('func expr* ')'
func ::= '+' | '*' | …

31      -> 31
(+1 2) -> 3
(+3 4 5 6) -> 18
(+(*2 2)(*3 3)) -> (+4 9) -> 13

*/
/*
Thought process

loop until integer
	Find inner expression.
		get index of latest open bracket
		get index of close bracket if previous close bracket index is less than open bracket index
		get substring for these indices
	Calculate result for it
	Replace this inner expression with result.


*/

public class practice {

	int calc_expression(String expression){
		
		while(expression.indexOf('(')!=-1){
			
		
		
		//find index of last group inside bracket	
		
		int len=expression.length()-1;
		int index_open=0;
		int index_close=0;
		
		for(int i=len;i>=0;i--){
			if(expression.charAt(i)==')'){
				index_close=i;
			}
			if(expression.charAt(i)=='('){
				index_open=i;
				break;
			}
		}
		
		
		//calculate expression
		char[] ch_arr=(expression.substring(index_open+1,index_close)).toCharArray();
		String calc="";
		
		if(ch_arr[0]=='*'){
			int temp=1;
			for(int i=1;i<ch_arr.length;i++){
				if(ch_arr[i]!=' ') {
					temp = temp*Character.getNumericValue(ch_arr[i]);
				}
				
			}
			calc = Integer.toString(temp);
		}
		if(ch_arr[0]=='+'){
			int temp=0;
			for(int i=1;i<ch_arr.length;i++){
				temp = temp+Character.getNumericValue(ch_arr[i]);
			}
			calc = Integer.toString(temp);
		}
		
		
		//replace string from '(' to ')' with calculated expression
		String st = expression.substring(0,index_open)+calc+expression.substring(index_close+1,expression.length());
		expression = st;
		
		//repeat as long as we have '('
					
		}
				
		//return expression
		return Integer.parseInt(expression);
		
	}
	
	public static void main(String[] args){
		
		String st="(+(*2 2)(*3 3))";
		practice obj = new practice();
		System.out.println(obj.calc_expression(st));
	}
}l