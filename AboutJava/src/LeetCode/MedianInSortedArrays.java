package LeetCode;

/**
 * @author Ling
 * Created on 2019/9/16
 * L1  R1
 * num1:    2 3 4 | 5 8
 * L2  R2
 * num2:    3 4 | 5 7 9 10
 */
public class MedianInSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // nums1长度总小于nums2
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int len = nums1.length + nums2.length;
        int cut1 = 0;
        int cut2 = 0;
        int cutL = 0;
        int cutR = nums1.length;    // 对nums二分的区间

        while (cut1 <= nums1.length) {
            cut1 = (cutR - cutL) / 2 + cutL;    // 二分查找
            cut2 = len / 2 - cut1;

            double L1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = cut1 == nums1.length ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = cut2 == nums2.length ? Integer.MAX_VALUE : nums2[cut2];

            if (L1 > R2) {
                cutR = cut1 - 1;
            } else if (L2 > R1) {
                cutL = cut1 + 1;
            } else {
                if (len % 2 == 0) {
                    double lMax = L1 > L2 ? L1 : L2;
                    double rMin = R2 < R1 ? R2 : R1;
                    return (lMax + rMin) / 2;
                } else {
                    return R1 < R2 ? R1 : R2;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] i1 = {1};
        int[] i2 = {3,5,6,8,9};
        MedianInSortedArrays m = new MedianInSortedArrays();
        System.out.println(m.findMedianSortedArrays(i1, i2));
    }
}
