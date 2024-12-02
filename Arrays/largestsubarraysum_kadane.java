package Arrays;

import java.util.Scanner;

public class largestsubarraysum_kadane {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = solve(arr, n);
        System.out.println(ans);
        sc.close();
    }

    static int solve(int[] arr, int n) {
        // two imp things
        // max so far(max ending here) and total max which we are finding
        int curmax = arr[0], fmax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            curmax = Math.max(arr[i], arr[i] + curmax);
            fmax = Math.max(fmax, curmax);
        }
        return fmax;
    }
}
