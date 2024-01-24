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
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] count=new int[10];
        return find_pal_paths(root,count);
    }
    
    public int find_pal_paths( TreeNode root, int[] count){
        if(root==null){
            return 1;
        }
        
        count[root.val]++;
        if(root.left==null && root.right==null){
            int path_count=can_make_pal(count);
            count[root.val]--;
            return path_count;
        }
        int left_route_count = 0;
        if(root.left!=null){
            left_route_count = find_pal_paths(root.left,count);
        }
        int right_route_count = 0;
        if(root.right!=null){
            right_route_count = find_pal_paths(root.right,count);
        }
        count[root.val]--;
        return left_route_count+right_route_count;
    }
    
    public int can_make_pal(int[] count){
        int odd_count=0;
        for(int i=1;i<=9;i++){
            if(count[i]%2==1){
                odd_count++;
            }
        }
        return odd_count>1?0:1;
    }
}