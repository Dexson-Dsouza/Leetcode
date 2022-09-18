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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        int maxLen=0;
        Stack<TreeNode> curNodes=new Stack();
        Map<TreeNode,Integer> maxPathLen=new HashMap<>();
        curNodes.push(root);
        
        while(curNodes.size()>0){
            TreeNode curNode=curNodes.peek();
            TreeNode leftChild=curNode.left;
            TreeNode rightChild=curNode.right;
            if(leftChild!=null && maxPathLen.containsKey(leftChild)==false){
                curNodes.push(leftChild);
            }else if(rightChild!=null && maxPathLen.containsKey(rightChild)==false){
                curNodes.push(rightChild);
            }else{
                curNodes.pop();
                int leftLen=maxPathLen.getOrDefault(leftChild,0);
                int rightLen=maxPathLen.getOrDefault(rightChild,0);
                int curMax=Math.max(leftLen,rightLen);
                maxLen=Math.max(maxLen,leftLen+rightLen);
                maxPathLen.put(curNode,curMax+1);
            }
        }
        return maxLen;
    }
}