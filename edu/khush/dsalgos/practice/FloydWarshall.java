package edu.khush.dsalgos.practice;

public class FloydWarshall {

	public static void main(String args[]) {

		int[][] adjMat = { { 0, 5, Integer.MAX_VALUE, 10 },
				{ Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1 },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0 } };

		floydAlgo(adjMat, 4);

	}

	public static void floydAlgo(int[][] adjMat, int n) {

		int distance[][] = new int[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				distance[i][j] = adjMat[i][j];

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int sum = distance[i][k] + distance[k][j];
					if (distance[i][k] == Integer.MAX_VALUE
							|| distance[k][j] == Integer.MAX_VALUE)
						sum = Integer.MAX_VALUE;
					if (sum < distance[i][j])
						distance[i][j] = sum;

				}
			}

		}

		for (int l = 0; l < n; l++) {
			for (int m = 0; m < n; m++) {
				if (distance[l][m] > 500)
					System.out.print("Integer.MAX_VALUE,");
				else
					System.out.print(distance[l][m] + ",");
			}
			System.out.println("");
		}
		System.out.println("*********");

	}

	public static void warshallAlgo(int[][] adjMat, int n) {

		int[][] distance = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				distance[i][j] = adjMat[i][j];

			}
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {

					if (distance[i][j] == 1
							|| (distance[i][k] * distance[k][j] == 1))
						distance[i][j] = 1;

				}
			}
		}

	}

}
