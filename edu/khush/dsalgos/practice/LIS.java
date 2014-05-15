package edu.khush.dsalgos.practice;

public class LIS {
	
	public static void main(String[] args)
	{
		LIS lis=new LIS();
		
		
		//int a[]={56,60,65,68,70,75};
		int b[]={90,95,100,110,150,190};
		
		
		
		int a[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		 //int a[]={3 ,4 , 5 ,10};
		System.out.println(lis.getLongestIncSubseq2(a));
		//System.out.println(lis.maxLenChain1(a,b));
		
		
		
	}
	



	private int getCeilIndex(int[] tailTable, int key,int len) {

		int l=0;
		int r=len-1;
		int mid=0;
		
		while(r-l>1)
		{
			mid=l+(r-l)/2;
			
			if(tailTable[mid]>=key)
				r=mid;
			else
				l=mid;
			
		}
		
		
		return r;
	}
	
	public int lis( int arr[], int n )
	{
	   int[] lis=new int[n];
	 
	   /* Initialize LIS values for all indexes */
	   for (int i = 0; i < n; i++ )
	      lis[i] = 1;
	    
	   /* Compute optimized LIS values in bottom up manner */
	   for (int i = 1; i < n; i++ )
	   {
	      for (int j = 0; j < i; j++ )
	      {
	    	  System.out.println(arr[i]+","+arr[j]);
	    	  System.out.println(lis[i]+","+(lis[j]+1));
	         if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
	            lis[i] = lis[j] + 1;
	      }
	      
	      System.out.println("-------");
	   }
	    
	   int max=Integer.MIN_VALUE;
	   /* Pick maximum of all LIS values */
	   for (int i = 0; i < n; i++ )
	      if ( max < lis[i] )
	         max = lis[i];
	 
	 
	 
	   return max;
	}
	
	public int maxSumSubSeq(int[] a)
	{
		int[] sum=new int[a.length];
		sum[0]=a[0];
		
		for (int i=1;i<a.length;i++)
		{
			int maxsum=Integer.MIN_VALUE;
			for (int j=0;j<i;j++)
			{
				if(a[i]>a[j] && maxsum<sum[j]+a[i])
					maxsum=sum[j]+a[i];
			}
			sum[i]=maxsum;
		}
		
		
		 int max=Integer.MIN_VALUE;
		   /* Pick maximum of all LIS values */
		   for (int i = 0; i < a.length; i++ )
		      if ( max < sum[i] )
		         max = sum[i];
		 
		 
		 
		   return max;	
		   
	}
	
	public int maxLenChain(int[] a,int b[])
	{
		int[] lis=new int[a.length];
		lis[0]=1;
		
		for (int i=1;i<a.length;i++)
		{
			int maxsum=Integer.MIN_VALUE;
			for (int j=0;j<i;j++)
			{
				if(a[i]>b[j] && lis[i]<lis[j]+1)
					lis[i]=lis[j]+1;
			}
		}
		
		
		 int max=Integer.MIN_VALUE;
		   /* Pick maximum of all LIS values */
		   for (int i = 0; i < a.length; i++ )
		      if ( max < lis[i] )
		         max = lis[i];
		 
		 
		 
		   return max;	
		   
	}
	
	public int maxLenChain1(int[] a,int b[])
	{
		int[] lis=new int[a.length];
		lis[0]=1;
		
		for (int i=1;i<a.length;i++)
		{
			for (int j=0;j<i;j++)
			{
				System.out.println(i+","+j);
				if(b[i]>b[j] && lis[i]<lis[j]+1)
					lis[i]=lis[j]+1;
			}
		}
		
		
		 int max=Integer.MIN_VALUE;
		   /* Pick maximum of all LIS values */
		   for (int i = 0; i < a.length; i++ )
		      if ( max < lis[i] )
		         max = lis[i];
		 
		 
		 
		   return max;	
		   
	}
	
	public int getLongestIncSubseq1(int a[])
	{
		int[] tailTable=new int[a.length];
		int len=1;
		
		for (int i=0;i<a.length;i++)
		{
			if(a[i]<tailTable[0])
				tailTable[0]=a[i];
			else if (tailTable[len-1]<a[i])
				tailTable[len++]=a[i];
			else 
				tailTable[getCeilIndex(tailTable, a[i], len)]=a[i];
		}
		
		return len;
		
	}

	
	public int getLongestIncSubseq(int a[])
	{
		
		int[] tailTable=new int[a.length];
		int len=1;
		
		for(int i=0;i<a.length;i++)
		{
			if(a[i]<tailTable[0])
				tailTable[0]=a[i];
			else if(a[i]>tailTable[len-1])
				tailTable[len++]=a[i];
			else
				tailTable[getCeilIndex(tailTable,a[i],len)]=a[i];			
		}	
		
		return len;
	}
	
	public int getLongestIncSubseq2(int a[])
	{
		
		int[] lis=new int[a.length];
		
		lis[0]=1;
		
		for(int i=1;i<a.length;i++)
		{
			for (int j=0;j<i;j++)
			{			
				
				if(a[i]>a[j] && lis[i]<lis[j]+1)
					lis[i]=lis[j]+1;
			}
		}
		
		
		 int max=Integer.MIN_VALUE;
		   /* Pick maximum of all LIS values */
		   for (int i = 0; i < a.length; i++ )
		      if ( max < lis[i] )
		         max = lis[i];
		 
		return max;
	}

	
	
}
