class FindSumPairs {
    int nums1[];
    int nums2[];
    Map<Integer,Integer> count;
    public FindSumPairs(int[] nums1, int[] nums2) {
        count=new HashMap<>();
        this.nums1=nums1;
        this.nums2=nums2;
        for(int n:nums2){
            count.put(n,count.getOrDefault(n,0)+1);
        }
    }
    
    public void add(int index, int val) {
        int old=nums2[index];
        count.put(old,count.getOrDefault(old,0)-1);
        if(count.get(old)==0){
            count.remove(old);
        }
        nums2[index]+=val;
        int newVal=nums2[index];
        count.put(newVal,count.getOrDefault(newVal,0)+1);
    }
    
    public int count(int tot) {
        int countOfPairs=0;
        for(int n:nums1){
            int remainingPart=tot-n;
            countOfPairs += count.getOrDefault(remainingPart,0);
        }
        return countOfPairs;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */