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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s= new Stack<>();
        int res=-1;
        TreeNode cur=root;
        while(s.size()!=0 || cur!=null){
            while(cur!=null){
                s.push(cur);
                cur=cur.left;
            }
            if(cur==null){
                cur=s.pop();
            }
            k--;
            if(k==0){
                res=cur.val;
                break;
            }
            cur=cur.right;
        }
        return res;
    }
}