package greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing 
{
	static class Job
	{
		char jobId ;
		int profit ;
		int deadline ;
		
		public Job(char jobId, int profit, int deadline) 
		{
			this.jobId = jobId ;
			this.profit= profit;
			this.deadline = deadline;
		}
	}
	
	static void sort_jobs(Job[] jobs, int n)
	{
		Arrays.sort(jobs, new Comparator<Job>() 
		{
			public int compare(Job j1, Job j2) 
			{
				if (j1.profit > j2.profit) return -1;
				else if (j1.profit == j2.profit && j1.deadline < j2.deadline) return -1 ;
				return 1 ;
			}
		});
	}
	
	
	static int getMaxProfit(Job[] jobs)
	{
		int max_deadline = 0 , profit = 0;
		for (int i = 0 ; i < jobs.length ; i++)
			max_deadline = Math.max(max_deadline, jobs[i].deadline);
		
		boolean is_slot_occupied[] = new boolean[max_deadline] ;
		int i = 0 ;
		while (i < jobs.length)
		{
			int deadline = jobs[i].deadline - 1 ;
			while ( deadline >= 0 && is_slot_occupied[deadline] ) deadline-- ;
			
			if (deadline >= 0) {
				profit += jobs[i].profit;
				is_slot_occupied[deadline] = true ;
			}
			i++ ;
		}
		return profit ;
	}
	

	public static void main(String[] args)
	{
		char jobId[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g'} ;
		int profit[] = {25, 20, 35, 30, 15, 12, 5} ;
		int deadline[] = {4, 2, 3, 4, 3, 1, 2} ;
	
		Job jobs[] = new Job[jobId.length] ;
		for (int i = 0 ; i < jobId.length ; i++)
			jobs[i] = new Job(jobId[i], profit[i], deadline[i]) ;
		
		sort_jobs(jobs, jobs.length);
		System.out.println(getMaxProfit(jobs));
		
		
	}

}
