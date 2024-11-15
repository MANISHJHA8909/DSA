import java.util.Arrays;
import java.util.Scanner;

public class E_Knapsack_2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int w = read.nextInt();
        int sum  = 0;
        int nums[][] = new int[n][2];

        for(int i=0;i<n;i++)
        {
            nums[i][0] = read.nextInt(); // weight
            nums[i][1] = read.nextInt(); // profit
            sum += nums[i][1];
        }

        long dp[] = new long[sum+1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i=0;i<n;i++)
            for(int j=sum;j>=0;j--)
            {
                if(j - nums[i][1] >= 0)
                {
                    dp[j] = Math.min(dp[j], nums[i][0] + dp[j - nums[i][1]]);
                }
            }
        long ans = 0;

        for(int i=sum;i>=0;i--)
        {
            if(dp[i] <= w)
            {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
        read.close();
    }
}
