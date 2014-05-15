package edu.khush.dsalgos.practice;

public class HeapSort {

	int size = 0;
	int[] a = new int[4];

	public static void main(String[] args) {

		
		//subArrayWithSum(new int[]{1, 4},0);
		sortKSortedArray(new int[] { 2, 6, 3, 12, 56, 8 }, 3);
		System.exit(0);
		HeapSort hs = new HeapSort();
		hs.insert(5);
		hs.insert(4);
		hs.insert(3);
		hs.insert(2);
		hs.insert(1);

		System.out.println(hs.remove());
		System.out.println(hs.remove());
		System.out.println(hs.remove());
		System.out.println(hs.remove());
		System.out.println(hs.remove());

	}

	public boolean insert(int data) {
		if (size == a.length)
			return false;
		else {

			a[size] = data;
			trickleUp(size);
			size++;
			return true;

		}

	}

	public int remove() {

		if (size != 0) {
			int result = a[0];
			a[0] = a[size - 1];
			size--;
			trickleDown(0);
			return result;
		}
		return -1;

	}

	public void trickleUp(int index) {
		int parentIndex = (index - 1) / 2;

		if (parentIndex < 0)
			return;

		if (a[parentIndex] > a[index]) {
			swap(parentIndex, index);
			trickleUp(parentIndex);
		}

	}

	public void trickleDown(int index) {
		int leftChildIndex = 2 * index + 1;
		int rightChildIndex = 2 * index + 2;
		int smallest = index;

		if (leftChildIndex < size && a[leftChildIndex] < a[index]) {
			smallest = leftChildIndex;

		}

		if (rightChildIndex < size && a[rightChildIndex] < a[smallest]) {
			smallest = rightChildIndex;

		}

		if (smallest != index) {
			swap(smallest, index);
			trickleDown(smallest);
		}

	}

	private void swap(int leftPtr, int rightPtr) {

		int temp = a[leftPtr];
		a[leftPtr] = a[rightPtr];
		a[rightPtr] = temp;
	}

	public int peek() {
		return a[0];
	}

	public static void sortKSortedArray(int a[], int k) {

		HeapSort hs = new HeapSort();
		int[] out = new int[a.length];

		int i = 0;

		for (; i <= k; i++) {
			hs.insert(a[i]);
		}

		int ti = 0;

		while (i < a.length || hs.size != 0) {
			if (i < a.length) {

				int x = hs.remove();
				System.out.println(x);
				out[ti] = x;
				hs.insert(a[i]);
				i++;
				ti++;

			} else {

				int x = hs.remove();
				System.out.println(x);
				out[ti] = x;
				ti++;

			}
		}

		for (int l = 0; l < out.length; l++)
			System.out.print(out[l] + ",");
	}
	
	
	
	public static void subArrayWithSum(int[] a,int sum)
	{
		
		int startIdx=0;
		int runningSum=-1;
		
		for(int i=0;i<a.length;i++)
		{
			if(a[i]+runningSum<sum)
			{
				runningSum+=a[i];
			}
			
			else if(a[i]+runningSum>sum)
			{
				while(a[i]+runningSum>sum && startIdx<i-1)
				{
					runningSum=runningSum-a[startIdx];
					startIdx++;
					
					if(a[i]+runningSum==sum)
					{
						System.out.println("Starts at: "+startIdx);
						System.out.println("Ends at: "+i);
						break;
					}
										
				}
				
			}
			else
			{
				System.out.println("Starts at: "+startIdx);
				System.out.println("Ends at: "+i);
			}
			
		}
		
		
		
	}
	
	
	public int minJumps(int a[])
	{
		
		int n=a.length;
		int jumps[]=new int[n];
		
		jumps[n-1]=0;
		int i,j;
		
		for (i=n-2;i>=0;i--)
		{
		
			if(a[i]==0)
				jumps[i]=Integer.MAX_VALUE;
			
			else if (a[i]>=n-i-1)
				jumps[i]=1;
			
			else
			{
				int min=Integer.MAX_VALUE;	
				
				for (j=i+1;j<n && j<=a[i]+i;j++)
				{
					if(min>jumps[j])
						min=jumps[j];
				}
				
				
				if (min != Integer.MAX_VALUE)
		              jumps[i] = min + 1;
		            else
		              jumps[i] = min; // or INT_MAX
			}
			
			
			
			
			
		}
		
		
		return jumps[0];
	}

}
