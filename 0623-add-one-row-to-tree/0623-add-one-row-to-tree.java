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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newRoot=new TreeNode(val);
            newRoot.left=root;
            return newRoot;
        }
        return addRow(null,root,val,1,depth);
    }
    
    TreeNode addRow(TreeNode par, TreeNode cur, int val, int depth,int target) {
        if(cur==null || depth<0){
            return cur;
        }
        if(depth==target-1){
            TreeNode newLeftNode=new TreeNode(val);
            TreeNode newRightNode=new TreeNode(val);
            newLeftNode.left=cur.left;
            cur.left=newLeftNode;
            newRightNode.right=cur.right;
            cur.right=newRightNode;
        }
        if(depth<target){
            cur.left=addRow(cur,cur.left,val,depth+1,target);
            cur.right=addRow(cur,cur.right,val,depth+1,target);
        }
        return cur;
        
    }
}