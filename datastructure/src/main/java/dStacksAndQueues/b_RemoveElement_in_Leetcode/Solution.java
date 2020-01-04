package dStacksAndQueues.b_RemoveElement_in_Leetcode;/// Leetcode 203. Remove Linked List Elements
/// https://leetcode.com/problems/remove-linked-list-elements/description/

// 没有虚拟头结点的写法
class Solution {

    public ListNode removeElements(ListNode head, int val) {

        while(head != null && head.val == val){ //删除头结点，用while 表示下一个结点还是val的话，继续删除
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if(head == null)
            return head;

        ListNode prev = head;  // 此时head一定不是要删除的结点了

        while(prev.next != null){  // 中间数据的部分，判断还有没有等于val值
            if(prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }
            else
                prev = prev.next;
        }

        return head;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head, 6);
        System.out.println(res);
    }
}