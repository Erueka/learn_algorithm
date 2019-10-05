/**
 * @author Ling
 * Created on 2019/10/5
 */
public class CircleArray {
    // 寻找选准排序数组中的最小值
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;  // 二分区间[0,n -1]
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }

    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid]>nums[right])
                left = mid + 1;
            else if (nums[mid]<nums[right])
                right = mid;
            else
                right--;
        }
        return nums[left];
    }
}
