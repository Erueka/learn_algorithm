package LeetCode.NextDir;

public class NextPermution {
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len-2;  // 寻找到nums[i]<nums[i+1];
        while (i>=0 && nums[i]>=nums[i+1])
            i--;
        if (i>=0) {
            int j = len - 1;
            while (nums[j]>=0 && nums[j]<=nums[i])
                j--;
            swap(nums,i, j);
        }
        reverse(nums, i+1);
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length-1;
        while (i<j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
