import java.util.*;

public class Vacation {
    static int[] dp = new int[(int)(10e5 + 1)];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        Arrays.fill(dp, -1);

        for(int i=0; i<n; i++) {
            for(int j=0; j<3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // starting position first row all elements
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<3; i++) {
            int val = solve(arr, i);
            ans = Math.max(ans, val);
        }    
        System.out.println(ans);
        sc.close();
    }

    static int solve(int[][] arr, int ind) {
        if(ind >= arr.length) {
            return 0;
        }

        if(dp[ind] != -1) return dp[ind];
        int ans = Integer.MIN_VALUE;
        for(int j=0; j<3; j++) {
            if(j!=ind && ind<arr.length && j>0 && j<3) {
                ans = Math.max(arr[ind][j] + solve(arr, ind+1), ans);
            }
        }

        dp[ind] = ans;
        return dp[ind];
    }
}
