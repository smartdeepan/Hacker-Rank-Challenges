//Greedy Florist
//by HackerRank
//Problem
//Submissions
//Leaderboard
//Discussions
//Editorial
//Topics
//
//You and K−1K−1 friends want to buy NN flowers. Each flower fifi has some cost cici. The florist is greedy and wants to maximize his number of new customers, so he increases the sale price of flowers for repeat customers; more precisely, if a customer has already purchased xx flowers, price PP for fifi is Pfi=(x+1)×ciPfi=(x+1)×ci.
//
//Find and print the minimum cost for your group to purchase NN flowers.
//
//Note: You can purchase the flowers in any order.
//
//Input Format
//
//The first line contains two integers, NN (number of flowers to purchase) and KK (the size of your group of friends, including you). 
//The second line contains NN space-separated positive integers describing the cost (c0,c1,...,cN−2,cN−1c0,c1,...,cN−2,cN−1) for each flower fifi .
//
//Constraints
//
//1≤N,K≤1001≤N,K≤100
//1≤ci≤1061≤ci≤106
//answer<231answer<231
//0≤i≤N−1
//Output Format
//
//Print the minimum cost for buying NN flowers.
//
//Sample Input 0
//
//3 3
//2 5 6
//Sample Output 0
//
//13
//Sample Input 1
//
//3 2
//2 5 6
//Sample Output 1
//
//15
//Explanation
//
//Sample Case 0: 
//There are 33 flowers and 33 people in your group. Each person buys one flower and the sum of prices paid is 1313 dollars, so we print 1313.
//
//Sample Case 1: 
//There are 33 flowers and 22 people in your group. The first person purchases 22 flowers, f0f0 and f1f1, in order of decreasing price; this means they buy the more expensive flower first at price Pf1=(0+1)×5=5 dollarsPf1=(0+1)×5=5 dollars and the less expensive flower second at price Pf0=(1+1)×2=4 dollarsPf0=(1+1)×2=4 dollars. The second person buys the most expensive flower at price Pf2=(0+1)×6=6 dollarsPf2=(0+1)×6=6 dollars. We print the sum of these purchases (5+4+65+4+6), which is 1515.
//

import java.util.Arrays;
import java.util.Scanner;

public class Greedyflorist {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		int n, k;
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		k = sc.nextInt();

		int flower[] = new int[n];
		int directCost = 0;
		for (int i = 0; i < n; i++) {

			flower[i] = sc.nextInt();
			directCost += flower[i];

		}

		System.out.println(computeCost(n, k, flower, directCost));
		sc.close();
	}

	private static int computeCost(int n, int k, int[] flower, int directCost) {

		if (n == k) {
			return directCost;
		}
		Arrays.sort(flower);
		int revflower[] = reverse(flower);
		int cost = 0, j = 0;
		int x = 1;

		for (int i = 0; i < n;) {
			j = i + k;
			while (i < j) {
				if (i >= n) {
					break;
				}
				cost += (x * revflower[i]);
				i++;
			}
			x++;
		}

		return cost;
	}

	private static int[] reverse(int[] flower) {

		int rev[] = new int[flower.length];
		int n = flower.length - 1;
		for (int i = 0; i < flower.length; i++) {
			rev[n] = flower[i];
			n--;
		}
		return rev;
	}

}
