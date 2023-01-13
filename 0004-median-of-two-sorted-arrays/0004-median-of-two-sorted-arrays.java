class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int total = l1 + l2;
        int m1 = (total)/2;
        int m2 = total%2==1?((total)/2):(total-1)/2;
        double mid1 = find(nums1,nums2,0,0,m1+1);
        double mid2 = find(nums1,nums2,0,0,m2+1);
        // System.out.println((m1+1)+" "+mid1+" "+(m2+1)+" "+mid2);
        return (mid1+mid2)/2;
    }
    
    public double find(int[] nums1, int[] nums2, int i1, int i2, int m){
        // System.out.println(i1+" "+i2+" "+m);
        if(i1==nums1.length){
            return nums2[i2+m-1];
        }
        if(i2==nums2.length){
            return nums1[i1+m-1];
        }
        if(m == 1){
            return Math.min(nums1[i1],nums2[i2]);
        }
        int mid1 = Integer.MAX_VALUE;
        int midIndex1= i1+m/2-1;
        if(midIndex1<nums1.length){
            mid1 = nums1[midIndex1];
        }
        int mid2 = Integer.MAX_VALUE;
        int midIndex2= i2+m/2-1;
        if(midIndex2<nums2.length){
            mid2 = nums2[midIndex2];
        }
        if(mid1<=mid2){
            return find(nums1,nums2,midIndex1+1,i2,m - m/2);
        }else{
            return find(nums1,nums2,i1,midIndex2+1,m - m/2);
        }
    }
}