class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currMax = nums[0];
        int maxSum = nums[0];
        int currMin = nums[0];
        int minSum = nums[0];

        for(int i=1; i<nums.length; i++){
            currMax = Math.max(nums[i], currMax+nums[i]);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(nums[i], currMin+nums[i]);
            minSum = Math.min(minSum, currMin);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }
}