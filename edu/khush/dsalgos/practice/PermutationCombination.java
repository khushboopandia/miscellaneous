package edu.khush.dsalgos.practice;

import java.util.ArrayList;

public class PermutationCombination {
	
	int[] ColForRow=new int[8];

	public static void main(String[] args) {
		
		PermutationCombination pc = new PermutationCombination();

		char[] a={'a','b','c'};
		//pc.getLexicographicPerms(a);
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);

		//pc.getPermutations("", "abcd");
		//pc.allCombination("abcd".toCharArray(),0,3,"");
		/*ArrayList<String> result = pc.getCombinations("wxyz",
				new ArrayList<String>());
		for (String s : result)
			System.out.println(s);*/
		
		pc.placeQueen(0);

	}

	public static ArrayList<ArrayList<Integer>> getAllSubsets(
			ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();

		int max = 1 << set.size();
		for (int i = 0; i < max; i++) {
			ArrayList<Integer> subset = new ArrayList<Integer>();
			int k = i;
			int index = 0;
			while (k > 0) {
				if ((k & 1) > 0) {
					subset.add(set.get(index));
				}

				k >>= 1;
				index++;
			}
			allsubsets.add(subset);
		}
		return allsubsets;

	}

	public void getPermutations(String prefix, String str) {
		//System.out.println(prefix);
		//System.out.println(str);
		//System.out.println("****");
		if (str.length() == 0)
		{
		//if (prefix.length() == 2)
			System.out.println(prefix);
			return;
		}
		else {
			for (int i = 0; i < str.length(); i++) {
				getPermutations(prefix + str.charAt(i), str.substring(0, i)
						+ str.substring(i + 1));
			}
		}

	}

	public ArrayList<String> getCombinations(String str,
			ArrayList<String> subset) {

		if (str.length() == 1) {
			ArrayList<String> additionalSubset = new ArrayList<String>();
			for (String element : subset) {
				additionalSubset.add(str + element);
			}
			subset.addAll(additionalSubset);
			subset.add(str);
			return subset;
		}

		else {
			for (int i = str.length() - 1; i >= 0; i--)
				subset = getCombinations("" + str.charAt(i), subset);
			return subset;

		}

	}
	
	
	public void placeQueen(int row)
	{
		if (row==8)
		{
			printBoard();
			
			return;
		}
		
		for(int i=0;i<8;i++)
		{
			ColForRow[row]=i;
			if(check(row))
			{
				placeQueen(row+1);
			}
		}
		
	}
	
	
	
	public void printBoard()
	{
		for (int i:ColForRow)
			System.out.print(i+",");
		System.out.println();
		//ColForRow=new int[8];
	}
	
	
	

	public boolean check(int row)
	{
		for(int i=0;i<row;i++)
		{
			int diff = Math.abs(ColForRow[i] - ColForRow[row]);
			if (diff == 0 || diff == row - i) 
				return false;
		}
		
		return true;
	}
	
	public void allCombination(char[] S, int start, int r, String output) {
		int length = S.length;
		if (r == 1) {
		    for (int i = start; i < length; i++) {
		    	System.out.println(output + S[i]);
		    }
		} else {
		    for (int k = start; k < length - r + 1; k++) {
		    	//System.out.println("abcd,"+(k+1)+","+(r-1)+","+output+S[k]);
			allCombination(S, k + 1, r - 1, output + S[k]);
		    }
		}
	    }
	
	
	public void getLexicographicPerms(char[] toPermute)
	{
		int n=toPermute.length;
		int indexArray[]=new int[toPermute.length];
		
		for(int i=0;i<n;i++)
			indexArray[i]=i;
		
		printPermutation(toPermute,indexArray);
		
		while(hasNext(indexArray))
			printPermutation(toPermute,indexArray);

		
		
	}

	private boolean hasNext(int[] a) {
		int N = a.length;

        // find rightmost element a[k] that is smaller than element to its right
        int k; 
        for (k = N-2; k >= 0; k--)
            if (a[k] < a[k+1]) break;
        if (k == -1) return false;

        // find rightmost element a[j] that is larger than a[k]
        int j = N-1;
        while (a[k] > a[j])
            j--;
        swap(a, j, k);
        
        for (int r = N-1, s = k+1; r > s; r--, s++)
            swap(a, r, s);
        
        return true;
	}

	private void printPermutation(char[] toPermute, int[] indexArray) {

		for (int i=0;i<indexArray.length;i++)
			System.out.print(toPermute[indexArray[i]]);
		System.out.println();
	}
	
	public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
	
}
