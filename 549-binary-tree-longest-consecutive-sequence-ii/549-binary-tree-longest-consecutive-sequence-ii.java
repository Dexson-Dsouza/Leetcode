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
        int[] result=new int[3];
        findLongest(root,result);
        return result[2];
    }
    
    void findLongest(TreeNode root, int[] result){
        if(root==null){
            return;
        }
        
        int curValue=root.val;
        
        int increasingLen=1;
        int decreasingLen=1;
        
        
        if(root.left!=null){
            findLongest(root.left,result);
            if(root.left.val+1==curValue){
                increasingLen=Math.max(increasingLen,1+result[0]);
            }
            if(root.left.val-1==curValue){
                decreasingLen=Math.max(decreasingLen,1+result[1]);
            }
        }
        
        if(root.right!=null){
            findLongest(root.right,result);
            if(root.right.val+1==curValue){
                increasingLen=Math.max(increasingLen,1+result[0]);
            }
            if(root.right.val-1==curValue){
                decreasingLen=Math.max(decreasingLen,1+result[1]);
            }
        }
        
        result[0]=increasingLen;
        result[1]=decreasingLen;
        result[2]=Math.max(result[2],Math.max(increasingLen,decreasingLen));
        
        if(root.left!=null && root.right!=null){
            if(root.left.val+1==curValue && root.right.val-1==curValue){
                result[2]=Math.max(result[2],increasingLen+decreasingLen-1);
            }
            if(root.left.val-1==curValue && root.right.val+1==curValue){
                result[2]=Math.max(result[2],increasingLen+decreasingLen-1);
            }
        }
    }
}