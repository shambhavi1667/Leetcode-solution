class Solution {
    public int maxProduct(int[] nums) {

        int currentMax = nums[0];
        int currentMin = nums[0];
        int overallMax = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int x = nums[i];

            // store previous max before updating
            int prevMax = currentMax;

            // compute new max and min
            currentMax = Math.max(x, Math.max(prevMax * x, currentMin * x));
            currentMin = Math.min(x, Math.min(prevMax * x, currentMin * x));

            // update global answer
            overallMax = Math.max(overallMax, currentMax);
        }

        return overallMax;
    }
}