package LeetCode.Combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ling
 * Created on 2019/11/5
 */
public class GetPermutation {
    // 输入n共有n！中排列
    // 每一个数字开头有(n-1)！种
    // 输出第k种
    // 用k/(n-1)！等于几开头就是几加1
    //
    private List<String> res = new ArrayList<>();
    private int[] jc = {0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    // jc[i] = i!

    public String getPermutation(int n, int k) {
        int[] used = new int[n + 1];
        int start = k / jc[n - 1] + 1;  // 首位
        int len = k % jc[n - 1];        // 首位为start的第几个
        if (len == 0)   len = jc[n - 1];

        for (int i = 1; i <= n; i++)    // 首位不可用
            used[i] = 0;
        used[start] = 1;

        generate(n, used, "", k, len, start);  // 生成后n-1位

        return res.get(len-1);
    }

    private void generate(int n, int[] used, String s, int k, int need, int start) {
        if (s.length() == n-1) {
            res.add(start+s);
            need--;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (need == 0)
                return;
            if (used[i] == 0) {
                used[i] = 1;
                generate(n, used, s + i, k, need, start);
                used[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        GetPermutation g = new GetPermutation();
        System.out.println(g.getPermutation(2, 2));
    }
}
