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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> leftTree=new Stack<>();
        Stack<TreeNode> rightTree=new Stack<>();
        leftTree.push(p);
        rightTree.push(q);
        
        while(rightTree.size()>0 && leftTree.size()>0){
           
            TreeNode l = leftTree.pop();
            TreeNode r = rightTree.pop();
            if(l==null && r==null){
                continue;
            }
            if(l==null || r==null || l.val !=r.val){
                return false;
            }
            
            if(l.left!=null || r.left!=null){
                leftTree.push(l.left);
                rightTree.push(r.left);
            }
            if(l.right!=null || r.right!=null){
                leftTree.push(l.right);
                rightTree.push(r.right);
            }
        }
        return rightTree.size()==0 && leftTree.size()==0;
    }
}