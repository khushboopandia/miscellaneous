package edu.khush.dsalgos.practice;

public class MinJumps {
	
	public static void main(String[] args)
	{
		int a[]={1,3,5,8,9,2,6,7,6,8,9};
		MinJumps mj=new MinJumps();
		int minjumps=mj.getMinJumps(a);
		System.out.println(minjumps);
		
		
	}

	private int getMinJumps(int[] a) {
		
		
		int[] jumps=new int[a.length];
		jumps[0]=0;
		int indexDiff=0;
		for (int i=1;i<a.length;i++)
		{
			int minJumps=Integer.MAX_VALUE;
			System.out.println("For value: "+a[i]);

			for (int j=0;j<i;j++)
			{
				indexDiff=i-j;
				if(a[j]>=indexDiff)
				{
					System.out.println((jumps[j]+1)+","+minJumps);
					minJumps=Math.min(jumps[j]+1,minJumps);
					
				}
			}
			
			jumps[i]=minJumps;
			System.out.println("********");
		}
		
		
		
		return jumps[a.length-1];
	}

}
