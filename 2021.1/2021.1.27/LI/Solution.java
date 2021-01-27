import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int debut, fin;
        int n = s.length();
        int res = 0;
        char tmp;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(debut = 0, fin = 0; fin < n; fin++){
            tmp = s.charAt(fin);
            if(map.containsKey(tmp)){
                debut = Math.max(map.get(tmp), debut);
            }
            res = Math.max(res, fin - debut + 1);
            map.put(tmp, fin + 1);
        }
        return res;
    }
}