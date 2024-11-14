// Problem Statement

// There are
// N stones, numbered 1,2,…,N. For each i (1≤i≤N), the height of Stone i is

// hi​.

// There is a frog who is initially on Stone
// 1. He will repeat the following action some number of times to reach Stone

// N:

//     If the frog is currently on Stone 

// i, jump to one of the following: Stone i+1,i+2,…,i+K. Here, a cost of ∣hi​−hj​∣ is incurred, where

//     j is the stone to land on.

// Find the minimum possible total cost incurred before the frog reaches Stone

// N.
// Constraints

//     All values in input are integers.

// 2≤N≤10^5
// 1≤K≤100
// 1≤hi​≤10

/* example sample input : 
5 3
10 30 40 50 20 
sample output : 30 
If we follow the path 1 → 2 → 5, the total cost incurred would be ∣10−30∣+∣30−20∣=30.*/

import java.util.*;

public class frog2 {
    static int[] dp = new int[(int) (10e5 + 1)];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.fill(dp, -1);
        int ans = solve(arr, k, 0);
        System.out.println(ans);
        sc.close();
    }

    static int solve(int[] arr, int k, int ind) {
        if (ind >= arr.length-1) {
            return 0;
        }

        if (dp[ind] != -1)
            return dp[ind];

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            int j = ind + i;
            if (j < arr.length) {
                ans = Math.min(ans, Math.abs(arr[j] - arr[ind]) + solve(arr, k, j));
            }

        }

        dp[ind] = ans;
        return dp[ind];
    }
}
