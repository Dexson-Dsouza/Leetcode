class Solution {
    public static int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    int index = -1;
    while (l <= r) {
        
      int mid = l + (r - l) / 2;
        // System.out.println(l+" "+r +" "+mid);
      if (nums[l] <= nums[mid]) {
        if (nums[l] <= target && nums[mid] >= target) {
          r = mid - 1;
          if (nums[mid] == target) {
            index = mid;
            break;
          }
        } else {
          l = mid + 1;
        }
      } else {
        if (nums[mid] <= target && nums[r] >= target) {
          l = mid + 1;
          if (nums[mid] == target) {
            index = mid;
            break;
          }
        } else {
          r = mid - 1;
        }
      }
    }
    return index;
  }
}