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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode cur=head;
        ListNode prev=null;
        int index=1;
        while(index!=left){
            prev=cur;
            cur=cur.next;
            index++;
        }
        
        ListNode frontNodeInInput=prev;
        //reverse
        ListNode frontNodeInReversePart=cur;
        prev=null;
        while(index!=right+1){
            index++;
            ListNode t=cur.next;
            cur.next=prev;
            prev=cur;
            cur=t;
        }
        
        //join ends of reverse part;
        
        ListNode EndNodeInInput=cur;
        ListNode EndNodeInReversePart=prev;
        if(frontNodeInReversePart!=null){
            frontNodeInReversePart.next=EndNodeInInput;
        }
        
        
        if(frontNodeInInput!=null){
            frontNodeInInput.next=EndNodeInReversePart;
        }
        return frontNodeInInput== null?EndNodeInReversePart:head;
    }
}