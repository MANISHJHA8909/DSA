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

        for(int i=n-2; i>=0; i--) {
            int v0 = arr[i+1][0];
            int v1 = arr[i+1][1];
            int v2 = arr[i+1][2];
            for(int j=2; j>=0; j--) {
                if(j==2) {
                    arr[i][j] = Math.max(v0, v1) + arr[i][j];
                } else if(j==1) {
                    arr[i][j] = Math.max(v0, v2) + arr[i][j];
                } else {
                    arr[i][j] = Math.max(v2, v1) + arr[i][j];
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<3; i++) {
            ans = Math.max(ans, arr[0][i]);
        }
        
        System.out.println(ans);
        sc.close();
    }

    // static int solve(int[][] arr, int ind, int n, int row) {
    //     if(row >= n) {
    //         return 0;
    //     }

    //     if(dp[row][ind] != -1) return dp[row][ind];

    //     int ans = Integer.MIN_VALUE;

    //     for(int j=0; j<3; j++) {
    //         if(j!=ind) {
    //             ans = Math.max(arr[row][ind] + solve(arr, j, n, row+1) ,ans);
    //         }
    //     }

    //     dp[row][ind] = ans;
    //     return ans;
    // }
}
