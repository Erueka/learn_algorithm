package LeetCode.RemoveElement;

/**
 * @author Ling
 * Created on 2019/10/12
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;  // 非val移到前面第几个元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val)
                nums[k++] = nums[i];
        }
        return k; // k是下一个非val插入的位置，所以不需要+1；
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,2,2,3};
        System.out.println(s.removeElement(nums,3));
        for (int num : nums)
            System.out.println(num);
    }
}
