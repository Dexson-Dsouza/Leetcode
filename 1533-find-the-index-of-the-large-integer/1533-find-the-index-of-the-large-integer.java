/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        return findIndex(0,reader.length()-1,reader);
    }
    
    public int findIndex(int l, int r, ArrayReader reader){
        if(l==r){
            return l;
        }
        int len = r-l+1;
        int mid = l+(r-l)/2;
        int nextMid = len%2==1?mid:mid+1;
        int compareResult = reader.compareSub(l,mid,nextMid,r);
        if(compareResult>0){
            return findIndex(l,mid,reader);
        }else if(compareResult<0){
            return findIndex(mid+1,r,reader);
        }else{
            return mid;
        }
    }
}