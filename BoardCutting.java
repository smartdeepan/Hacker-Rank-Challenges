//https://www.hackerrank.com/challenges/board-cutting

import java.util.Arrays;
import java.util.Scanner;

public class BoardCutting {

	public static void main(String[] args) {
		int t, m, n;
		int x[], y[];
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while (t-- != 0) {
			m = sc.nextInt();
			n = sc.nextInt();

			y = new int[m - 1];
			x = new int[n - 1];

			for (int i = 0; i < m - 1; i++) {
				y[i] = sc.nextInt();
			}
			for (int i = 0; i < n - 1; i++) {
				x[i] = sc.nextInt();
			}

			compute(x, y, m, n);

		}
		sc.close();
	}

	private static void compute(int[] x, int[] y, int m, int n) {
		// TODO Auto-generated method stub

		Arrays.sort(x);
		Arrays.sort(y);
		long factor = 1000000007;

		int i, j;

		int xfactor = 1, yfactor = 1;
		long ans = 0;

		for (i = m - 2, j = n - 2; i >= 0 || j >= 0;) {

			if (i >= 0 && j >= 0) {

				if (y[i] > x[j]) {
					ans = (ans + ((long) yfactor * (long) y[i]) % factor)
							% factor;
					xfactor++;
					i--;

				} else if (y[i] == x[j]) {

					if (((xfactor * x[j] == yfactor * y[i]) && (i > j))
							|| (xfactor * x[j] > yfactor * y[i])) {
						ans = (ans + ((long) yfactor * (long) y[i]) % factor)
								% factor;
						xfactor++;
						i--;
					} else if (((xfactor * x[j] == yfactor * y[i]) && (j > i))
							|| (xfactor * x[j] < yfactor * y[i])) {
						ans = (ans + ((long) xfactor * (long) x[j]) % factor)
								% factor;
						yfactor++;
						j--;
					} else {
						ans = (ans + ((long) yfactor * (long) y[i]) % factor)
								% factor;
						xfactor++;
						i--;
					}

				} else {
					ans = (ans + ((long) xfactor * (long) x[j]) % factor)
							% factor;
					yfactor++;
					j--;
				}

			}

			if (i < 0) {
				ans = (ans + ((long) xfactor * (long) x[j]) % factor) % factor;
				yfactor++;
				j--;
			}

			else if (j < 0) {
				ans = (ans + ((long) yfactor * (long) y[i]) % factor) % factor;
				xfactor++;
				i--;

			}
		}

		System.out.println(ans % factor);

	}
}
