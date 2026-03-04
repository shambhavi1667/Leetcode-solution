class Solution {

    public boolean canFinish(int[] piles, int k, int h){
        int total_hours = 0;

        for(int i = 0; i< piles.length; i++){
            total_hours += (piles[i] + k -1) / k;
        }
        return total_hours <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        

    for(int pile:piles){
        high = Math.max(pile, high);
    }
    while(low < high){
        int mid =  low + (high - low)/2;

        if(canFinish(piles, mid, h)){
            high = mid;
        }
        else{
            low = mid + 1;
        }
    }
    return low;
    }
}