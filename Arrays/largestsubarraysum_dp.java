package Arrays;

import java.util.*;

public class largestsubarraysum_dp {
    static int maxAns = Integer.MIN_VALUE;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        dp = new int[n+1];
        Arrays.fill(dp, -1);

        solve(arr, 0);
        System.out.println(maxAns);
        sc.close();
    }

    static int solve(int[] arr, int i) {
        if(i>=arr.length) return 0;

        if(dp[i] != -1) return dp[i];

        int curans = Math.max(arr[i], solve(arr, i+1)+arr[i]);
        maxAns = Math.max(maxAns, curans);

        dp[i] = maxAns;
        return curans;
    }
}
