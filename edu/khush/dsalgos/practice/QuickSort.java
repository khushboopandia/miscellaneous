package edu.khush.dsalgos.practice;

public class QuickSort {
	
	private  static int[] a={5,4,3,2,1};
	
	public static void main(String[] args){
		
		recQS(0,a.length-1);
		for(int i:a)
			System.out.println(i);
		
	}
	
	
	public static void recQS(int start,int end)
	{

		if(start>=end)
			return;
		else
		{

		int pivot=a[end];
		int partition=partition(start,end,pivot);
		System.out.println("Pivot pos is:" +partition);

		recQS(start,partition-1);
		recQS(partition+1,end);
		}
		
	}
	
	
	public static int partition(int start,int end,int pivot)
	{
		System.out.println(start);

		int lowPtr=start-1;
		int highPtr=end;
		
		while(true)
		{
			
			while(a[++lowPtr]<pivot)
				;
			
			while(highPtr>0 && a[--highPtr]>pivot)
				;
			
			if(lowPtr>=highPtr)
				break;
			else
				swap(lowPtr,highPtr);		
			
		}
		
		swap(lowPtr,end);
		return lowPtr;
			
	}
	
	
	
	private static void swap(int leftPtr, int rightPtr) {

		int temp=a[leftPtr];
		a[leftPtr]=a[rightPtr];
		a[rightPtr]=temp;
	}

}
