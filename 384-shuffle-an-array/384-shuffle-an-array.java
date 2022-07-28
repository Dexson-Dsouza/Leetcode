class Solution {
    int[] arr;
    int[] nums;
    public Solution(int[] nums) {
        arr=nums.clone();
        this.nums=nums;
    }
    
    public int[] reset() {
        arr=nums.clone();
        return arr;
    }
    
    public int[] shuffle() {
        for(int i=0;i<arr.length;i++){
            int randIndex=i+(int)(Math.random()*(arr.length-i));
            int t=arr[randIndex];
            arr[randIndex]=arr[i];
            arr[i]=t;
        }
        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */