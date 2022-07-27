class Solution {
    public int countHousePlacements(int n) {
        int arr[]=new int[n+1];
        arr[0]=1;
        arr[1]=2;
        int mod=(int)(Math.pow(10,9)+7);
        for(int i=2;i<=n;i++){
            arr[i]=(arr[i-1]+arr[i-2])%mod;
        }
        return (int)(((long)(arr[n])*arr[n])%mod);
    }
}