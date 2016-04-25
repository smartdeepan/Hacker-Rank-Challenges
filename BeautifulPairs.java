// https://www.hackerrank.com/challenges/beautiful-pairs

import java.util.Scanner;

public class BeautifulPairs {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}

		compute(a, b, n);
		sc.close();
	}

	private static void compute(int[] a, int[] b, int n) {
		// TODO Auto-generated method stub
		int ans = 0;
		boolean taken1[] = new boolean[n];
		boolean taken2[] = new boolean[n];
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				if (a[i] == b[j]) {
					System.out.println("check" + a[i] + " -- " + b[j]);
				}

				if ((a[i] == b[j]) && !taken1[i] && !taken2[j]) {
					ans++;
					taken1[i] = true;
					taken2[j] = true;
					break;
				}
			}

		}

		System.out.println((ans == n) ? ans - 1 : ans + 1);

	}
}
