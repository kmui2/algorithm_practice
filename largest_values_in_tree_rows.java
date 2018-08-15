/*
You have a binary tree t. Your task is to find the largest value in each row of this tree. In a tree, a row is a set of nodes that have equal depth. For example, a row with depth 0 is a tree root, a row with depth 1 is composed of the root's children, etc.

Return an array in which the first element is the largest value in the row with depth 0, the second element is the largest value in the row with depth 1, the third element is the largest element in the row with depth 2, etc.

Example

For

t = {
    "value": -1,
    "left": {
        "value": 5,
        "left": null,
        "right": null
    },
    "right": {
        "value": 7,
        "left": null,
        "right": {
            "value": 1,
            "left": null,
            "right": null
        }
    }
}
the output should be largestValuesInTreeRows(t) = [-1, 7, 1].

The tree in the example looks like this:

    -1
   / \
  5   7
       \
        1
In the row with depth 0, there is only one vertex - the root with value -1;
In the row with depth 1, there are two vertices with values 5 and 7, so the largest value here is 7;
In the row with depth 2, there is only one vertex with value 1.
*/
//
// Definition for binary tree:
// class Tree<T> {
//   Tree(T x) {
//     value = x;
//   }
//   T value;
//   Tree<T> left;
//   Tree<T> right;
// }
int[] largestValuesInTreeRows(Tree<Integer> t) {
    Queue<Tree> q1 = new LinkedList();
    Queue<Tree> q2 = new LinkedList();
    List<Integer> res = new ArrayList();
    if(t==null){
        return new int[0];
    }
    q1.add(t);
    Integer largest=t.value;    
    while(!q1.isEmpty() || !q2.isEmpty()){
        Tree<Integer> temp_peek = q1.peek();
        largest = temp_peek.value;
        while(!q1.isEmpty()){
            Tree<Integer> temp = q1.remove();
            if(temp.value>=largest){
                largest = temp.value;
            }
            q2.add(temp);
        }
        res.add(largest);
        while(!q2.isEmpty()){
            Tree<Integer> temp2 = q2.remove();
            if(temp2.left!=null){
                q1.add(temp2.left);
            }
            if(temp2.right!=null){
                q1.add(temp2.right);
            }
        }
    }
    int[] res_int = new int[res.size()];
    for(int i=0;i<res_int.length;i++){
        res_int[i]=res.get(i);
    }
    return res_int;
}
