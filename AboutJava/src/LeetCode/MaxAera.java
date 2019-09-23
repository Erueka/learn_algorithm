package LeetCode;

/**
 * @author Ling
 * Created on 2019/9/23
 */
public class MaxAera {
    public int maxArea(int[] heigth) {
        int low = 0;
        int hei = heigth.length - 1;
        int max = 0;
        while (low < hei) {
            int temp = calArea(heigth, low, hei);
            max = temp > max ? temp : max;
            if (heigth[low] < heigth[hei])
                low++;
            else
                hei--;
        }
        return max;
    }

    private int calArea(int[] height, int i, int j) {
        return Math.min(height[i], height[j]) * (j - i);
    }
}
