/*
print path of binary tree. use dfs
*/

class Node {
    Node right;
    Node left;
    int data;
    Node(int d){
    this.data = d;
    this.left=null;
    this.right = null;
    }
}

public class practice {
    
	public void print_path_util(Node root, List<Integer> path){
		if(root==null){
			return;
		}
		path.add(root.data);
		if(root.left==null && root.right==null){
			//print path
			for(int i=0;i<path.size();i++){
				System.out.print(path.get(i));			
			}
			System.out.println("");
		}
		print_path_util(root.left,path);
		print_path_util(root.right,path);
		path.remove(path.size()-1);
	}

	public void print_path(Node root){
		List<Integer> path = new ArrayList<>();
		print_path_util(root,path);
	}

	public static void main(String[] args){
		
		Node r = new Node(8);
		r.left =new Node(4);
		r.right = new Node(16);
		r.left.left = new Node(2);
		r.left.right = new Node(5);
		r.right.left = new Node(10);
		r.right.right = new Node(17);
		r.left.right.right = new Node(7);
		
		practice obj = new practice();
		obj.print_path(r);
	}
}