import java.util.*;

public class F_LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();
        int n = str1.length();
        int m = str2.length();

        // doing every string dp via bottom up
        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<n+1; i++) {
            dp[i][0] = 0;
        }

        for(int i=0; i<m+1; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int i=n, j=m, ind=dp[n][m];

        char[] ans = new char[ind];

        while(i>0 && j>0) {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                ans[ind-1] = str1.charAt(i-1);
                i--;
                j--;
                ind--;

            

            } 
            
            
        else if(dp[i-1][j] < dp[i][j-1]){
                j--;
            } else {
                i--;
            }
        }

        String res = new String(ans);
        

        System.out.println(res);
        sc.close();
    }
    
}