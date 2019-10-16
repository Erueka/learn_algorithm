package LeetCode.LIS;

/**
 * @author Ling
 * Created on 2019/10/16
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        /*
        我是谁？
        我从哪里来？
        我到哪里去？
         */
        int len = nums.length;
        if (len==1) return 1;
        int[] f = new int[len];
        int ans = 1;
        for (int i = 0 ; i < f.length; i++)
            f[i]=1;
        for (int i = 0; i < len; i++){
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i])
                    f[i] = Math.max(f[j]+1,f[i]);
            }
            System.out.println(f[i]);
        }

        for (int num : f)
            ans = Math.max(ans,num);

        return ans;
    }

    public static void main(String[] args) {
        LengthOfLIS l = new LengthOfLIS();
        int[] nums = {3,1,4,1,5,9,2,6,5,11};
        System.out.println(l.lengthOfLIS(nums));
    }
}
