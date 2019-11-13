package LeetCode.N皇后;

public class Load {
    int max = -1;   // 第一个集装箱能装的最大
    int[] used;     // 去重

    public boolean loadable(int[] nums, int n, int c1, int c2) {
        used = new int[n];
        helper(nums, n, c1, 0);
        int sum = 0;
        for (int num : nums)
            sum += num;
        return sum-max<=c2;
    }

    // 计算c容量集装箱能装下的最多货物
    private void helper(int[] nums, int n, int c, int total) {
        for (int i = 0; i < n; i++) {
            if (used[i] == 0 && nums[i] <= c) {
                total += nums[i];
                used[i] = 1;
                max = Math.max(max, total);
                helper(nums, n, c - nums[i], total);
                total -= nums[i];  // 回溯
                used[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Load l = new Load();
        int nums[] = {1, 2, 3, 4};
        System.out.println(l.loadable(nums,4,5,5));
    }
}
