class Solution {
    public int search(int[] arr, int target) {
        int l=0;
        int r=arr.length-1;
        
        
        while(l<=r){
            int mid=(l+r)/2;
            
            if(arr[mid]==target){
                return mid;
            }
            
            if(arr[mid]<arr[r]){
                if(target<=arr[r] && target>arr[mid]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
                
            }else{
                if(target<arr[mid] && target>=arr[l]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }
            
        }
        return -1;
    }
}