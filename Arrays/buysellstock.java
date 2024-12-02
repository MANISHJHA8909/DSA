package Arrays;
/* You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0. */

public class buysellstock {
    public static void main(String[] args) {
        int[] arr = { 7, 1, 5, 3, 6, 4 };
        int n = arr.length;

        int min = Integer.MAX_VALUE, ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else {
                ans = Math.max(ans, arr[i] - min);
            }
        }

        System.out.println(ans == Integer.MIN_VALUE ? 0 : ans);
    }
}
