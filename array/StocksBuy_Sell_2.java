package array;

public class StocksBuy_Sell_2 
{
	/**
	 * Given prices of stock on different days. Find maximum profit one can make if stock can be
	 * bought and sold multiple times but at a time you can have only one stock i.e. 
	 * after buy order there should be sell order not buy order again
	 */
	
	
	static int maxProfit(int[] prices)
	{
		int profit = 0 ;
		
		// we buy at each local minima and sell at the local maxima to get max Profit
		for (int i = 0 ; i < prices.length-1 ; i++)
		{
			if (prices[i+1] > prices[i]) profit += prices[i+1] - prices[i] ;
		}
		return profit ;
	}
	
	
	public static void main(String[] args) 
	{
		int prices[] = {10, 5, 20, 30, 7, 25, 10, 35} ;
		System.out.println(maxProfit(prices));
	}

}
