class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                if (root.left != null) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }else{
                TreeNode node = stack.pop();
                res.add(node.val);
                if (!stack.isEmpty() && stack.peek().left == node) {
                    root = stack.peek().right;
                }
            }
        }
        return res;
    }
    
}