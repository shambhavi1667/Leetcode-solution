class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int j = k-1;
        int currSum = 0;

        for(int x=0; x<k; x++){
            currSum += nums[x];
        }
        int maxSum = currSum;

        while(j<nums.length-1){
            currSum  = currSum - nums[i] + nums[j+1];
            i++;
            j++;

            maxSum = Math.max(maxSum, currSum);
        }
        return (double) maxSum/k;
    }
}