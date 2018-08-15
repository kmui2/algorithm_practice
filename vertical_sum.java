
/*
Vertical Sum in a given Binary Tree | Set 1
3.1
Given a Binary Tree, find maximum vertical sum of the nodes that are in same vertical line. Print maximum sums through different vertical lines.

Examples:

      1
    /   \
  2      3
 / \    / \
4   5  7   6
The tree has 5 vertical lines

Vertical-Line-1 has only one node 4 => vertical sum is 4
Vertical-Line-2: has only one node 2=> vertical sum is 2
Vertical-Line-3: has three nodes: 1,5,7 => vertical sum is 1+5+7 = 13
Vertical-Line-4: has only one node 3 => vertical sum is 3
Vertical-Line-5: has only one node 6 => vertical sum is 6

So expected output is 13

*/

class Tree {
   Tree(int x) {
     value = x;
   }
   int value;
   Tree left;
   Tree right;
 }
 public class practice_2017 {

    public int sumcolumn(Tree N){
     
     HashMap<Integer, Integer> mp = new HashMap();
     
     sumcolumnUtil(N,0,mp);
     
     Iterator it = mp.entrySet().iterator();
     int max=Integer.MIN_VALUE;
     while(it.hasNext()){
         Map.Entry<Integer, Integer> pair = (Map.Entry)it.next();
         if(pair.getValue()>max){
             max=pair.getValue();
         }
     }
     return max;
     }
    
    public void sumcolumnUtil(Tree N, int k, HashMap mpp){
        if(N==null){
        return;
        }
    if(!mpp.containsKey(k)){
        mpp.put(k,N.value);
    }
    else{
        int added = (int) mpp.get(k);
        added = added+N.value;
        mpp.put(k,added);
    }
    sumcolumnUtil(N.left,k-1,mpp);
    sumcolumnUtil(N.right,k+1,mpp);
    }
     
public static void main(String[] args){
	 
        practice_2017 obj = new practice_2017();
        Tree r = new Tree(1);
r.left =new Tree(2);
r.right = new Tree(3);
r.left.left = new Tree(4);
r.left.right = new Tree(5);
r.right.left = new Tree(7);
r.right.right = new Tree(6);
        System.out.println(obj.sumcolumn(r));
}
 }