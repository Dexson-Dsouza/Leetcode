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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Set<Integer> numSet = new HashSet<>();
        Set<Integer> duplicateSet = new HashSet<>();
        
        ListNode ptr1 = head;
        
        ListNode head2 = new ListNode(-1);
        ListNode ptr2 = head2;
        
        while(ptr1!=null){
            if(numSet.contains(ptr1.val)==false){
                numSet.add(ptr1.val);
                ptr1=ptr1.next;
            }else{
                duplicateSet.add(ptr1.val);
                ptr1 = ptr1.next;
            }
        }
        
        ptr1 = head;
        while(ptr1!=null){
            if(duplicateSet.contains(ptr1.val)==false){
                ptr2.next = ptr1;
                ptr1=ptr1.next;
                ptr2 = ptr2.next;
                ptr2.next=null;
            }else{
                ptr1=ptr1.next;
            }
        }
        
        return head2.next;
    }
}