package linkedList;

public class P206ReverseLinkedList {
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

    public static ListNode reverseList(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = null;
        ListNode node3 = null;
        if (node1 != null) {
            node2 = node1.next;
            node1.next = null;
        }
        if (node2 != null) {
            node3 = node2.next;
        }

        while (node3 != null) {
            node2.next = node1;
            node1 = node2;
            node2 = node3;
            node3 = node2.next;
        }
        if(node2 != null) {
            node2.next = node1;
            return node2;
        } else {
            return head;
        }
    }

    public static void printNode(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        System.out.println("Before reversing:");
        printNode(head);
        System.out.println("After reversing:");
        head = reverseList(head);
        printNode(head);
    }
}
