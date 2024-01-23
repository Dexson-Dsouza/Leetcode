class Solution {
    public int maxAncestorDiff(TreeNode root) {
        if(root==null){
            return 0;
        }
        return maxDiff(root,root.val,root.val);
    }
	int maxDiff(TreeNode root, int max_so_far, int min_so_far){
		if(root==null){
			return 0;
}
int cur_diff = Math.max(
Math.abs(max_so_far-root.val),
 Math.abs(root.val - min_so_far)
);

		max_so_far = Math.max(max_so_far,root.val);
		min_so_far= Math.min(min_so_far,root.val);

int max_diff_left = maxDiff(root.left,max_so_far,min_so_far);
int max_diff_right = maxDiff(root.right,max_so_far,min_so_far);
int max_diff_children = Math.max(max_diff_left,max_diff_right);
return Math.max(max_diff_children,cur_diff);
}
}
