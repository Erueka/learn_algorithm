import java.util.ArrayList;
import java.util.List;

/**
 * @author Ling
 * Created on 2019/10/6
 */
public class FindKClosestNum {
    //    输入: [1,2,3,4,5], k=4, x=3
//    输出: [1,2,3,4]
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        int numsToRemove = arr.length - k;

        while (numsToRemove > 0) {
            if (x - arr[left] <= arr[right] - x)
                right--;
            else
                left++;
            numsToRemove--;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            res.add(arr[i]);
        }

        return res;
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        // 二分查找区间的左端点
        int left = 0;
        int right = arr.length - k;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (x-arr[mid] > arr[mid+k] - x)
                left = mid + 1;
            else
                right = mid;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        FindKClosestNum f = new FindKClosestNum();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(f.findClosestElements2(nums, 5, 1));
    }
}
