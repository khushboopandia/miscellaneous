package edu.khush.dsalgos.practice;
import javax.naming.BinaryRefAddr;

public class BitManipulation {

	public static void main(String[] args) {
		//System.out.println(getAbsoluteValue(5));
		System.out.println(swapOddEvenBits(5));
		
		
	}

	public static int setBitTo1(int n, int bitPosFromRight) {
		int mask = 1 << bitPosFromRight;
		return n | mask;

	}

	public static int setBitTo0(int n, int bitPosFromRight) {

		int mask = ~(1 << bitPosFromRight);
		return n & mask;
	}

	public int countNumberOf1s(int n) {
		int count = 0;

		while (n != 0) {
			count += 1;
		}

		return 0;
	}

	public static int getSignOfAnInt(int n) {

		System.out.println(Integer.toBinaryString(n));
		// 11111111111111111111111111111001
		// 111
		// Here first 8 is for bytes
		// Second 8 is for number of bits in a byte
		return n >> (8 * 8 - 1);

	}

	public static int getAbsoluteValue(int n) {
		System.out.println(Integer.toBinaryString(n));
		int mask = n >> 63;
		System.out.println(Integer.toBinaryString(mask));
		int temp = n + mask;
		System.out.println(Integer.toBinaryString(temp));
		int result = temp ^ mask;
		System.out.println(Integer.toBinaryString(result));
		return result;
	}

	public static boolean isPowerOf2(int n) {

		// Clear the lowest set bit and compare to 0
		return (n & (n - 1)) == 0;

		// to handle 0 as a non-power of 2
		// return n && !(v & (v-1))

	}

	public static int  getLowestSetBit(int n) {

		if (!isPowerOf2(n))
	        return -1;
	 
	    int i = 1, pos = 1;
	 
	    // Iterate through bits of n till we find a set bit
	    // i&n will be non-zero only when 'i' and 'n' have a set bit
	    // at same position
	    while ((i & n)!=0)
	    {
	        // Unset current bit and set the next bit in 'i'
	        i = i << 1;
	 
	        // increment position
	        ++pos;
	    }
	 
	    return pos;
	}

	//Works only for unsigned int
	public static int getCountOfSetBits(int n) {
		int count = 0;
		for (; n != 0; count++)

			n = n & (n - 1);

		return count;

	}
	
	//Works only for unsigned int
	public boolean getParity(int n)
	{
		boolean parity=false;
		while (n!=0)
		{
			parity=!parity;
			n=n & (n-1);
		}
		
		return parity;
	}
	
	public static int updateBits(int n,int m,int i,int j)
	{
		
		int mask=~0;
		
		int left= mask-((1<<j)-1);
		System.out.println(Integer.toBinaryString(left));
		
		int right=(1<<i)-1;
		System.out.println(Integer.toBinaryString(right));
		
		
		mask =left | right;
		System.out.println(Integer.toBinaryString(mask));
		
		int result=(n & mask) | (m << i);
		System.out.println(Integer.toBinaryString(result));
		
		return result;
		
	}
	
	public static int getNoOfBitsDifference(int a, int b)
	{
		int c= a^b;
		return getCountOfSetBits(c);
		
	}
	
	public static int swapOddEvenBits(int x)
	{
		
		System.out.println(Integer.toBinaryString(0xaaaaaaaa));
		int result=( ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1) );
		System.out.println(Integer.toBinaryString(result));
		return result;
	}
	
	public void swapNumbers(int m,int n)
	{
		m=m^n;
		n=m^n;
		m=m^n;
	}
	
	public static void getAndTurnOffRightmostSetBit(int n)
	{
		
		int i=5;
		
	}
	
}
