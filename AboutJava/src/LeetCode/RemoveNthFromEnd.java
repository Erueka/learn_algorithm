package LeetCode;

/**
 * @author Ling
 * Created on 2019/10/3
 */
public class RemoveNthFromEnd {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val=x;}
    }

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dumy = new ListNode(0);
//        dumy.next = head; // 哑指针
//        ListNode first = head;
//        int len = 0;
//        while (first !=  null){
//            len++;
//            first=first.next;
//        }
//        len -= n;
//        first=dumy;
//        while (len>0) {
//            len--;
//            first = first.next;
//        }
//        first.next = first.next.next;
//        return dumy.next;
//    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode first = dumy;
        ListNode second = dumy;
        while (n!=0){
            n--;
            first=first.next;
        }
        while (first!=null) {
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return dumy.next;
    }

    public static void main(String[] args) {

    }
}
