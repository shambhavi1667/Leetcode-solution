class Solution {
    public int longestKSubstr(String s, int k) {
      if(s.length() == 0){
          return -1;
      }
      HashMap<Character, Integer> map = new HashMap<>();
      int left = 0;
      int maxLen = -1;
      int distinctCount = 0;
        for(int right = 0; right<s.length(); right++){
            char ch = s.charAt(right);
            
            map.put(ch, map.getOrDefault(ch, 0)+ 1);
            
            if(map.get(ch) == 1){
                distinctCount++;
            }
            while(distinctCount > k){
                char leftChar = s.charAt(left);
                
                map.put(leftChar, map.get(leftChar)-1);
                
                if(map.get(leftChar) == 0){
                    distinctCount--;
                }
                 left++;
            }
            if(distinctCount == k){
                maxLen = Math.max(maxLen, right-left+1);
            }
        }
        return maxLen;
    }
}