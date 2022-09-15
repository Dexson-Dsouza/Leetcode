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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)->a.val-b.val);
        
        
        for(int i=0;i<lists.length;i++){
            ListNode cur=lists[i];
            if(cur!=null){
                pq.add(cur);
            }
        }
        ListNode head=new ListNode(0);
        ListNode curNode=head;
        while(pq.size()>0){
            ListNode smallest=pq.poll();
            if(smallest.next!=null){
                pq.add(smallest.next);
            }
            smallest.next=null;
            curNode.next=smallest;
            curNode=smallest;
        }
        return head.next;
    }
}