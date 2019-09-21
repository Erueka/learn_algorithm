package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ling
 * Created on 2019/9/21
 */
public class ZConvert {
    public String convert(String s, int numRows) {
        if (numRows==1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i=0;i<Math.min(numRows,s.length());i++)
            rows.add(new StringBuilder());

        int cur = 0;    //当前写入第几行
        boolean goingDown = false;   //方向

        for (char c : s.toCharArray()){
            rows.get(cur).append(c);
//            if (cur==numRows-1) goingDown = false;
//            if (cur==0) goingDown = true;
            if (cur==0||cur==numRows-1) goingDown = !goingDown;
            cur += goingDown? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows)   result.append(sb);
        return result.toString();
    }

    public static void main(String[] args) {
        ZConvert z = new ZConvert();
        System.out.println(z.convert("LEETCODEISHIRING",3));
    }
}
