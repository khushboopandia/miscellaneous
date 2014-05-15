package edu.khush.dsalgos.practice;

public class RotatedArrays {

	public static void main(String[] args) {

		int[] a = { 6, 7, 8, 9, 1, 2, 3, 4, 5 };
		RotatedArrays ra = new RotatedArrays();
		System.out.println(ra.findInRotatedArray(a,9));

	}

	public int findMaxInRotatedArray(int a[]) {
		int l = 0;
		int h = a.length - 1;

		while (h - l > 1) {
			int mid = l + (h - l) / 2;
			if (a[mid] > a[h])
				l = mid;
			else
				h = mid - 1;
		}

		if (h - l == 1)
			return Math.max(a[l], a[h]);
		else
			return a[l];

	}

	public int findMinInRotatedArray(int a[]) {

		int l = 0;
		int h = a.length - 1;

		while (h - l > 1) {
			int mid = l + (h - l) / 2;
			if (a[mid] > a[h])
				l = mid + 1;
			else
				h = mid;
		}

		if (h - l == 1)
			return Math.min(a[l], a[h]);
		else
			return a[l];

	}

	public int findInRotatedArray(int a[], int key) {
		int l = 0;
		int u = a.length - 1;

		while (l <= u) {
			int m = l + (u - l) / 2;
			if (key == a[m])
				return a[m];

			else if (a[l] <= a[m]) {
				if (key > a[m])
					l = m + 1;
				else if (key >= a[l])
					u = m - 1;
				else
					l = m + 1;

			}

			else if (key < a[m])
				u = m - 1;
			else if (key <= a[u])
				l = m + 1;
			else
				u = m - 1;

		}

		return -1;
	}

}
