import java.util.*;

public class C_Vacation {
    static int[][] dp = new int[(int)(10e5 + 1)][3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // starting position first row all elements
        int ans = Integer.MIN_VALUE;
         

        int val1 = solve(arr, 0, n, 0);
        int val2 = solve(arr, 1, n, 0);
        int val3 = solve(arr, 2, n, 0); 

        //System.out.println(val1 +" "+val2+" " +val3);

        ans = Math.max(ans, val1);
        ans = Math.max(ans, val2);
        ans = Math.max(ans, val3);

        System.out.println(ans);
        sc.close();
    }

    static int solve(int[][] arr, int ind, int n, int row) {
        if(row >= n) {
            return 0;
        }

        if(dp[row][ind] != -1) return dp[row][ind];

        int ans = Integer.MIN_VALUE;

        for(int j=0; j<3; j++) {
            if(j!=ind) {
                ans = Math.max(arr[row][ind] + solve(arr, j, n, row+1) ,ans);
            }
        }

        dp[row][ind] = ans;
        return ans;
    }
}
