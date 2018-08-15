/*
Clone Graph
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
*/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null){
            return null;
        }
        
        Map<UndirectedGraphNode,UndirectedGraphNode> mp = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        
        q.add(node);
        mp.put(node,new UndirectedGraphNode(node.label));
        
        while(!q.isEmpty()){
            UndirectedGraphNode n=q.remove();
            List<UndirectedGraphNode> n_neighbors = n.neighbors;
            UndirectedGraphNode n_cloned = mp.get(n);
            
            for(int i=0;i<n_neighbors.size();i++){
                UndirectedGraphNode a_neighbor = n_neighbors.get(i);
                
                if(!mp.containsKey(a_neighbor)){
                    q.add(a_neighbor);
                    mp.put(a_neighbor,new UndirectedGraphNode(a_neighbor.label));
                }
                
                UndirectedGraphNode a_cloned_neighbor = mp.get(a_neighbor);
                n_cloned.neighbors.add(a_cloned_neighbor);
                
            }
        }
        
        return mp.get(node);
    }
}
