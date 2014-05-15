package edu.khush.dsalgos.practice;

public class Search {
	
	
	public int findFirstOccurence(int[] a,int key)
	{
		int l=0;
		int u=a.length-1;
		int res=-1;
		while(l<=u)
		{

			int mid=l+(u-l)/2;
			
			if(a[mid]>key)
				l=mid-1;
			else if (a[mid]<key)
				u=mid+1;
			else
			{
				res=mid;
				u=mid-1;
			}
		
		}
		
		
		
		return l;
	}

}
