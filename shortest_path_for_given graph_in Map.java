/*
Shortest Path

You wrote a trendy new messaging app, MeshMessage, to get around flaky cell phone coverage.

Instead of routing texts through cell towers, your app sends messages via the phones of nearby users, passing each message along from one phone to the next until it reaches the intended recipient. (Don't worry—the messages are encrypted while they're in transit.)

Some friends have been using your service, and they're complaining that it takes a long time for messages to get delivered. After some preliminary debugging, you suspect messages might not be taking the most direct route from the sender to the recipient.

Given information about active users on the network, find the shortest route for a message from one user (the sender) to another (the recipient). Return an array of users that make up this route.

There might be a few shortest delivery routes, all with the same length. For now, let's just return any shortest route.

Your network information takes the form of a hash map mapping username strings to an array of other users nearby:

  Map<String, String[]> network = new HashMap<String, String[]>() {{
    put("Min",     new String[] { "William", "Jayden", "Omar" });
    put("William", new String[] { "Min", "Noam" });
    put("Jayden",  new String[] { "Min", "Amelia", "Ren", "Noam" });
    put("Ren",     new String[] { "Jayden", "Omar" });
    put("Amelia",  new String[] { "Jayden", "Adam", "Miguel" });
    put("Adam",    new String[] { "Amelia", "Miguel", "Sofia", "Lucas" });
    put("Miguel",  new String[] { "Amelia", "Adam", "Liam", "Nathan" });
    put("Noam",    new String[] { "Nathan", "Jayden", "William" });
    put("Omar",    new String[] { "Ren", "Min", "Scott" });
    ...
}};

For the network above, a message from Jayden to Adam should have this route:

  { "Jayden", "Amelia", "Adam" }
  
Time complexity:
  In the worst case, we'll go through the BFS loop once for every node in the graph, since we only ever add each node to nodesToVisit once (we check howWeReachedNodes to see if we've already added a node before). Each loop iteration involves a constant amount of work to dequeue the node and check if it's our end node. If we have nn nodes, then this portion of the loop is O(N)O(N).

But there's more to each loop iteration: we also look at the current node's neighbors. Over all of the nodes in the graph, checking the neighbors is O(M)O(M), since it involves crossing each edge twice: once for each node at either end.

Putting this together, the complexity of the breadth-first search is O(N+M)O(N+M). 
  */
  
public static String[] constructpathUtil(String e, Map<String,String> path){
	
	List<String> res = new ArrayList<String>();
	
	while(e!=null){
		res.add(e);
		e=path.get(e);
	}
	
	Collections.reverse(res);
	return res.toArray(new String[res.size()]);
}
  
  public static String[] bfsGetPath(Map<String, String[]> graph, String startNode, String endNode){
	  
	  if(!graph.containsKeys(startNode) || !graph.containsKeys(endNode)){
		  throw new IllegalArgumentException("Start or end node doe snot exist in given graph map") ;
	  }
	  
	  Map<String,String> path = new HashMap<String,String>();
	  
	  path.put(startNode,null); //(current node, parent node)
	  Queue<String> q = new LinkedList<String>();
	  q.add(startNode);
	  
	  
	  while(!q.isEmpty()){
		  String r = q.remove();
		  
		  if((r).equals(endNode)){
			  return constructpathUtil(r,path);
		  }
		  
		  for(String s: graph.get(r)){
			  if(!path.containsKey(s)){ // if the node is not already visited
				  path.put(s,r);  //to track the path later
				  q.add(s);
			  }
		  }
	  }
	  
	  return null;
  }
  
  
  
  
  
  
  
  
  
  
  