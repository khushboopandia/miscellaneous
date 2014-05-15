package edu.khush.dsalgos.practice;

public class CoinCollecting {
	
	
	public static void main(String[] args)
	{
		
		int[][] coinMatrix={{1,1,1,1,1,1},
							{0,0,0,0,0,0},
							{0,0,0,0,0,0},
							{0,0,0,0,0,0},
							{1,0,0,0,0,0}};
		int n=5;
		int m=6;
		
		CoinCollecting coinColl=new CoinCollecting();
		System.out.println(coinColl.maxCoinsCollected(coinMatrix, n-1, m-1));
		
	}
	
	public int maxCoinsCollected(int[][] coinMat,int n,int m)
	{
		int countUp=0;
		
		if (n!=0)
			countUp=coinMat[n][m]+maxCoinsCollected(coinMat,n-1,m);
		else
			countUp=coinMat[n][m];
				
				
		int countLeft=0;
		
		if (m!=0)
			countLeft=coinMat[n][m]+maxCoinsCollected(coinMat,n,m-1);
		else
			countLeft=coinMat[n][m];
		
		return Math.max(countUp, countLeft);
			
	}

}
