package self.leetcode;

/**
 * Leetcode2
 *
 * 递归解法：时间复杂度O(N)， 空间复杂度O(N)
 *  -- leetcode:
 *          执行耗时:2 ms,击败了100.00% 的Java用户
 *          内存消耗:38.9 MB,击败了45.75% 的Java用户
 *
 * @author chenzb
 * @date 2021/4/16
 */
public class Leetcode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int plusVal) {
        ListNode node = new ListNode();
        if (l1 == null && l2 == null && plusVal == 0) {
            return null;
        }
        if (l1 != null) {
            plusVal += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            plusVal += l2.val;
            l2 = l2.next;
        }
        node.val = plusVal % 10;
        node.next = addTwoNumbers(l1, l2, plusVal / 10);
        return node;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return val + (next == null ? "" : ", " +  next);
        }
    }

    public static void main(String[] args) {
        Leetcode2 leetcode = new Leetcode2();
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode result = leetcode.addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}
