
/*
You have a list of dishes. Each dish is associated with a list of ingredients used to prepare it. You want to group the dishes by ingredients, so that for each ingredient you'll be able to find all the dishes that contain it (if there are at least 2 such dishes).

Return an array where each element is a list with the first element equal to the name of the ingredient and all of the other elements equal to the names of dishes that contain this ingredient. The dishes inside each list should be sorted lexicographically. The result array should be sorted lexicographically by the names of the ingredients in its elements.

Example

For
  dishes = [["Salad", "Tomato", "Cucumber", "Salad", "Sauce"],
            ["Pizza", "Tomato", "Sausage", "Sauce", "Dough"],
            ["Quesadilla", "Chicken", "Cheese", "Sauce"],
            ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]]
the output should be
  groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Salad", "Salad", "Sandwich"],
                            ["Sauce", "Pizza", "Quesadilla", "Salad"],
                            ["Tomato", "Pizza", "Salad", "Sandwich"]]
							
*/	

public class practice_2017 {

   String[][] groupingDishes(String[][] dishes) {
    Map<String, ArrayList<String>> map = new TreeMap();
    //iterate once to create the HashMap
    for(int k=0;k<dishes.length;k++)
        for(int i = 1; i<dishes[k].length; i++){
            ArrayList<String> cl = new ArrayList();
            if(!map.containsKey(dishes[k][i])){
                cl.add(dishes[k][0]);
                map.put(dishes[k][i], cl);
            }
            else {
				cl.addAll(map.get(dishes[k][i]));
				cl.add(dishes[k][0]);
				map.put(dishes[k][i],cl);
                //map.get(dishes[k][i]).add(dishes[k][0]);
            }  
        }
    
    //iterate a second time to remove the ingredients having only one associated dish
    //And sort the List if it's not the case     
   for(int k=0;k<dishes.length;k++)
        for(int i = 1; i<dishes[k].length; i++){
            if(map.get(dishes[k][i]).size() < 2) map.remove(dishes[k][i]);
            else Collections.sort(map.get(dishes[k][i]));
        }
            
    String[][] res = new String[map.size()][];
    int index = 0;
    
    Iterator it = map.entrySet().iterator();
     while(it.hasNext()){
        Map.Entry<String,ArrayList<String>> pair = (Map.Entry)it.next();
        //add the ingredient at the beginning of the list
        pair.getValue().add(0, pair.getKey());
        res[index++] = pair.getValue().toArray(new String[0]);
     }
       
    return res;
}

    public static void main(String[] args){
        
        String[][]dishes= {{"Salad","Tomato","Cucumber","Salad","Sauce"},{"Pizza","Tomato","Sausage","Sauce","Dough"}};
 
        practice_2017 obj= new practice_2017();

        String[][] output= obj.groupingDishes(dishes);
        
       for(int i = 0; i < output.length; i++)
{
    for(int j = 0; j < output[i].length; j++)
    {
        System.out.print(output[i][j]);
        if(j < output[i].length - 1) System.out.print(" ");
    }
    System.out.println();
}
        
    }
}