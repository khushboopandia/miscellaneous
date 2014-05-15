package edu.khush.dsalgos.practice;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;

public class MaximumSubArray {
	
	
	public static void main(String[] args){
		
		int a[]={13,-3,-25,20, -3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		getMaxSubArray(a);	
		
	}
	
	//O(n)
	public static int[] getMaxSubArray(int[] a){
		
		int maxValue=0;
		int maxStartIndex=0;
		int maxEndIndex=-1;
		int startIndex=0;
		int maxSumSoFar=0;
		
		
		for(int i=0;i<a.length;i++){
			
			if(maxSumSoFar+a[i]>0){
				maxSumSoFar=maxSumSoFar+a[i];
				
			}
			else{
				
				startIndex=i+1;
				maxSumSoFar=0;
				
			}
			
			if(maxSumSoFar>maxValue){				
				maxValue=maxSumSoFar;
				maxStartIndex=startIndex;
				maxEndIndex=i;
			}
			
		}
		
		System.out.println("Max start index: "+maxStartIndex);
		System.out.println("Max End Index: "+maxEndIndex);
		 if(maxStartIndex <= maxEndIndex) {
		      return Arrays.copyOfRange(a, maxStartIndex, maxEndIndex+1);
		   }
		
		return null;
	}
	
	
	public String formBiggestNumber(int[] a,int k)
	{
		int[] aux=new int[a.length];
		for (int i=0;i<a.length;i++)
		{
			String temp=Integer.toString(a[i]);
			if(temp.length()==k)
				continue;
			else
			{
				int diff=k-temp.length();
				Character c=temp.charAt(temp.length()-1);
				while(diff--!=0)
					temp=temp.concat(c.toString());
			}
			
			aux[i]=Integer.parseInt(temp);
		}
		
		//Do remaining stuff using a heap node class or something
		
		return null;
	}
	
	

}
