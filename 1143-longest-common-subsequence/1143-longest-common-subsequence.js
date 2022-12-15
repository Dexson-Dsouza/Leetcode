/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function(text1, text2) {
    let l1 = text1.length;
    let l2 = text2.length;
    let dp = new Array();
    for(let i = 0; i<=l1;i++){
        dp.push(new Array(l2+1).fill(0));
    }
    
    for(let i=0;i<l1;i++){
        for(let j=0;j<l2;j++){
            if(text1[i]==text2[j]){
                dp[i+1][j+1]=1+dp[i][j];
            }else{
                dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
    }
    return dp[l1][l2];
};