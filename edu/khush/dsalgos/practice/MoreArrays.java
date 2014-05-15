package edu.khush.dsalgos.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MoreArrays {

	static int[] a = {1, 12, 15, 26, 38};
	static int[] b = {2, 13, 17, 30, 45};

	public static void main(String[] args) {

		//int[] a={12, 4, 78, 35, 45, 25};
		//maxLengthBitonic(a);
		//System.exit(0);
		
		//int[] start = { 1, 2, 3, 6 };
		//int[] end = { 5, 4, 5, 8 };
		
		int[] start={0,1,2,3,5,7,8,9,12,12,13,16};
		int[] end={3,1,4,4,7,8,11,11,14,15,13,17};
		mergeOverlappingIntervals(start, end);
		System.exit(0);
		//System.out.println(getMedian(0, a.length-1, 0, b.length-1));

		// int[] a={-1, 2, -3, 4, 5, 6, -7, 8, 9};
		// rearrangePosNeg(a);

		// int a[]={10, 20, 15, 2, 23, 90, 67};
		// int peak=findPeak(a, 0, a.length-1);

		// int[] a={3,2,0,1};
		// rearrange(a);

		// int result=countGrps(a);
		// System.out.println(result);
	}

	public static int countGrps(int[] a) {

		int count = 0;
		HashMap<Integer, Integer> remMap = new HashMap<Integer, Integer>();
		int rem = 0;

		for (int i : a) {
			rem = i % 3;
			if (remMap.containsKey(rem))
				remMap.put(rem, remMap.get(rem) + 1);
			else
				remMap.put(rem, 1);
		}

		// Count grps of size 2
		if (remMap.get(0) != null)
			count += (remMap.get(0) * (remMap.get(0) - 1)) >> 1;

		// Count of grps of size 2 with one element with 1
		// remainder and other with 2 remainder
		if (remMap.get(1) != null && remMap.get(2) != null)
			count += remMap.get(1) * (remMap.get(2));

		// Count of grps of size 3 with all 0 remainder elements
		if (remMap.get(0) != null)
			count += (remMap.get(0) * (remMap.get(0) - 1) * (remMap.get(0) - 2)) / 6;

		// Count of grps of size 3 with all 1 remiander elements
		if (remMap.get(1) != null)
			count += (remMap.get(1) * (remMap.get(1) - 1) * (remMap.get(1) - 2)) / 6;

		// Count of grps of size 3 with all 2 remiander elements
		if (remMap.get(2) != null)
			count += (remMap.get(2) * (remMap.get(2) - 1) * (remMap.get(2) - 2)) / 6;

		// Count of grps of size 3 with different remainders
		if (remMap.get(0) != null && remMap.get(1) != null
				&& remMap.get(2) != null)
			count += remMap.get(0) * (remMap.get(1)) * (remMap.get(2));

		return count;
	}

	public static void rearrange(int[] a)

	{
		int n = a.length;
		for (int i = 0; i < n; i++) {
			a[i] += (a[a[i]] % n) * n;
		}

		for (int i = 0; i < n; i++) {
			a[i] /= n;
		}

	}

	public static int findPeak(int[] a, int lowPtr, int highPtr) {

		int mid = lowPtr + (highPtr - lowPtr) / 2;

		if ((mid == 0 || a[mid] >= a[mid - 1])
				&& (mid == a.length - 1 || a[mid] >= a[mid + 1]))
			return mid;

		else if (mid > 0 && a[mid - 1] > a[mid])
			return findPeak(a, lowPtr, mid - 1);

		else
			return findPeak(a, mid + 1, highPtr);

	}

	public static void rearrangePosNeg(int[] a) {

		int pivot = 0;
		int i = -1;
		int highPtr = a.length;

		for (int j = 0; j < highPtr; j++) {
			if (a[j] < 0) {
				i++;
				swap(a, i, j);
			}
		}

		int pos = i + 1;
		int neg = 0;

		while (pos < highPtr && neg < pos && a[neg] < 0) {
			swap(a, neg, pos);
			pos++;
			neg += 2;
		}

		for (int x : a)
			System.out.print(x + ",");

	}

	private static void swap(int[] a, int leftPtr, int rightPtr) {

		int temp = a[leftPtr];
		a[leftPtr] = a[rightPtr];
		a[rightPtr] = temp;
	}

	public static void mergeOverlappingIntervals(int start[], int end[]) {

		int s = 1;
		int e = 0;

		ArrayList<Integer> mergedStart = new ArrayList<Integer>();
		ArrayList<Integer> mergedEnd = new ArrayList<Integer>();
		int j = 0;
		int startIdx = 0;

		while (s < start.length) {

			System.out.println("Comes for: " + s);

			if (start[s] <= end[e]) {
				System.out.println("Inserting..1: " + j + "," + start[startIdx]
						+ "," + end[e + 1]);

				if (mergedStart.size() == j) {
					mergedStart.add(j, start[startIdx]);
					mergedEnd.add(j, end[e + 1]);
				} else {
					mergedStart.set(j, start[startIdx]);
					mergedEnd.set(j, end[e + 1]);
				}
				e++;
				s++;

			}

			else if (start[s] > end[e]) {

				j++;

				startIdx = s;
				System.out.println("Inserting..2: " + j + "," + start[startIdx]
						+ "," + end[e + 1]);
				mergedStart.add(j, start[startIdx]);
				mergedEnd.add(j, end[e + 1]);

				e++;
				s++;

			}

		}

		for (int x : mergedStart)
			System.out.println(x);
		
		System.out.println("***");
		for (int x : mergedEnd)
			System.out.println(x);

	}

	public static int getMedian(int aStart, int aEnd, int bStart, int bEnd) {

				
		if (aEnd - aStart == 1 && bEnd - bStart == 1) {

			return (Math.max(a[aStart], b[bStart]) + Math.min(a[aEnd], b[bEnd])) / 2;
		}

		else {
			
			int mid1 = aStart + (aEnd - aStart) / 2;
			int mid2 = bStart + (bEnd - bStart) / 2;

			
			
			if (a[mid1] > b[mid2]) {

				return getMedian(aStart, mid1, mid2, bEnd);

			} else if (a[mid1] < b[mid2]) {

				return getMedian(mid1, aEnd, bStart, mid2);

			} else {

				return a[mid1];
			}
		}

	}
	
	
	
	
	public static int sortedSubSeqOfSizeN(int[] a,int[] a_passNMinus1,int k)
	{
		
		if(k==4)
		{
			for(int i=0;i<a.length;i++){
				if(a_passNMinus1[i]!=-1)
				{
					System.out.println(i);
					return a_passNMinus1[i];
				}
			
			}
			
			return -1;
		}
			
		else{
		int min=-1;
		int[] a_passN=new int[a.length];
		
		for (int i=0;i<a.length;i++)
		{
			
			if(min!=-1 && a[i]>a[min])
			{
				a_passN[i]=min;
			}
			else
				a_passN[i]=-1;
			
			if (a_passNMinus1[i]!=-1 && (min==-1 || a[i]<a[min]))
				min=i;		
			
		}
		
		k=k+1;
		int x=sortedSubSeqOfSizeN(a, a_passN, k);
		System.out.println(x);

		if (x==-1)
			return -1;
		return a_passNMinus1[x];	
		}
	}
	
	public static void largestSubArrayWithEqual01(int[] a)
	{
		
		
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==0)
				a[i]=-1;
		}
		
		int sum[]=new int[a.length];
		int sumSoFar=0;
		
		for(int i=0;i<a.length;i++)
		{
			sumSoFar+=a[i];
			sum[i]=sumSoFar;
		}
		
		//Case a: Sub Array index starting at 0
		int maxIndex0=-1;
		for(int i=1;i<sum.length;i++)
		{
			if(sum[i]==0)
				maxIndex0=i;
		}
		
		//Case b: Sub Array Index not starting at 0
		HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
		int maxIndexNot0=-1;
		int diff=0;
		
		for(int i=0;i<sum.length;i++)
		{
			if(map.containsKey(sum[i]))
			{
				diff=i-map.get(sum[i]);
				if(diff>maxIndexNot0)
					maxIndexNot0=diff;
			}
			else
				map.put(sum[i], i);
		}
		
		System.out.println(maxIndex0);
		System.out.println(maxIndexNot0);

		
		System.out.println(Math.max(maxIndex0, maxIndexNot0));
	}
	
	
	//6,7,8,0,1,2,3,4,5
	//6,7,8,9,10,11,1,2,3
	
	public static void findMaxInRotatedArray(int[] a)
	{
		int lPtr=0;
		int hPtr=a.length-1;
		
		while (hPtr-lPtr>1)
		{
			
			int mid=lPtr+(hPtr-lPtr)/2;
			System.out.println(mid);
			if(a[mid]<a[hPtr])
			{
				hPtr=mid;				
			}
			else
			{
				lPtr=mid;
			}
		}
		
		if(hPtr-lPtr==1)
			System.out.println(Math.max(a[lPtr], a[hPtr]));
		else if(lPtr==hPtr)
			System.out.println(a[lPtr]);
		else 
			System.out.println("No max??");
	}
	
	
	public static void maxLengthBitonic(int[] a)
	{
		
		int maxLengthSoFar=-1;
		int startIndex=0;
		int endIndex=a.length-1;
		boolean increase=true;
		int i=1;
		
		for(;i<a.length;i++)
		{
			System.out.println("Start index: "+startIndex+","+i);
			if(increase && a[i]>a[i-1])
			{
				continue;
				
			}
			else if(increase && a[i]<a[i-1])
			{
				System.out.println("Comes here");
				increase=false;
				continue;
			}
			else if(!increase && a[i]>a[i-1])
			{
				endIndex=i-1;
				maxLengthSoFar=Math.max(maxLengthSoFar, endIndex-startIndex+1);
				System.out.println("End index: "+endIndex);
				startIndex=i-1;
				i--;

				increase=true;
			}
			
			
		}
		
		endIndex=i-1;
		System.out.println(Math.max(maxLengthSoFar, endIndex-startIndex+1));

		
	}
	
	
	public void maxProductSubArray1(int[] a)
	{
		int maxSoFar=1;
		int maxEndingHere=1;
		int minEndingHere=1;

		int start=0;
		int end=-1;
		int start1=-1;
		
		for (int i=0;i<a.length;i++)
		{
			if(a[i]>0)
			{
				start1=start;
				start=i+1;
				minEndingHere*=a[i];
				maxEndingHere*=a[i];
				
			}
			else if(a[i]<0)
			{
				minEndingHere*=a[i];
				if(!(minEndingHere<maxEndingHere))
					maxEndingHere*=minEndingHere;
			}
			else if(a[i]==0)
			{
				maxEndingHere=1;
				minEndingHere=1;
			}
			
			if (maxSoFar<maxEndingHere)
				maxSoFar=maxEndingHere;
			
		}
		
		
	}
	
	public static void maxProductSubArray(int[] a)
	{
		
		int max_ending_here=1;
		int min_ending_here=1;
		int max_so_far=Integer.MIN_VALUE;
		
		for (int i=0;i<a.length;i++)
		{
			if(a[i]>0)
			{
				max_ending_here*=a[i];
				min_ending_here*=a[i];
			}
			
			if(a[i]<0)
			{
				min_ending_here*=a[i];
				if(!(min_ending_here<max_ending_here))
					max_ending_here=min_ending_here;				
					
			}
			
			if(a[i]==0)
			{
				max_ending_here=1;
				min_ending_here=1;
			}
			
			if (max_so_far <  max_ending_here)
		          max_so_far  =  max_ending_here;
			
			
		}
		
		
		System.out.println(max_so_far);		
	}
	
	
	

}
