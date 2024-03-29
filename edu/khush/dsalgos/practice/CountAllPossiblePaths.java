package edu.khush.dsalgos.practice;

public class CountAllPossiblePaths {
	
	public static void main(String[] args)
	{
		int m=3;
		int n=3;
		CountAllPossiblePaths cntPaths=new CountAllPossiblePaths();
		System.out.println(cntPaths.getMaxPossPaths(m, n));
	}

	
	public int getMaxPossPaths(int m,int n)
	{
		
		int[][] paths=new int[m][n];
		
		for (int i=0;i<m;i++)
			paths[i][0]=1;
		
		for (int i=0;i<n;i++)
			paths[0][i]=1;
		
		for (int i=1;i<m;i++)
			for (int j=1;j<n;j++)
			{
				paths[i][j]=paths[i-1][j]+paths[i][j-1];
			}
		
		return paths[m-1][n-1];
	}
}
