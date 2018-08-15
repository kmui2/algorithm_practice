/*
You have two integer arrays, a and b, and an integer target value v. Determine whether there is a pair of numbers, where one number is taken from a and the other from b, that can be added together to get a sum of v. Return true if such a pair exists, otherwise return false.

Example

For a = [1, 2, 3], b = [10, 20, 30, 40], and v = 42, the output should be
sumOfTwo(a, b, v) = true.
*/

boolean sumOfTwo(int[] a, int[] b, int v) {
    Map<Integer, Boolean> mp = new HashMap();
    for(int i=0;i<a.length;i++){
        if(!mp.containsKey(a[i])){
            mp.put(a[i],true);
        }
    }
    for(int i=0;i<b.length;i++){       
        if(mp.containsKey(v-b[i])){
            return true;
        }
    }
    return false;
}
