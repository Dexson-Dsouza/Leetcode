class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int leftMed= (n1+n2+1)/2;
        int rightMed= (n1+n2+2)/2;
        // System.out.println((double)getMedian(nums1,0,nums2,0,leftMed)+" "+(double)getMedian(nums1,0,nums2,0,rightMed));
        return ((double)getMedian(nums1,0,nums2,0,leftMed)+(double)getMedian(nums1,0,nums2,0,rightMed))/2;
    }
    
    double getMedian(int a[], int aStart, int[] b, int bStart, int k){
        if(aStart>=a.length){
            return b[bStart+k-1];
        }
        if(bStart>=b.length){
            return a[aStart+k-1];
        }
        
        if(k==1){
            return Math.min(a[aStart],b[bStart]);
        }
        int aMidIndex= aStart + k/2 -1;
        int aMid =  aMidIndex < a.length? a[aMidIndex]:Integer.MAX_VALUE;
        int bMidIndex= bStart + k/2 -1;
        int bMid =  bMidIndex < b.length? b[bMidIndex]:Integer.MAX_VALUE;
        if(aMid<bMid){
            return getMedian(a,aStart+k/2,b,bStart,k-k/2);
        }else{
            return getMedian(a,aStart,b,bStart+k/2,k-k/2);
        }
    }
}