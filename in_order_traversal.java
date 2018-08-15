

/* Inorder traversal with and without recursion */

public class InOrderTraversal{

public static void in_order_traversal(Node root)    {

    //recursion way
    /*
    if(root==null){
    return;
    }
        
    in_order_traversal(root.left);
    System.out.println(root.data);
    in_order_traversal(root.right);
    */
    
    Stack st = new Stack();boolean flag = true;
    Node current = root;
    while(flag){
    if(current!=null){
    st.push(current);
    current = current.left;
    }
    else{
    if(!st.isEmpty()){
    Node p = (Node) st.pop();
    System.out.println(p.data);
    current = p.right;
    }
    else {
    flag = false;
    }
    }
    }
    
}
    
public static void main(String[] args)    {

Node r = new Node(8);
r.left =new Node(4);
r.right = new Node(16);
r.left.left = new Node(2);
r.left.right = new Node(5);
r.right.left = new Node(10);
r.right.right = new Node(17);
r.left.right.right = new Node(7);

int min = Integer.MIN_VALUE;
int max = Integer.MAX_VALUE;
in_order_traversal(r);

}


}