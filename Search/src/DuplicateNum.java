/**
 * @author Ling
 * Created on 2019/10/5
 */
public class DuplicateNum {
    public static int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length-1;
        while (left<right) {
            int mid = (left+right) >>> 1;
            int count = 0;
            for (int num : nums)
                count += num<=mid ? 1 : 0;
            if (count > mid)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2,2};
        System.out.println(findDuplicate(nums));
    }
}
