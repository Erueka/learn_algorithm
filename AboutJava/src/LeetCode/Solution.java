package LeetCode;

import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ling
 * Created on 2019/9/14
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);   //哑节点
        ListNode cur = dummy;    // 当前节点
        int carry = 0;  // 进位
        int sum = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 == null) ? l1.val : 0;
            int y = (l2 == null) ? l2.val : 0;
            sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry ==1){
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}

