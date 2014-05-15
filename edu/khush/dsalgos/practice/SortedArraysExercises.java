package edu.khush.dsalgos.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SortedArraysExercises {

	public static void main(String[] args) {

		int A[] = { 1, 2, 3 };
		int B[] = { 1, 1, 1 };

		int a[] = { 1, 2, 3, 4, 2, 3, 5, 1, 2, 3 };
		char s[]={'s','s','s','e','e','s','e','s','e','e','s','s','e','s','e','e','e'};
		SortedArraysExercises sae = new SortedArraysExercises();
		
		sae.renderCalendar(s);
		System.exit(0);
		a = sae.countingSort(a);
		for (int i : a)
			System.out.println(i);

		// intersectSortedArrays(A, B);
		// mergeSortedArrays();
		// System.out.println(searchInSortedMatrix(13));

	}

	public static void intersectSortedArrays(int[] A, int[] B) {
		int[] C;
		if (A.length < B.length)
			C = new int[A.length];
		else
			C = new int[A.length];
		int i = 0;
		int j = 0;
		int k = 0;

		// 1 2 3
		// 1 1 2

		while (i < A.length && j < B.length) {
			if (A[i] == B[j] && (j == 0 || B[j] != B[j - 1])) {
				C[k++] = A[i];
				i++;
				j++;
			} else if (A[i] > B[j])
				j++;

			else
				i++;

		}

		for (int num : C)
			System.out.println(num);

	}

	public static void mergeSortedArrays() {
		// int A[]={1,2,3,7,9,-1,-1,-1};
		// int B[]={4,6,8};

		int A[] = { 3, 4, 5, -1, -1 };
		int B[] = { 1, 2 };

		int i = A.length - 1;

		int a = A.length - B.length - 1;
		int b = B.length - 1;

		while (a >= 0 && b >= 0) {
			if (A[a] > B[b]) {
				A[i] = A[a];
				i--;
				a--;
			} else {
				A[i] = B[b];
				i--;
				b--;

			}

		}

		while (a >= 0) {
			A[i] = A[a];
			i--;
			a--;
		}

		while (b >= 0) {
			A[i] = B[b];
			i--;
			b--;
		}

		for (int k : A)
			System.out.println(k);

	}

	public static int searchInSortedMatrix(int key) {

		int a[][] = { { 1, 6, 7 }, { 2, 8, 9 }, { 3, 10, 11 } };

		int row = 0;
		int col = 2;

		while (row <= 2 && col >= 0) {
			if (a[row][col] > key)
				col--;
			else if (a[row][col] < key)
				row++;
			else
				return a[row][col];
		}
		return -1;
	}

	public int[] countingSort(int[] a) {

		HashMap<Integer, Integer> C = new HashMap<Integer, Integer>();

		for (int i = 0; i < a.length; i++) {
			if (C.containsKey(a[i])) {
				int temp = C.get(a[i]);
				C.put(a[i], temp + 1);
			} else
				C.put(a[i], 1);
		}

		HashMap<Integer, Integer> M = new HashMap<Integer, Integer>();
		int start = 0;

		Iterator it = C.entrySet().iterator();
		while (it.hasNext()) {

			Map.Entry pairs = (Map.Entry) it.next();
			Integer key = (Integer) pairs.getKey();
			Integer value = (Integer) pairs.getValue();
			M.put(key, start);
			start = start + value;

		}

		

		HashMap<Integer, Integer> C1 = (HashMap<Integer, Integer>) C.clone();
		HashMap<Integer, Integer> M1 = (HashMap<Integer, Integer>) M.clone();

		it = M.entrySet().iterator();
		int temp = -1;
		
		while (it.hasNext()) {

			Map.Entry pairs = (Map.Entry) it.next();
			Integer key = (Integer) pairs.getKey();
			System.out.println("Key is: "+key);
			if (!M1.containsKey(key))
				continue;
			else {
				int count = C1.get(key);
				Integer offset = M1.get(key);

				while (count != 0) {
					System.out.println("Offset is: "+offset);
					 temp=a[offset];
					a[offset] = key;
					if (temp != key) {

						//System.out.println(temp);
						int tempOffset = M1.get(temp);
						int tempCount = C1.get(temp);
						a[tempOffset] = temp;

						if (tempCount == 1) {
							M1.remove(temp);
							C1.remove(temp);
						} else {
							M1.put(temp, tempOffset + 1);
							C1.put(temp, tempCount - 1);
						}

					}

					count--;
					offset++;
					for (int i : a)
						System.out.print(i+",");
					System.out.println();
					//		int a[] = { 1, 2, 3, 4, 2, 3, 5, 1, 2, 3 };

				}
			}
		}

		return a;
	}
	
	public void renderCalendar(char s[])
	
	{
		int count=0;
		int maxCount=Integer.MIN_VALUE;
		
		for (int i=0;i<s.length;i++)
		{
			if(s[i]=='s'){
				count++;
			if(count>maxCount)
			{
				maxCount=count;
			}
			}
			else
				count--;
		}
		
		System.out.println(maxCount);
		
	}

}
