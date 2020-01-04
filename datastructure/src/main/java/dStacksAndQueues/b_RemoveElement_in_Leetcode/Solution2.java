package dStacksAndQueues.b_RemoveElement_in_Leetcode;/// Leetcode 203. Remove Linked List Elements
/// https://leetcode.com/problems/remove-linked-list-elements/description/

// 没有虚拟头结点的做法【头尾判断】
class Solution2 {

    public ListNode removeElements(ListNode head, int val) {

        while(head != null && head.val == val)  //第一个值就是
            head = head.next;

        if(head == null) // 没有值
            return head;

        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }

        return head;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution2()).removeElements(head, 6);
        System.out.println(res);
    }
}