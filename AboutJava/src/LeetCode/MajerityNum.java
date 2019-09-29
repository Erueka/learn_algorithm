package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ling
 * Created on 2019/9/29
 */
public class MajerityNum {
//        // 暴力法
//        public int majorityElement(int[] nums) {
//            int majority = 0;
//            int len = nums.length;
//            for (int i = 0 ;i<len;i++){
//                if (count(nums,nums[i])>=(len+1)/2) {
//                    majority = i;
//                    break;
//                }
//            }
//            return nums[majority];
//        }
//
//        public int count(int[] nums, int elem) {
//            int count = 0;
//            for (int num : nums) {
//                if (num == elem)    count++;
//            }
//            return count;
//        }


//    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> countMap = creatHashMap(nums);
//
//        Map.Entry<Integer, Integer> majorrityEntry = null;
//        for (Map.Entry<Integer,Integer> entry : countMap.entrySet()) {
//            if ( majorrityEntry == null || entry.getValue() > majorrityEntry.getValue())
//                majorrityEntry = entry;
//        }
//        return majorrityEntry.getKey();
//    }
//
//    public Map<Integer, Integer> creatHashMap(int[] nums) {
//        Map<Integer, Integer> countMap = new HashMap<>();
//        for (int num : nums) {
//            if (countMap.containsKey(num))
//                countMap.put(num,countMap.get(num+1));
//            else
//                countMap.put(num,1);
//        }
//        return countMap;
//    }


    public int majorityElement(int[] nums) {
        if (nums==null || nums.length == 0)
            return -1;
        return majorityElement(nums,0,nums.length-1);
    }

    public int majorityElement(int[] nums,int left,int right) {
        if (left==right)
            return nums[left];

        int mid = (right-left)/2 + left;
        int leftMajor = majorityElement(nums,left,mid);
        int rightMajor = majorityElement(nums,mid+1,right);

        if (leftMajor == rightMajor)
            return leftMajor;

        int leftCount = count(nums,leftMajor,left,right);
        int rightCount = count(nums,rightMajor,left,right);

        return leftCount>rightCount ? leftMajor : rightMajor;
    }

    public int count(int[] nums, int num, int left,int right) {
        int count = 0;
        for (int j = left;j<=right;j++){
            if (nums[j]==num) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        MajerityNum m = new MajerityNum();
        int[] i = {3,2,3};
        System.out.println(m.majorityElement(i));
    }
}
