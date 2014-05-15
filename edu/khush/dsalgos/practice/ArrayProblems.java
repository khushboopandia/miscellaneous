package edu.khush.dsalgos.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class ArrayProblems {
	
	
	public static void main(String[] args)
	{
		int arr[] = {1, 5, 3, 4,4, 2};
		int k = 3;
		//countPairsWithDiffK(arr, k);
		System.out.println(getMaxRepeatingNum(new int[]{2, 3, 3, 5, 3, 4, 1, 7},8,8));
	}
	
	
	public static void countPairsWithDiffK(int[] arr, int k)
	{
		int smallDiff=0;
		int largerDiff=0;
		
		HashSet<Integer> diffSet=new HashSet<Integer>();
		int count=0;
		
			for (int i=0;i<arr.length;i++)
			{
				
				smallDiff=arr[i]-k;
				largerDiff=arr[i]+k;
				if(!diffSet.contains(arr[i])){
					
					if(diffSet.contains(smallDiff))
						{
							count++;
						}
					if(diffSet.contains(largerDiff))
						{
							count++;
						}
				
					diffSet.add(arr[i]);
				}
						
			}
			
			System.out.println(count);
			
	}	
	
	
	public static int getMaxRepeatingNum(int[] a,int n , int k)
	{
		
		for (int i=0;i<a.length;i++)
		{
			int itu=a[i]%k;
			a[itu]=a[itu]+k;
		}
		
		int max=a[0];
		int maxIndex=0;
		
		for (int i=0;i<a.length;i++)
		{
			if(a[i]>max)
			{
				max=a[i];
				maxIndex=i;
			}
		}

		return maxIndex;
		
	}
	
	
	
	

}
