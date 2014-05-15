package edu.khush.dsalgos.practice;

public class BinarySearch {
	
	int a[] ={1,2,3,4,5,6,7,8,9};
	
	public static void main(String[] args){
		
		BinarySearch srch=new BinarySearch();
		int res=srch.search(srch.a, 9);
		System.out.println(res);
		
		
	}
	
	public int binarySearch(int a[],int key)
	{
		
		int l=0;
		int h=a.length-1;
		
		while(l<=h)
		{
			int mid=l+(h-l)/2;
			
			if (a[mid]>key)
				h=mid-1;
			
			else if (a[mid]<key)
				l=mid+1;
			else
				return a[mid];
			
		}
		
		return -1;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int search(int a[],int key)
	{
		
		int l=0;
		int u=a.length-1;
		int mid=-1;
		
		while (l<=u)
			
			
		{
			mid=l+(u-l)/2;
			System.out.println(mid);
			
			if (a[mid]>key)
				u=mid-1;
			else if (a[mid]<key)
				l=mid+1;
			else 
				return mid;
		}
		
		
		return -1;
	}

}
