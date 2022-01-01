package dynamic_programming.oneD.boxStacking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BottomUp 
{
	
	/*
	 * Given an array of boxes (length, width, height).
	 * Finding maximum height we can by stacking boxes one on another.
	 * 
	 * Box on top must have all the dimension less than bottom box
	 */
	
	static class Box
	{
		int len, width, height ;
		
		Box(int len, int width, int height) 
		{
			this.len = len ;
			this.width = width ;
			this.height = height ;
		}

		
	}
	
	static class boxComparator implements Comparator<Box>{
		@Override
		public int compare(Box b1, Box b2) {
			if (b1.height < b2.height) return -1 ;
			if (b1.height == b2.height) return 0;
			return 1 ;
		}
		
	}
	
	static int maxHeightBoxStacking(Box[] boxes)
	{
		Arrays.sort(boxes, new boxComparator());
	
		int n = boxes.length;
		int dp[] = new int[n] ;
		dp[0] = boxes[0].height ;
		
		List<Box> boxesDP[] = new ArrayList[n] ;
		
		boxesDP[0] = new ArrayList<>();
		boxesDP[0].add(boxes[0]) ;
		
		int max_height = 0 ;
		List<Box> ans_stack = new ArrayList<>();
		
		for (int i = 1 ; i < n ; i++)
		{
			int curr_ans = 0 ;
			int curr_len = boxes[i].len;
			int curr_width = boxes[i].width;
			int curr_height = boxes[i].height;
			List<Box> curr_boxes_stack = new ArrayList<>();
			
			for (int j = 0 ; j < i ; j++)
					if (boxes[j].len < curr_len 
						&& boxes[j].width < curr_width 
						&& boxes[j].height < curr_height)
					{
					      if (curr_ans < dp[j]) {
					    	  curr_ans = dp[j] ;
					    	  curr_boxes_stack = boxesDP[j] ;
					      }
					}
			
			dp[i] = curr_ans + boxes[i].height ;
			boxesDP[i] = curr_boxes_stack;
			boxesDP[i].add(boxes[i]) ;
		
			if (max_height < dp[i]) {
				max_height = dp[i] ;
				ans_stack = boxesDP[i] ;
			}
			
		}
		
		for (Box box: ans_stack) {
			System.out.println(box.len + " " + box.width + " " + box.height);
		}
		
		return max_height ;
	}
	
	

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in) ;
		System.out.println("START");
		Box[] boxes = new Box[6] ;
		for (int i = 0 ; i < 6 ; i++)
			boxes[i] = new Box(sc.nextInt(), sc.nextInt(), sc.nextInt()) ;
		
	System.out.println(maxHeightBoxStacking(boxes)) ;

	}

}
