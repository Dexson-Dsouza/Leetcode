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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        List<Integer> nums=new ArrayList<>();
        ListNode cur=head;
        while(cur!=null){
            nums.add(cur.val);
            cur=cur.next;
        }
        return buildTree(nums,0,nums.size()-1);
    }
    
    public TreeNode buildTree(List<Integer> nums, int l, int r){
        if(l>r){
            return null;
        }
        int mid = l + (r-l)/2;
        TreeNode root=new TreeNode(nums.get(mid));
        root.left=buildTree(nums,l,mid-1);
        root.right=buildTree(nums,mid+1,r);
        return root;
    }
}