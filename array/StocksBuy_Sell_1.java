package array;

public class StocksBuy_Sell_1 
{

	/**
	 * Given prices of stock on different days. Find maximum profit one can make if stock can be
	 * bought and sold once
	 */
	
	
	static int maxProfit(int prices[])
	{
		int min = prices[0] , max_profit = 0 ;

	    // for each day, check if profit is maximum if stock was bought on some previous day 
		//having minimum price till now
	    // if this profit is more, update max_profit
		
		for (int i = 1 ; i < prices.length ; i++)
		{
			if (prices[i] - min > max_profit) max_profit = prices[i] - min ;
			
	        // if we get lower price we update the min_till_now so that for next days,
			//we can check profit from this
			
			if (min > prices[i]) min = prices[i] ;
		}
		return max_profit ;
	}
	
	public static void main(String[] args) 
	{
		int prices[] = {10, 5, 20, 30, 7, 25, 10, 35} ;
		System.out.println(maxProfit(prices));
	}
}
