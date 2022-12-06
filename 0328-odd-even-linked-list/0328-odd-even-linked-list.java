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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode oddPtr = oddHead;
        ListNode evenPtr = evenHead;
        while(head!=null){
            ListNode temp = head;
            oddPtr.next = head;
            oddPtr = oddPtr.next;
            head = head.next;
            if(head!=null){
                evenPtr.next = head;
                head = head.next;
                evenPtr = evenPtr.next;
            }   
        }
        oddPtr.next = evenHead.next;
        evenPtr.next=null;
        return oddHead.next;
    }
}