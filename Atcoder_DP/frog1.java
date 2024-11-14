import java.util.*;

class frog1 { 
    static int k = 2; 
    static int[] dp = new int[100001]; 

    static int solve(int i, int[] arr) {
        if (i >= arr.length - 1) return 0; 
        // hghg;

        if (dp[i] != -1) return dp[i]; 

        int ans = Integer.MAX_VALUE; 

        for (int jmp = 1; jmp <= k; jmp++) {
            int j = i + jmp;
            if (j < arr.length) { 
                ans = Math.min(ans, Math.abs(arr[i] - arr[j]) + solve(j, arr));
            }
        }

        dp[i] = ans; 
        return ans;
    }

    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.fill(dp, -1); 

        int ans = solve(0, arr);
        System.out.println(ans);
        sc.close();
    } 
}
