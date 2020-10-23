import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class NC70 {
    public ListNode sortInList (ListNode head) {
        // write code here
        ListNode sentinel;
        sentinel.next = head;

        int min = head.val;
        ListNode curr = head;
        ListNode minNode = head;
        while (curr != null){
            curr = curr.next;
            if (curr.val < min){
                min = curr.val;
                minNode = curr;
            }
        }

    }
}
