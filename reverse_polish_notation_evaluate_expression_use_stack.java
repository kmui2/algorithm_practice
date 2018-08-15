/*
Evaluate Expression
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  
Logic: use stack
*/  

public class Solution {
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> st= new Stack<Integer>();
        String operation ="+-*/";
        int sz = A.size();
        for(int i=0;i<sz;i++){
            
            if(!operation.contains(A.get(i))){
                
                st.push(Integer.parseInt(A.get(i)));
            }
            else{
                int b = st.pop();
                int a = st.pop();
                
                int c =0;
                switch(A.get(i)){
                    case "+": c = a+b; break;
                    case "-": c = a-b; break;
                    case "*": c = a*b; break;
                    case "/": c = a/b; break;
                }
              
                st.push(c); 
            }
            
        }
        
        return st.pop();
        
    }
}
