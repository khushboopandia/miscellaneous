package edu.khush.dsalgos.practice;

public class ChangeMaking {

	public static void main(String[] args) {

		int[] coinDenominations = { 1, 3, 4 };
		int n = 6;
		ChangeMaking cm=new ChangeMaking();
		System.out.println(cm.makeChange(coinDenominations, n));

	}

	public int makeChange(int[] coinDenom, int n) {

		if (n == 0)
			return 0;
		else {

			int[] result = new int[n + 1];

			for (int j = 1; j <= n; j++) {
				int i = 0;
				int count = 0;
				int minSoFar = Integer.MAX_VALUE;
				while (i < coinDenom.length && coinDenom[i] <= n) {
					count = makeChange(coinDenom, n - coinDenom[i]);
					if (count < minSoFar)
						minSoFar = count;
					i++;
				}
				result[j] = minSoFar + 1;

			}
			return result[n];
		}

	}
	
	public int makeChange1(int[] coinDenom, int n) {
		
		int[] coinCount=new int[n+1];
		
		for (int j=1;j<=n;j++)
		{
			int i=0;
			int count=-1;
			int minSoFar=Integer.MAX_VALUE;
			while(i<coinDenom.length && coinDenom[i]<=j)
			{
				count=coinCount[j-coinDenom[i]]+1;
				if(count<minSoFar)
					minSoFar=count;
				i++;
			}
			
			coinCount[j]=minSoFar;
		}
		
		return coinCount[n];
	}

	

}
