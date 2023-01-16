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
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        Set<Integer> nums = new HashSet<>();
        Set<Integer> duplicates =new HashSet<>();
        ListNode temp = head;
        while(head!=null){
            if(nums.contains(head.val)==false){
                nums.add(head.val);
                head=head.next;
            }else{
                duplicates.add(head.val);
                head = head.next;
            }
        }
        
        while(temp!=null){
            if(duplicates.contains(temp.val)==false){
                cur.next =  temp;
                cur = temp;
                temp = temp.next;
                cur.next = null;
            }else{
                temp = temp.next;
            }
        }
        
        return newHead.next;
    }
}