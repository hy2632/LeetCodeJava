import java.util.*;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class LC19 {
    // Brutal force 两遍遍历暴力解法
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int ListNodeLength = getListNodeLength(head);

        // Special case: null
        if (ListNodeLength == 0)
            return head;

        // Special case: out of index / delete head
        if (ListNodeLength < n)
            return head;
        else if (ListNodeLength == n)
            return head.next;

        // Normal case: delete other nodes
        ListNode curr = head;
        ListNode result = curr;
        int count = 0;

        while (count < ListNodeLength - n - 1) {
            curr = curr.next;
            count++;
        }

        curr.next = curr.next.next;
        return result;
    }

    public static int getListNodeLength(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }

    // 快慢指针
    public static ListNode removeNthFromEnd_Variant(ListNode head, int n) {
        if (head == null)
            return head;

        ListNode fast = head, slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 判别: 删除头节点
        if (fast == null)
            return head.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.fromArray(new int[] { 1, 2, 3, 4, 5 });
        ListNode l2 = ListNode.fromArray(new int[] { 1 });
        System.out.println(Arrays.toString(ListNode.toArray(removeNthFromEnd_Variant(l1, 2))));
        System.out.println(Arrays.toString(ListNode.toArray(removeNthFromEnd_Variant(l2, 1))));

    }
}