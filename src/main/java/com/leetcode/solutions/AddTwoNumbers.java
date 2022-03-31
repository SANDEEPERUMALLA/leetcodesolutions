package com.leetcode.solutions;

/*
    2. Add Two Numbers
    https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        int carry = 0;
        int sum = n1.val + n2.val + carry;
        int val = sum % 10;
        carry = sum / 10;
        ListNode head = new ListNode(val);
        ListNode last = head;
        n1 = n1.next;
        n2 = n2.next;
        while (n1 != null && n2 != null) {
            sum = n1.val + n2.val + carry;
            val = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(val);
            last = addNodeToList(last, node);
            n1 = n1.next;
            n2 = n2.next;
        }

        while (n1 != null) {
            sum = n1.val + carry;
            val = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(val);
            last = addNodeToList(last, node);
            n1 = n1.next;
        }

        while (n2 != null) {
            sum = n2.val + carry;
            val = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(val);
            last = addNodeToList(last, node);
            n2 = n2.next;
        }

        if(carry > 0) {
            last.next = new ListNode(carry);
        }

        return head;
    }

    public ListNode addNodeToList(ListNode last, ListNode newNode) {
        last.next = newNode;
        return newNode;
    }

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode n1 = solution.createList(2, 4, 3);
        ListNode n2 = solution.createList(2, 4, 3);
        ListNode result = solution.addTwoNumbers(n1, n2);
        solution.print(result);

        n1 = solution.createList(2, 4, 3);
        n2 = solution.createList(5, 6, 4);
        result = solution.addTwoNumbers(n1, n2);
        solution.print(result);
    }

    private ListNode createList(int ... nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode last = head;
        for(int i=1;i<nums.length;i++) {
            ListNode node = new ListNode(nums[i]);
            last = addNodeToList(last, node);
        }
        return head;
    }

    private static class ListNode {
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

    public void print(ListNode head) {
        ListNode n = head;
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
    }
}
