package edu.khush.dsalgos.practice;

public class InsertionSort {
	
	
	public static void main(String[] args)
	{
		int a[] ={7,5,8,1};
		
		
		for (int o=1;o<a.length;o++)
		{
			
			int temp=a[o];
			int i=o-1;
			
			while (i>=0 && a[i]>temp )
			{
				a[i+1]=a[i];
				i--;
			}
			
			a[i+1]=temp;
			
			
		}
		
		for(int i:a)
			System.out.println(i);
		
		
	}

}
