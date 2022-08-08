class Solution {
    public int minMoves2(int[] nums) {
        int mid=quickSelectMedian(nums,0,nums.length-1,nums.length/2);
        // System.out.println(mid);
        int moves=0;
        for(int n:nums){
            // System.out.println(n);
            moves+=Math.abs(n-mid);
        }
        return moves;
    }
    
    int quickSelectMedian(int[] nums, int left, int right, int mid){
        if(left==right){
            return nums[left];
        }
        
        int randomPivotIndex= (int)(Math.random()*(right-left+1)+left);
        
        int partitionIndex = partition(nums,left,right,randomPivotIndex);
        if(partitionIndex==mid){
            return nums[partitionIndex];
        }
        if(partitionIndex<mid){
            return quickSelectMedian(nums,partitionIndex+1,right,mid);
        }else{
            return quickSelectMedian(nums,left,partitionIndex-1,mid);
        }
    }
    
    void swap(int[] arr, int left, int right){
        int t=arr[left];
        arr[left]=arr[right];
        arr[right]=t;
    }
    
    int partition(int[] nums, int left, int right, int pIndex){
        int pivot=nums[pIndex];
        swap(nums,pIndex,right);
        
        int start=left;
        for(int i=left;i<=right;i++){
            if(nums[i]<=pivot){
                swap(nums,start,i);
                start++;
            }
        }
        return start-1;
    }
}