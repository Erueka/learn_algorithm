package LeetCode.MoveZero;

/**
 * @author Ling
 * Created on 2019/10/10
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0; // 所有在[0,k)之间的元素都是非零元素

        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                if (i != k)
                    swap(nums,i, k++);
                else
                    k++;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}