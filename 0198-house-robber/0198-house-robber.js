/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    let houseCount = nums.length;
    let profitArray = new Array(houseCount).fill(0);
    for(let i = 0; i<houseCount ;i++){
        let prevProfit = i>0? profitArray[i-1]:0;
        let curProfit = nums[i];
        if(i-2 >= 0){
            curProfit += profitArray[i-2];
        }
        profitArray[i] = Math.max(prevProfit,curProfit);
    }
    return profitArray[houseCount-1];
};