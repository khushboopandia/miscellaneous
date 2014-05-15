package edu.khush.dsalgos.practice;

public class MinHeap {
	
	int size=0;
	MinHeapNode[] a=new MinHeapNode[3];
	
	
	public static void main(String[] args)
	{
		mergeKSortedArrays();
		
	}
	
	
	public boolean insert(MinHeapNode node)
	{
		if(size==a.length)
			return  false;
		else{
			
			a[size]=node;
			trickleUp(size);	
			size++;
			return true;

			
		}
		
		
	}
	
	public MinHeapNode remove()
	{
		MinHeapNode result=a[0];
		a[0]=a[size-1];
		size--;
		trickleDown(0);
		
		return result;
		
	}
	
	
	
	
	public void trickleUp(int index)
	{
		int parentIndex=(index-1)/2;
		
		if(parentIndex<0)
			return;
		
		if(compareNodes(a[parentIndex],a[index]))
		{
			swap(parentIndex,index);
			trickleUp(parentIndex);
		}
		
		
	}
	
	
	
	public void trickleDown(int index)
	{
		int leftChildIndex=2*index+1;
		int rightChildIndex=2*index+2;
		int smallest=index;
		
		if(leftChildIndex<size && !compareNodes(a[leftChildIndex],a[index]))
		{
			smallest=leftChildIndex;
			
		}
			
		if(rightChildIndex<size && !compareNodes(a[rightChildIndex],a[smallest]))
		{
			smallest=rightChildIndex;
			
		}
		
		if(smallest!=index)
		{
			swap(smallest,index);
			trickleDown(smallest);
		}
		
		
		
	}
	
	private  void swap(int leftPtr, int rightPtr) {

		MinHeapNode temp=a[leftPtr];
		a[leftPtr]=a[rightPtr];
		a[rightPtr]=temp;
	}
	
	
	
	public MinHeapNode peek()
	{
		return a[0];
	}
	
	
	public boolean compareNodes(MinHeapNode node1,MinHeapNode node2)
	{
		if (node1.value>node2.value)
			return true;
		else
			return false;
		
	}
	
	
	public static void mergeKSortedArrays()
	{
		
		int k = 3;
		int n =  4;
		int arr[][] = { {1, 3, 5, 7},
		            {2, 4, 6, 8},
		            {0, 9, 10, 11}
		            } ;
		
		
		//Create an output array of size n*k
		int[] output=new int[n*k];
		int ptr=0;
		
		//Create min heap of size k
		MinHeap minHeap=new MinHeap();

		//Insert first element of all arrays into the heap
		for(int i=0;i<k;i++)
		{
			MinHeapNode mhn= new MinHeapNode(arr[i][0], i, 1);
			minHeap.insert(mhn);
		}
		
		
		//For n*k times
		MinHeapNode current=null;
		int nextValue=Integer.MAX_VALUE;
		
		for (int j=0;j<n*k;j++)
		{
			current=minHeap.remove();
			output[ptr]=current.value;
			ptr++;
			
			if(current.nextElementIndex>=n)
			{
				MinHeapNode nextNode=new MinHeapNode(Integer.MAX_VALUE, current.arrIndex, current.nextElementIndex+1);
				minHeap.insert(nextNode);

			}
			else
			{
				MinHeapNode nextNode=new MinHeapNode(arr[current.arrIndex][current.nextElementIndex], current.arrIndex, current.nextElementIndex+1);
				minHeap.insert(nextNode);

			}		
			
		}
		
		for (int i: output)
			System.out.println(i);
	}
	
	

}
