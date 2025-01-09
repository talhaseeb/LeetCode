/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    const res = new Map();
    for (let i=0; i< nums.length; i++) {
        const diff = target - nums[i]
        if(res.has(diff)) {
            return [res.get(diff), i];
        }
        res.set(nums[i], i)
    }
};