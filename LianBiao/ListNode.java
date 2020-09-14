import java.util.Arrays;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode fromArray(int[] arr){
        if (arr.length == 0) return null;
        
        int val = arr[0];
        ListNode head = new ListNode(val);
        ListNode result = head;
        for (int i = 1; i < arr.length; i++){
            ListNode curr = new ListNode(arr[i]);
            head.next = curr;
            head = head.next;
        }
        return result;
    }

    public static int[] toArray(ListNode l){
        if (l == null) return new int[]{};
        
        int[] arr = {};
        while (l != null){
            arr = Arrays.copyOf(arr, arr.length + 1);
            arr[arr.length - 1] = l.val;
            l = l.next;
        }
        return arr;
    }
}
