/*
You have a collection of coins, and you know the values of the coins and the quantity of each type of coin in it. You want to know how many distinct sums you can make from non-empty groupings of these coins.

Example

For coins = [10, 50, 100] and quantity = [1, 2, 1], the output should be
possibleSums(coins, quantity) = 9.

Here are all the possible sums:

50 = 50;
10 + 50 = 60;
50 + 100 = 150;
10 + 50 + 100 = 160;
50 + 50 = 100;
10 + 50 + 50 = 110;
50 + 50 + 100 = 200;
10 + 50 + 50 + 100 = 210;
10 = 10;
100 = 100;
10 + 100 = 110.
As you can see, there are 9 distinct sums that can be created from non-empty groupings of your coins.
*/
//Brute Force for the sample provided//
int possibleSums(int[] coins, int[] quantity) {
    int sum=0;
    int possibleuniqueSums =0;
    Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
    for(int i=0;i<=1;i++){
        for(int j=0;j<=2;j++){
            for(int k=0;k<=1;k++){
                sum=10*i+50*j+100*k;
                if(sum!=0){
                    if(!mp.containsKey(sum)){
                        mp.put(sum,1);
                        possibleuniqueSums++;
                    }
                }
            }
        }
    }
    return possibleuniqueSums;
}
//for universal solution:
/*
Don't gather all the combinations, just the sums.

Your set of sums starts with [0]. Cycle through the coins, one at a time. For each coin, iterate through its quantity, adding that multiple to each item of the set. Set-add each of these sums to the set. For example, let's take that original case: coins = [1, 2, 3], quant = [1, 2, 2]. Walking through this ...

sum_set = {0}
current_coin  = 1;  #  coin[0]
current_quant = 1;  # quant[0]
This step is trivial ... add 1 to each element of the set.  This gives you {1}.
Add that to the existing set.  You now have
sum_set = {0, 1}
Next coin:

current_coin  = 2;  #  coin[0]
current_quant = 2;  # quant[0]
Now, you have two items to add to each set element: 1*2, giving you {2, 3}; and 2*2, giving you {4, 5}.  
Add these to the original set:
sum_set = {0, 1, 2, 3, 4, 5}
Final coin:

current_coin  = 3;  #  coin[0]
current_quant = 2;  # quant[0]
You add 1*3 and 2*3 to each set element, giving you {3, 4, 5, 6, 7, 8} and {6, 7, 8, 9, 10, 11}.  
Adding these to the sum_set gives you the set of integers 0 through 11.
Remove 0 from the set (since we're not interested in that sum) and take the size of the remaining set. 11 is your answer.
*/

Set<Integer> add_item_to_set(int item_to_add,Set<Integer> set){
	Set<Integer> temp = new HashSet<Integer>();
	Iterator<Integer> it = set.iterator();
	while(it.hasNext()){
                Integer t =it.next();
                temp.add(t+item_to_add);
	}
	return temp;
}

int possibleSums(int[] coins, int[] quantity) {
	Set<Integer> set = new HashSet<Integer>();
	set.add(0);
	int item_to_add=0;
	for(int i=0;i<coins.length;i++){
		Set<Integer> set_per_coin = new HashSet<Integer>();
		for(int j=1;j<=quantity[i];j++){
			item_to_add = j*coins[i];
			set_per_coin.addAll(add_item_to_set(item_to_add,set));
		}
		set.addAll(set_per_coin);
	}
	return set.size()-1;
}






