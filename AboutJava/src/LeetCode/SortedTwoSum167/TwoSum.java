package LeetCode.SortedTwoSum167;

/**
 * @author Ling
 * Created on 2019/10/15
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        // 利用对撞指针
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {    // index1必须小于index2
            if (numbers[left] + numbers[right] == target)
                break;
            else if (numbers[left] + numbers[right] > target)
                right--;
            else left++;
        }
        int[] ans = {left + 1, right + 1};
        return ans;
    }

    public int[] twoSum2(int[] numbers, int target) {
        // 利用二分法
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            int find = target - numbers[i];
            int finded = binarySerch(numbers,i+1,len-1,find);
            if (finded!=-1){
                int[] ans = {i+1,finded+1};
                return ans;
            }
        }
        return null;
    }

    private int binarySerch(int[] nums, int l, int r, int find) {
        int left = l;
        int right = r;
        while (left<right) {
            int mid = (left+right) >> 1;
            if (nums[mid] < find)
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left]==nums[right] ? left : -1;
    }
}

