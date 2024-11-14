import java.util.*;

public class D_Knapsack_1 {
    static long[][] dp = new long[101][(int)(10e5+1)];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        for(long[] row : dp) {
            Arrays.fill(row, -1);
        }
        

        long ans = solve(arr, n, w, 0);
        System.out.println(ans);
        sc.close();
    }

    static long solve(int[][] arr, int n, int w, int ind) {
        if(ind >= n) {
            return 0;
        }

        if(w<=0) {
            return 0;
        }
        
        if(dp[ind][w] != -1) {
            return dp[ind][w];
        }

        long ans = Long.MIN_VALUE;
        long up = solve(arr, n, w, ind+1);
        long p = Long.MIN_VALUE;
        if(arr[ind][0] <= w) {
            p = arr[ind][1] + solve(arr, n, w-arr[ind][0], ind+1);
        }

        dp[ind][w] = Math.max(p, up);
        return dp[ind][w];
    }
}