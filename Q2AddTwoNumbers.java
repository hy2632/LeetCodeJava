import java.util.Arrays;
import java.math.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public static int[] ListToArray(ListNode l){
        ListNode node = l;
        int len = 1;
        while(node.next instanceof ListNode){
            len += 1;
            node = node.next;
        }
        node = l;
        int[] array = new int[len];
        int idx = 0; //从结尾开始
        while(node.next instanceof ListNode){
            array[idx] = node.val;
            idx += 1;
            node = node.next;
        }
        array[idx] = node.val;
        return array;
    }


    // public static int ListToNumber(ListNode l){
    //     ListNode node = l;
    //     int len = 1;
    //     while(node.next instanceof ListNode){
    //         len += 1;
    //         node = node.next;
    //     }
    //     node = l;
    //     int idx = 0; //从结尾开始
    //     int sum = 0; 
    //     while(node.next instanceof ListNode){
    //         sum += node.val * Math.pow(10, idx);
    //         idx += 1;
    //         node = node.next;
    //     }
    //     sum += node.val * Math.pow(10, idx);
    //     return sum;
    // }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        return l3;
    }
}



public class Q2AddTwoNumbers {
    public static void main(String[] args) {

        // ListNode l1 = new ListNode(2);
        // l1 = new ListNode(4, l1);
        // l1 = new ListNode(3, l1);
        // ListNode l2 = new ListNode(5);
        // l2 = new ListNode(6, l2);
        // l2 = new ListNode(4, l2);


        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l2 = new ListNode(9,l2);
        l2 = new ListNode(9,l2);
        l2 = new ListNode(9,l2);
        l2 = new ListNode(9,l2);
        l2 = new ListNode(9,l2);
        l2 = new ListNode(9,l2);
        l2 = new ListNode(9,l2);
        l2 = new ListNode(9,l2);
        l2 = new ListNode(9,l2);


// 直接加法，大数爆了。
// ===================================================================
        // int sum1 = Solution.ListToNumber(l1);
        // int sum2 = Solution.ListToNumber(l2);
        // int sum3 = sum1 + sum2;
        // System.out.println(sum1);
        // System.out.println(sum2);

        // // 确定长度
        // int temp = sum3;
        // int digit_ct = 1;
        // while (temp/10>0){
        //     digit_ct ++;
        //     temp /= 10;
        // }
        
        // // 颠倒数位存入数组
        // int[] sum3_rev = new int[digit_ct];
        // int idx = 0;
        // while(sum3 / 10 > 0){
        //     sum3_rev[idx] = sum3  % 10;
        //     sum3 /= 10;
        //     idx ++; 
        // }
        // sum3_rev[idx] = sum3  % 10;
        // // System.out.println(Arrays.toString(sum3_rev));

        // idx = digit_ct-1;
        // int digit = sum3_rev[idx];
        // ListNode l3 = new ListNode(digit);
        // idx --;
        // while (idx >-1){
        //     digit = sum3_rev[idx];
        //     l3 = new ListNode(digit, l3);
        //     idx--;
        // }

        // sum3 = Solution.ListToNumber(l3);
        // System.out.println(sum3);
// ===================================================================

// 换思路，数组实现大数加法。
        int [] array1 = Solution.ListToArray(l1);
        int [] array2 = Solution.ListToArray(l2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        int len_array1 = array1.length;
        int len_array2 = array2.length;
        // 数组倒序
        int [] array1_rev = new int[len_array1];
        int [] array2_rev = new int[len_array2];
        int cur_digit = 0;
        for (cur_digit=0;cur_digit<len_array1;cur_digit++){
            array1_rev[cur_digit] = array1[len_array1-1-cur_digit];
        }
        cur_digit = 0;
        for (cur_digit=0;cur_digit<len_array2;cur_digit++){
            array2_rev[cur_digit] = array2[len_array2-1-cur_digit];
        }

        int len_array3 = Math.max(len_array1, len_array2) + 1;
        int [] array3 = new int[len_array3];
        
        // 当前位，从个位开始
        cur_digit = 0;
        int sum_by_digit = 0;
        int unit_value = 0;
        int ten_value = 0;
        while(cur_digit<len_array3){
            sum_by_digit = 0;
            if(cur_digit<len_array1){
                sum_by_digit += array1_rev[len_array1-1-cur_digit];
            }
            if(cur_digit<len_array2){
                sum_by_digit += array2_rev[len_array2-1-cur_digit];
            }
            unit_value = sum_by_digit %10;
            ten_value = sum_by_digit /10;
            array3[len_array3 -1 - cur_digit] += unit_value;
            if (ten_value == 1){
                array3[len_array3 -2 - cur_digit] += ten_value;
            }
            if(array3[len_array3 -1 - cur_digit] >= 10){
                array3[len_array3 -1 - cur_digit] -= 10;
                array3[len_array3 -2 - cur_digit] += 1;
            }
            cur_digit ++;
        }
        
        // 如果开头有冗余位就去掉,同时len_array3-1
        if(array3[0] == 0){
            array3 = Arrays.copyOfRange(array3, 1, len_array3);
            len_array3 --;
        }

        
        // array3目前是反序的，数组第一个值是链表最后一个
        int idx = 0;
        int cur_value = array3[idx];
        ListNode l3 = new ListNode(cur_value);
        idx ++;
        while (idx <len_array3){
            cur_value = array3[idx];
            l3 = new ListNode(cur_value, l3);
            idx++;
        }

        array3 = Solution.ListToArray(l3);
        System.out.println(Arrays.toString(array3));
    }
}