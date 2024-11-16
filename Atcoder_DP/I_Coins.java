import java.util.*;

class I_Coins {
    static double[][] dp;

    static double solve(int ind, int ch, int ct, int n, double[] arr) {
        if(ind>n-1) {
            if(ch < ct) {
                return 0;
            } else {
               return 1; 
            }
        }

        if(dp[ind][ch] != -1) return dp[ind][ch];
        
        double ans = Double.MIN_VALUE;
        double c = arr[ind]*solve(ind+1, ch+1,ct, n, arr); 
        double uc = (1-arr[ind])*solve(ind+1, ch,ct+1, n, arr);

        ans = Math.max(c+uc, ans);
        dp[ind][ch] = ans;
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextDouble();
        }

        dp = new double[n+1][n+1];

        for(double[] row : dp) {
            Arrays.fill(row, -1);
        }

        double ans = solve(0, 0, 0, n, arr);
        System.out.println(ans);
        sc.close();
    }
}