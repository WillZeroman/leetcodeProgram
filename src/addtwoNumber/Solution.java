package addtwoNumber;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 时间复杂度：O(m) + O(n)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i = l1;
        ListNode j = l2;
        ListNode resHead = new ListNode(-1);
        ListNode resCur = resHead;
        int add = 0;
        while (i != null && j != null) {
            int tempRes = i.val + j.val + add;
            add = tempRes / 10;
            ListNode tempNode = new ListNode(tempRes % 10);
            resCur.next = tempNode;
            resCur = resCur.next;
            i = i.next;
            j = j.next;
        }

        while (i != null) {
            int tempRes = i.val + add;
            add = tempRes / 10;
            ListNode tempNode = new ListNode(tempRes % 10);
            resCur.next = tempNode;
            resCur = resCur.next;
            i = i.next;
        }

        while (j != null) {
            int tempRes = j.val + add;
            add = tempRes / 10;
            ListNode tempNode = new ListNode(tempRes % 10);
            resCur.next = tempNode;
            resCur = resCur.next;
            j = j.next;

        }
        if (add > 0) {
            ListNode tempNode = new ListNode(add);
            resCur.next = tempNode;
        }
        return resHead.next;
    }

    public void display(ListNode node) {
        ListNode cursor = node;
        while (cursor != null) {
            System.out.print(cursor.val);
            cursor = cursor.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node1 = s.new ListNode(2);
        node1.next = s.new ListNode(4);
        node1.next.next = s.new ListNode(3);
        s.display(node1);
        ListNode node2 = s.new ListNode(5);
        node2.next = s.new ListNode(6);
        //node2.next.next = s.new ListNode(4);
        s.display(node2);
        ListNode res = s.addTwoNumbers(node1, node2);
        s.display(res);
    }
}

