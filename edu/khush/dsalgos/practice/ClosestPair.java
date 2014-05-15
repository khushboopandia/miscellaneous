package edu.khush.dsalgos.practice;

import java.util.ArrayList;

public class ClosestPair {
	
	
	public static void main(String[] args)
	{
		double[] P={1,2,3,4,5,6};
		double[] Q={1,1,13,14,15,16};
		ClosestPair cp=new ClosestPair();
		System.out.println(cp.closestPair(P, Q));
	}
	
	public double closestPair(double[] P, double[] Q)
	{
		
		if(P.length<=3)
		{
			return bruteForceClosestPair(P, Q);
		}
		
		else 
		{
			int mid=-1;
			if(P.length%2==0)
				mid=P.length/2;
			else 
				mid=P.length/2+1;
			
			double[] Pl=new double[mid];
			System.arraycopy(P, 0, Pl, 0, mid);
			double[] Pr=new double[P.length-mid];
			System.arraycopy(P, mid, Pr, 0, (P.length-mid));

			
			double[] Ql=new double[mid];			
			System.arraycopy(Q, 0, Ql, 0, mid);
			double[] Qr=new double[P.length-mid];			
			System.arraycopy(Q, mid, Qr, 0, (P.length-mid));
			
			
			
			double distLeft=closestPair(Pl, Ql);
			double distRight=closestPair(Pr,Qr);
			
			double distmin=Math.min(distLeft, distRight);
			double disminsq=Math.pow(distmin, 2);
			
			double m=P[mid-1];
			
			ArrayList<Double> sx=new ArrayList<Double>();
			ArrayList<Double> sy=new ArrayList<Double>();
			
			
			for (int i=0;i<P.length; i++)
				if(Math.abs(P[i]-m)<distmin)
				{
					sx.add(P[i]);
					sy.add(Q[i]);
				}
			
			for (int i=0;i<sx.size();i++)
			{
				int k=i+1;
				while(k<=sx.size()-1 && Math.pow((sy.get(k)-sy.get(i)),2)<disminsq)
				{
					disminsq=Math.min(disminsq, (Math.pow((sy.get(k)-sy.get(i)),2)+Math.pow((sx.get(k)-sx.get(i)),2)));
					k++;
				}
			}
			
			return Math.sqrt(disminsq);
			
		}
		
	}
	
	public double bruteForceClosestPair(double[] P,double[] Q)
	{
		double dismin=Double.MAX_VALUE;
		
		for (int i=0;i<P.length;i++)
		{
			for(int j=i+1;j<P.length;j++)
			{
				dismin=Math.min(dismin, (Math.pow((Q[j]-Q[i]),2)+Math.pow((P[j]-P[i]),2)));
			}
		}
			
		return dismin;
	}
	

}
