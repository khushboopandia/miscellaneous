package edu.khush.dsalgos.practice;

public class RodCutting {

	public static void main(String[] args) {
		int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		RodCutting rc = new RodCutting();
		System.out.println(rc.cutRod(price, 8));
		//System.out.println(rc.maxProductRod(10));
	}

	public int cutRod(int[] price, int n) {

		int[] val = new int[n + 1];
		val[0] = 0;

		for (int i = 1; i <= n; i++) {
			int max_val = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				max_val = Math.max(max_val, price[j] + val[i - j - 1]);
			}

			val[i] = max_val;
		}
		
		for (int i=0;i<=n;i++)
			System.out.println(val[i]);

		return val[n];

	}
	
	
	public int maxProductRod( int n) {

		int[] val = new int[n + 1];
		val[0] = 0;
		val[1] = 0;


		for (int i = 2; i <= n; i++) {
			System.out.println(i);
			int max_val = Integer.MIN_VALUE;
			for (int j = 1; j < i; j++) {
				System.out.println(j+","+(i-j)+","+val[i-j]);
				max_val = Math.max(max_val,j*(i-j));
				max_val = Math.max(max_val,j * val[i - j ]);
			}

			val[i] = max_val;
		}

		return val[n];

	}
}
