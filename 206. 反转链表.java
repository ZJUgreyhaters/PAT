/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode h = null, tmp;
        
        while(head.next!=null){
            tmp = head;
            head = head.next;
            tmp.next = h;
            h = tmp;
        }
        head.next = h;
        return head;
    }
}