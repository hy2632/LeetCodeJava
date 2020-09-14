public class NowCoder_DetectCycle {
    public static ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        ListNode meetpoint = null;
        while(ptr1 != null && ptr1.next != null){
            ptr1 = ptr1.next.next;
            ptr2 = ptr2.next;
            if (ptr2 == ptr1){
                meetpoint = ptr1;
                break;
            }
        }
        if (meetpoint == null) return null;
        // 快指针从头出发，慢指针接着走
        ptr1 = head;
        while(ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    public static void main(String[] args){
        ListNode l1 = ListNode.fromArray(new int[]{1,3,5,7,9});
        l1.next.next.next.next.next = l1.next.next;
        ListNode l2 = new ListNode(1);
        System.out.println(detectCycle(l2).val);
    }
}
