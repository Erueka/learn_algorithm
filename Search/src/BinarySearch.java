/**
 * @author Ling
 * Created on 2019/10/5
 */
public class BinarySearch {
    /*
    LeetCode35  给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     */
    public static int search1(int[] nums, int target) {
        // 查找第一大于等于target元素的下标
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) // 排除mid
                left = mid + 1;
            else
                right = mid;
        }

        return nums[left] == target ? left : -1;
    }


    /*
    LeetCode69 计算并返回 x 的平方根，其中 x 是非负整数。 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     */
    public static int mySqrt(int x) {
        // 平方根可能是其本身，所以二分区间为[0,x]
        int left = 0;
        int right = x;

        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (mid > x / mid)
                right = mid - 1;
            else
                left = mid;
        }

        return left;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(search1(nums, 90));
        System.out.println(mySqrt(2147395599));
    }
}
