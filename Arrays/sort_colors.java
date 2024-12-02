package Arrays;

public class sort_colors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        //int n = nums.length;

        int l=0, r=nums.length-1, c=0;

        while(c<=r) {
            if(nums[c] == 2) {
                int t = nums[c];
                nums[c] = nums[r];
                nums[r] = t;
                r--;
            } else if(nums[c] == 0) {
                int t = nums[c];
                nums[c] = nums[l];
                nums[l] = t;
                l++;
                c++;
            } else {
                c++;
            }
        }

        for(int x : nums) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
