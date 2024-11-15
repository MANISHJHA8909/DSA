import java.util.*;

public class G_Longest_Path {

    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int e = sc.nextInt(); 

        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) { 
            adj.add(new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < e; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj.get(x).add(y);
        }

        // Initialize dp array
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int ans = 0; 
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dfs(i, adj));
        }

        System.out.println(ans);
        sc.close();
    }

    static int dfs(int node, List<List<Integer>> adj) {
        if (dp[node] != -1) return dp[node]; 
        int ans = 0;

        for (int child : adj.get(node)) {
            ans = Math.max(ans, dfs(child, adj) + 1);
        }

        dp[node] = ans; 
        return ans;
    }
}
