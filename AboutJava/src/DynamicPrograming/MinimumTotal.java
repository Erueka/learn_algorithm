package DynamicPrograming;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ling
 * Created on 2019/10/21
 * <p>
 * LeetCode 120
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int left = triangle.get(i + 1).get(j);
                int right = triangle.get(i + 1).get(j + 1);
                 triangle.get(i).add(j,Math.min(left, right));
            }
        }
        return triangle.get(0).get(0);
    }
}
