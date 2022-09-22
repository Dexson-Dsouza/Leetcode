class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len=nums1.length+nums2.length;
        
        int k1 = len/2 + 1;
        int k2 = len%2==1?k1:k1-1;
        
        double kthELement = getKth(nums1,nums2,0,0,k1);
        double nextkthELement = getKth(nums1,nums2,0,0,k2);
        return (kthELement+nextkthELement)/2;
    }
    
    double getKth(int[] nums1, int[] nums2, int start1, int start2, int k){
        if(start1==nums1.length){
            return nums2[start2+k-1];
        }
        if(start2==nums2.length){
            return nums1[start1+k-1];
        }
        
        if(k==1){
            return Math.min(nums1[start1],nums2[start2]);
        }
        int mid1 = start1 + k/2 -1;
        int firstMid = mid1<nums1.length?nums1[mid1]:Integer.MAX_VALUE;
        int mid2 = start2 + k/2 -1;
        int secondMid = mid2<nums2.length?nums2[mid2]:Integer.MAX_VALUE;
        if(firstMid<secondMid){
            return getKth(nums1,nums2,start1+k/2,start2,k-k/2);
        }else{
            return getKth(nums1,nums2,start1,start2+k/2,k-k/2);
        }
    }
}