import java.util.Scanner;

public class LongestCommonSubsequence {
    static int commonChild(String s1, String s2){
         
          return LCS(s1, s2);
    }
    
    
    static int LCS (String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int i = 0; i <= s.length(); i++) {
            dp[0][i] = 0;
            dp[i][0] = 0;
        }
        
        for (int i = 1; i <= s.length(); i++) {
             for (int j = 1; j <= t.length(); j++) {
                 if (s.charAt(i-1) == t.charAt(j-1))
                     dp[i][j] = dp[i - 1][j - 1] + 1;
                 else {
                     dp[i][j] = Math.max(dp[i-1][j],  dp[i][j -1]);
                 }
             }
        }
        return dp[s.length()][t.length()];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = commonChild(s1, s2);
        System.out.println(result);
    }
}
