import java.util.Arrays;

public class NowCode_FindFirstCommonNode {
    
    public static void main(String[] args){
        ListNode l1 = ListNode.fromArray(new int[]{1,3,5,7});
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = l1;
        System.out.println(Arrays.toString(ListNode.toArray(l1)));
        System.out.println(Arrays.toString(ListNode.toArray(l2)));

        ListNode common = FindFirstCommonNode(l1, l2);
        System.out.println(common.val);
    }
    
    // // 解法：截取长度并依次比较。复杂度O(m+n)
    // public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    //     ListNode p1 = pHead1;
    //     ListNode p2 = pHead2;
    //     int len1 = 0, len2 = 0;

    //     while (p1 != null){
    //         p1 = p1.next;
    //         len1++;
    //     }
    //     while (p2 != null){
    //         p2 = p2.next;
    //         len2++;
    //     }

    //     if (len1 >= len2){
    //         for(int i = 0; i < len1 - len2; i++){
    //             pHead1 = pHead1.next;
    //         }
    //     } else {
    //         for(int i = 0; i < len2 - len1; i++){
    //             pHead2 = pHead2.next;
    //         }
    //     }
    //     while (pHead1 != pHead2){
    //         pHead1 = pHead1.next;
    //         pHead2 = pHead2.next;
    //     }
    //     return pHead1;
    // }


    // 两个链表连接成环找环入口，再把环断开
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;

        ListNode curr = pHead1;
        while (curr.next != null) curr = curr.next;
        curr.next = pHead2;
        // 把两个链表接起来找第一个

        ListNode firstCommon = detectCycle(pHead1);
        // 断开两个链表
        curr.next = null;
        return firstCommon;
    }

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

}
