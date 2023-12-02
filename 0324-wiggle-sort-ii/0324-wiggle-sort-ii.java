class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length, m = n/2;
        int[] copy = Arrays.copyOf(nums, n);
        int median = kthSmallestNumber(nums, m);
        for (int i = 0, j = 0, k = n - 1; j <= k;) {
            if (copy[j] < median) {
                swap(copy, i++, j++);
            } else if (copy[j] > median) {
                swap(copy, j, k--);
            } else {
                j++;
            }
        }
        
        int j = Math.min(1,nums.length-1);
        
        for (int i = n - 1; i >= m; i--){            
            nums[j] = copy[i];
            j += 2;
            if(j>=nums.length){
                j=0;
            }
        }
        for (int i = m - 1; i >= 0; i--){ 
            nums[j] = copy[i];
            j += 2;
            if(j>=nums.length){
                j=0;
            }
        }
        
    }

    private int kthSmallestNumber(int[] nums, int k) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int m = getMiddle(nums, l, r);

            if (m < k) {
                l = m + 1;
            } else if (m > k) {
                r = m - 1;
            } else {
                break;
            }
        }

        return nums[k];
    }

    private int getMiddle(int[] nums, int l, int r) {
        int i = l;
        int pivot = nums[l];
        for (int j = l + 1; j <= r; j++) {
            if (nums[j] < pivot) swap(nums, i++, j);
        }

        nums[i]=pivot;
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}