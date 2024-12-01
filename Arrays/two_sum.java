package Arrays;

import java.util.*;

class two_sum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int t = 9;
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(t-nums[i])) {
                ans[0]=i;
                ans[1]=map.get(t-nums[i]);
                break;
            }
            map.putIfAbsent(nums[i], i);
        }

        for(int x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}