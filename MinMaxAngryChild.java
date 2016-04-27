import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class MinMaxAngryChild {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());
		int[] list = new int[N];

		for (int i = 0; i < N; i++)
			list[i] = Integer.parseInt(in.readLine());

		int unfairness = Integer.MAX_VALUE;

		/*
		 * Write your code here, to process numPackets N, numKids K, and the
		 * packets of candies Compute the ideal value for unfairness over here
		 */
		compute(unfairness, N, K, list);
		// System.out.println(unfairness);
	}

	private static void compute(int unfairness, int n, int k, int[] a) {
		// TODO Auto-generated method stub
		Arrays.sort(a);

		for (int i = 0; i < n; i++) {

			int low = i;
			int high = i + k - 1;
			if ((n - i) < k) {
				break;
			}
			unfairness = Math.min(unfairness, (a[high] - a[low]));

		}

		System.out.println(unfairness);

	}

}
