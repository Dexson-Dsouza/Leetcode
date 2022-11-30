/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortLinkedList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        
        while(cur!=null){
            if(cur.val < head.val || (prev!=null && cur.val < prev.val)){
                prev.next=cur.next;
                ListNode temp = cur.next;
                cur.next=head;
                head=cur;
                cur=temp;
            }else{
                prev=cur;
                cur=cur.next;
            }
        }
        return head;
    }
}