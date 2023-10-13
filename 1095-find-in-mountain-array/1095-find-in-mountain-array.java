/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 1;
        int len = mountainArr.length();
        int right = len-2;
        
        int peakIndex = left;
        while(left<=right){
            int mid = left+(right-left)/2;
            int midVal = mountainArr.get(mid);
            int nextVal = mountainArr.get(mid+1);
            if(nextVal>midVal){
                left=mid+1;
            }else{
                peakIndex = mid;
                right=mid-1;
            }
        }
        
        System.out.println(peakIndex);
        
        // search left slope
        left = 0;
        right = peakIndex;
        int index = len;
        while(left<=right){
            int mid = left+(right-left)/2;
            int midVal = mountainArr.get(mid);
            if(midVal==target){
                index = mid;
                right = mid-1;
            }else if(midVal<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        
        if(index!=len){
            return index;
        }
        // search right slope
        left = peakIndex;
        right = len - 1;
        while(left<=right){
            int mid = left+(right-left)/2;
            int midVal = mountainArr.get(mid);
            if(midVal==target){
                index = mid;
                right = mid-1;
            }else if(midVal<target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        if(index==len){
            index = -1;
        }
        
        return index;
    }   
}