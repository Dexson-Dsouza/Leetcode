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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestList = new ArrayList<>();
        Queue<TreeNode> currentLevelNodes = new LinkedList<>();
        
        if(root!=null){
            currentLevelNodes.add(root);
        }
        
        while(currentLevelNodes.size()>0){
            int curMax = Integer.MIN_VALUE;
            int levelSize = currentLevelNodes.size();
            for(int i=0;i<levelSize;i++){
                TreeNode curNode = currentLevelNodes.poll();
                curMax = Math.max(curMax,curNode.val);
                
                if(curNode.left!=null){
                    currentLevelNodes.add(curNode.left);
                }
                if(curNode.right!=null){
                    currentLevelNodes.add(curNode.right);
                }
            }
            largestList.add(curMax);
        }
        return largestList;
    }
}