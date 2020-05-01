public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode res = new ListNode(-1);
        ListNode q = res;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                res.next = p1;
                p1 = p1.next;
            } else {
                res.next = p2;
                p2 = p2.next;
            }
            res = res.next;
        }
        // 优化点,将未完成的直接放在末尾
        res.next = p1 != null ? p1 : p2;
//        while (p1 != null) {
//            res.next = p1;
//            p1 = p1.next;
//            res = res.next;
//        }
//        while (p2 != null) {
//            res.next = p2;
//            p2 = p2.next;
//            res = res.next;
//        }
        return q.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);
        //l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
        //l2.next.next = new ListNode(4);

        ListNode res = new Solution().mergeTwoLists(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

