class Solution {

    private boolean canMake(int bloomday[], int m, int k, int d){
         int boq = 0;
         int con = 0;

         for(int i = 0; i < bloomday.length; i++){
              if(bloomday[i] <= d){
                  con++;

                  if(con == k){
                    boq++;
                    con = 0;
                  }
                }
                else{
                    con = 0;
                }
         }
         return boq >= m;
    }
    public int minDays(int[] bloomday, int m, int k) {
        if((long) m * k > bloomday.length) return -1;
 
        int low = 1;
        int high = 0;
        for(int day : bloomday){
            high =  Math.max(high, day);
        }
        int result = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(canMake(bloomday, m, k, mid)){
                result = mid;
                high =  mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return result;
    }
}