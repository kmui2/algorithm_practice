/*
The deletion distance between two strings is the minimum sum of ASCII values of characters that you need to delete in the two strings in order to have the same string. The deletion distance between cat and at is 99, because you can just delete the first character of cat and the ASCII value of 'c' is 99. The deletion distance between cat and bat is 98 + 99, because you need to delete the first character of both words. Of course, the deletion distance between two strings can't be greater than the sum of their total ASCII values, because you can always just delete both of the strings entirely. Implement an efficient function to find the deletion distance between two strings. You can refer to the Wikipedia article on the algorithm for edit distance if you want to. The algorithm there is not quite the same as the algorithm required here, but it's similar.

*/

// you can import things up here if you want

public class UserSolution {
    public static int ascii_deletion_distance(String str1, String str2) {
        int[] letters = new int[256];
        int result=0;
        
        if(str1==null && str2==null){
            return 0;
        }
        
        int len1=str1==null?0:str1.length();
        int len2=str2==null?0:str2.length();
        
        for(int i=0;i<len1;i++){
            letters[str1.charAt(i)]++;
        }
        
        for(int i=0;i<len2;i++){
            letters[str2.charAt(i)]--;
        }
        
        for(int i=0;i<256;i++){
            result=result+(Math.abs(letters[i])*i);
        }
        
        return result;
    }
}
