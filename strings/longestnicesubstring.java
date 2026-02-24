class Solution {
    public String longestNiceSubstring(String s) {
        String result = "";

        for(int i=0; i<s.length(); i++){
           for(int j=i; j<s.length(); j++){
                String sub= s.substring(i,j+1);
            
            if(isNice(sub)){
                if(sub.length() > result.length()) {
                    result =sub;
                }
            }
        }
    }
    return result;
}
public boolean isNice(String s) {
    HashSet<Character> set = new HashSet<>();

    for(char c: s.toCharArray()) {
        set.add(c);
    }

    for(char c: s.toCharArray()) {
        if(!set.contains(Character.toLowerCase(c))){
        return false;
        }
        else{
          if(!set.contains(Character.toUpperCase(c))){
                return false;
            }
        }
    }
    return true;
}
}