/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    let houseCount = nums.length;
    const profitMap = new Map();
    for(let i = 0; i<houseCount ;i++){
        let prevProfit = profitMap.get(i-1)?profitMap.get(i-1):0;
        let curProfit = nums[i]+(profitMap.get(i-2)?profitMap.get(i-2):0);
        
        profitMap.set(i,Math.max(curProfit,prevProfit));
    }
    return profitMap.get(houseCount-1);
};