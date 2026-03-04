class Solution {

    private boolean canShip(int[] weights, int days, int capacity){
        int daysNeeded = 1;
        int currweight = 0;

        for(int i =0; i < weights.length; i++){
            if(currweight + weights[i] > capacity){
                 daysNeeded++;
                currweight = 0;
            }
            currweight += weights[i];
        }
        return daysNeeded <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for(int w : weights){
            low = Math.max(low, w);
            high += w;
        }
        while(low < high){
            int mid = low + (high - low)/2;

            if(canShip(weights, days, mid)){
                high =  mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}