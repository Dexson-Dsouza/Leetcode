class Solution {
    public int[] findMode(TreeNode root) {
        int maxStreak = 0;
        int currStreak = 0;
        int currNum = 0;
        List<Integer> ans = new ArrayList();
        Stack<TreeNode> st=new Stack<>();
        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            System.out.println(curr.val);
            int num = curr.val;
            if (num == currNum) {
                currStreak++;
            } else {
                currStreak = 1;
                currNum = num;
            }

            if (currStreak > maxStreak) {
                ans = new ArrayList();
                maxStreak = currStreak;
            }

            if (currStreak == maxStreak) {
                ans.add(num);
            }

            curr = curr.right;
        }
        
        
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        
        return result;
    }
}