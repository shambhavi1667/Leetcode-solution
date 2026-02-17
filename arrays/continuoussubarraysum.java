class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        int prefixSum = 0;

        // remainder → first index where it appeared
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // handle subarray starting from index 0

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            int remainder = prefixSum % k;

            // if remainder seen before
            if (map.containsKey(remainder)) {

                int prevIndex = map.get(remainder);

                // length of subarray must be at least 2
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                // store first occurrence of remainder
                map.put(remainder, i);
            }
        }

        return false;
    }
}