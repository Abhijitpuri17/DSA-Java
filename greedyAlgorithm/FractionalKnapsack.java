package greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack 
{
	
/**
 * Given two arrays profits and weights. Profits[i] denotes profit of ith item and weight[i]
 * denotes quantity of that item. Also a container of certain capacity is given. Fill the container
 * with no of items = capacity such that profit is maximum
 */
	
	
	public static void main(String[] args) 
	{
		
		int profits[] = {10, 5, 15, 7, 6, 18, 3} ;
		int weights[] = {2, 3, 5, 7, 1, 4, 1} ;
		Pair[] Items = new Pair[profits.length] ;
		for (int i = 0 ; i < profits.length ; i++)
			Items[i] = new Pair(profits[i], weights[i]);
		
		Compare.compare(Items, Items.length);
		
		for (int i = 0 ; i < profits.length ; i++)
		  System.out.println(Items[i].profit + " "+ Items[i].weight);
		
		
		System.out.println(getMaxProfit(Items, 15));
		
	}
	
	
	static float getMaxProfit(Pair[] items, int capacity)
	{
		int i = 0 ;
		float ans  = 0 ;
		while (capacity > 0 && i < items.length)
		{
			if (items[i].weight < capacity) 
			{ 
				ans += items[i].profit;
			    capacity -= items[i++].weight;
			}
			else 
			{
				ans += ((float)items[i].profit/items[i].weight)*capacity ;
				capacity  = 0 ;
			}
		}

		return ans ;
	}
	
	
	
	static class Pair
	{
		int profit , weight ;
		public Pair(int profit, int weight) 
		{
			this.profit = profit;
			this.weight = weight;
		}
	}
	
	static class Compare 
	{
	    static void compare(Pair arr[], int n)
	    {
	        // Comparator to sort the pair according to second element
	        Arrays.sort(arr, new Comparator<Pair>() {
	            @Override public int compare(Pair p1, Pair p2)
	            {
	                return (int)((double)p2.profit/p2.weight - (double)p1.profit/p1.weight);
	            }
	        });
	    }
	}
	
	
	
	

}
