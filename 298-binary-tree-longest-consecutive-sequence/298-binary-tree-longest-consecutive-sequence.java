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
    public int longestConsecutive(TreeNode root) {
        if(root==null){
            return 0;
        }
        int[] routes=new int[1];
        findLongestPath(root,routes,root.val,0);
        return routes[0];
    }
    
    public void findLongestPath(TreeNode root, int[] routes, int val, int curLen){
        if(root==null){
            return;
        }
        if(val==root.val){
            curLen++;
        }else{
            val=root.val;
            curLen=1;
        }
        routes[0]=Math.max(routes[0],curLen);
        findLongestPath(root.left,routes,val+1,curLen);
        findLongestPath(root.right,routes,val+1,curLen);
    }
}