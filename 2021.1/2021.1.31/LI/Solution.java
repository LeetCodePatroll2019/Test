class Solution {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }

    public static String longestPalindrome(String s) {
        int l = s.length();
        if(l < 2) return s;
        String res = (String) s.charAt(0), sub;
        char[] tab = s.toCharArray();
        int maxLen = 0, curLen;
        int i, j;
        boolean[][] dp = new boolean[l][l];
        for (j =0 ; j < l; j++) {
            for (i = 0; i < l; i++) {
                dp[i][j] = (tab[i] == tab[j]) && (j-i < 3 || dp[i+1][j-1]);
                sub = s.substring(i, j+1);
                curLen = sub.length();
                if(dp[i][j] && curLen > maxLen){
                    res = sub;
                    maxLen = curLen;
                }
            }
        }
        return res;
    }


}