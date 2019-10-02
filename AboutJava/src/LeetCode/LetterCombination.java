package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ling
 * Created on 2019/10/2
 */
public class LetterCombination {
    Map<String,String> keyBoard = new HashMap<>(){{
        put("2","abc");
        put("3","def");
        put("4","ghi");
        put("5","jkl");
        put("6","mno");
        put("7","pqrs");
        put("8","tuv");
        put("9","wxyz");
    }};

    List<String> combinations = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits==null || digits.length()==0)
            return combinations;
        trackback("",digits);
        return combinations;
    }

    private void trackback(String s, String digits) {
        if (digits.length()==0)
            combinations.add(s);
        else {
            String digit = digits.substring(0,1);
            char[] chars = keyBoard.get(digit).toCharArray();
            for (char c : chars) {
                trackback(s+c,digits.substring(1,digits.length()));
            }
        }
    }

    public static void main(String[] args) {
        LetterCombination l = new LetterCombination();
        System.out.println(l.letterCombinations(""));
    }
}
