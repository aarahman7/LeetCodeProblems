package linkedList;

import java.util.List;

public class P2AddTwoNumbers {

    public static class ListNode {
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

//    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
//        int sum = 0;
//        if(l1 != null) {
//            sum = l1.val;
//        }
//        if(l2 != null) {
//            sum += l2.val;
//        }
//        ListNode ans = new ListNode();
//        ans.val = sum % 10;
////        ans.next = sum / 10 + addTwoNumbers2(l1.next, l2.next);
//    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode head = ans;
        while (l1 != null && l2 != null) {
            if (ans == null) {
                ans = new ListNode();
            }
            int sum = ans.val + l1.val + l2.val;
            ans.val = sum % 10;
            l1 = l1.next;
            l2 = l2.next;
            if (sum / 10 != 0) {
                ans.next = new ListNode(sum / 10);
            }
            ans = ans.next;
        }

        while(l1 != null) {
            if(ans == null) {
                ans = new ListNode();
            }
            ans.val = l1.val;
            l1 = l1.next;
            ans = ans.next;
        }

        while(l2 != null) {
            if(ans == null) {
                ans = new ListNode();
            }
            ans.val = l2.val;
            l2 = l2.next;
            ans = ans.next;
        }

        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode ln2 = new ListNode(2);
        ListNode ln4 = new ListNode(4);
        ListNode ln3 = new ListNode(3);
        ln2.next = ln4;
        ln4.next = ln3;

        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        ListNode lns4 = new ListNode(4);
        ln5.next = ln6;
        ln6.next = lns4;

        addTwoNumbers(ln2,ln5);
    }
}
