package edu.khush.dsalgos.practice;

public class MergeSort {

	private int[] a = {7,5,8,3};
	
	
	public static void main(String[] args)
	{
		MergeSort ms=new MergeSort();
		ms.recMergeSort(new int[ms.a.length], 0, ms.a.length-1);
		
		for (int i=0;i<ms.a.length;i++)
			System.out.println(ms.a[i]);
	}

	public void recMergeSort(int temp[], int start, int end) {

		if (start == end)
			return;

		int mid = (start + end) / 2;
		recMergeSort(temp, start, mid);
		recMergeSort(temp, mid+1, end);
		merge(temp, start, mid, end);

	}

	public void merge(int temp[], int start, int mid, int end) {

		int lowPtr = start;
		int highPtr = mid+1;

		int k = 0;
		while (lowPtr <= mid && highPtr <= end) {

			if (a[lowPtr] < a[highPtr])

				temp[k++] = a[lowPtr++];

			else
				temp[k++] = a[highPtr++];

		}
		
		
		while (lowPtr <= mid)
			temp[k++] = a[lowPtr++];

		while(highPtr <= end)
			temp[k++] = a[highPtr++];

		for (int i=0;i<k;i++)
			a[start+i]=temp[i];

	}

}
