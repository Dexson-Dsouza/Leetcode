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
        TreeNode cur=root;
        Stack<TreeNode> nodes=new Stack<>();
        int val = -1;
        while(nodes.size()>0 || cur!=null){
            while(cur!=null){
                nodes.push(cur);
                cur=cur.left;
            }
            cur = nodes.pop();
            if(k==1){
                val = cur.val;
                break;
            }
            k--;
            cur = cur.right;
        }
        return val;
    }
}