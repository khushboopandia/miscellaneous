package edu.khush.dsalgos.practice;

import java.util.ArrayList;

public class CoinRow {
	
	
	public static void main(String[] args)
	{
		
		int coins[]={5,1,2,10,6,2};
		CoinRow cr=new CoinRow();
		System.out.println(cr.returnMaxCoinValue(coins,coins.length-1));
		
		
		
		
	}

	
	public  int returnMaxCoinValue( int[] coins,int n)
	{
		if (n==0)
			return 0;
		else if (n==1)
			return coins[0];
		else 
		{
			return Math.max(coins[n]+returnMaxCoinValue(coins,n-2), returnMaxCoinValue(coins,n-1)) ;
		}
	}
	
	
}




