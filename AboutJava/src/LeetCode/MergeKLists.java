package LeetCode;

/**
 * @author Ling
 * Created on 2019/9/25
 */
public class MergeKLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//    // 分治
//    写乱了重新写
//    public ListNode mergeKLists(ListNode[] lists) {
//        return mergeKLists(lists,0,lists.length-1);
//    }
//
//    public ListNode mergeKLists(ListNode[] lists, int from ,int to){
//
//        if (lists.length==1){
//            return lists[0];
//        }
//
//        if (lists.length==2){
//            ListNode l1 = lists[0];
//            ListNode l2 = lists[1];
//            ListNode head = new ListNode(0);
//            ListNode cur = head;
//            while (l1!=null && l2!=null){
//                if (l1.val<=l2.val){
//                    cur.next=l1;
//                    cur=l1;
//                    l1=l1.next;
//                }else {
//                    cur.next=l2;
//                    cur=l2;
//                    l2=l2.next;
//                }
//            }
//            if (l1!=null)   cur.next=l1;
//            if (l2!=null)   cur.next=l2;
//            return head.next;
//        }
//
//        ListNode left = mergeKLists(lists, 0, lists.length/2);
//        ListNode right = mergeKLists(lists, lists.length/2+1, lists.length-1);
//        ListNode[] leftRight = {left, right};
//        return mergeKLists(leftRight,0,1);
//    }
//
//    public static void main(String[] args) {
//        MergeKLists m = new MergeKLists();
//
//    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0)   return null;
        return mergeKLists(lists,0,lists.length-1);
    }

    public ListNode mergeKLists(ListNode[] lists, int low, int hight) {
        if (low==hight) return lists[low];

        int mid = (low + hight) >> 1;
        ListNode left = mergeKLists(lists,low,mid);
        ListNode right = mergeKLists(lists,mid+1,hight);

        return merge(left,right);
    }

    public ListNode merge(ListNode left,ListNode right) {
        if (left==null) return right;
        if (right==null) return left;
        if (left.val<=right.val){
            left.next=merge(left.next,right);
            return left;
        } else {
            right.next = merge(left,right.next);
            return right;
        }
    }
}
