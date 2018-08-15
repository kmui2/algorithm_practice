/*
A cryptarithm is a mathematical puzzle for which the goal is to find the correspondence between letters and digits, such that the given arithmetic equation consisting of letters holds true when the letters are converted to digits.

You have an array of strings crypt, the cryptarithm, and an array containing the mapping of letters and digits, solution. The array crypt will contain three non-empty strings that follow the structure: [word1, word2, word3], which should be interpreted as the word1 + word2 = word3 cryptarithm.

If crypt, when it is decoded by replacing all of the letters in the cryptarithm with digits using the mapping in solution, becomes a valid arithmetic equation containing no numbers with leading zeroes, the answer is true. If it does not become a valid arithmetic solution, the answer is false.

Example

For crypt = ["SEND", "MORE", "MONEY"] and

solution = [['O', '0'],
            ['M', '1'],
            ['Y', '2'],
            ['E', '5'],
            ['N', '6'],
            ['D', '7'],
            ['R', '8'],
            ['S', '9']]
the output should be
isCryptSolution(crypt, solution) = true.

When you decrypt "SEND", "MORE", and "MONEY" using the mapping given in crypt, you get 9567 + 1085 = 10652 which is correct and a valid arithmetic equation.

For crypt = ["TEN", "TWO", "ONE"] and

solution = [['O', '1'],
            ['T', '0'],
            ['W', '9'],
            ['E', '5'],
            ['N', '4']]
the output should be
isCryptSolution(crypt, solution) = false.

Even though 054 + 091 = 145, 054 and 091 both contain leading zeroes, meaning that this is not a valid solution.

Input:
crypt: ["A",  "A",  "A"]
solution: [["A","0"]]
Expected Output: true
*/

boolean isCryptSolution(String[] crypt, char[][] solution) {
    Map<Character,Character> mp = new HashMap<Character, Character>();
    for(int i=0;i<solution.length;i++){
        mp.put(solution[i][0],solution[i][1]);
    }
    int[] val = new int[crypt.length];
    
    for(int i=0;i<crypt.length;i++){
        char[] ch_crypt = crypt[i].toCharArray();
        for(int j=0;j<ch_crypt.length;j++){
            if(!mp.containsKey(ch_crypt[j])){
                return false;
            }
            if(mp.containsKey(ch_crypt[j]) && j==0 && ch_crypt.length>1 && mp.get(ch_crypt[j])=='0'){
                return false;
            }
            val[i] = val[i]*10+Character.getNumericValue(mp.get(ch_crypt[j]));
        }
    }
    
    if(val[0]+val[1]==val[2]){
        return true;
    }
    else {
        return false;
    }
}
