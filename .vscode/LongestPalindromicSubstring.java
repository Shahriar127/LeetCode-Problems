public class LongestPalindromicSubstring {
      public String longestPalindrome(String s) {
        
          String T = preprocess(s);
          int n = T.length();
          int[] P = new int[n]; 
          int C = 0, R = 0; 
  
         
          for (int i = 1; i < n - 1; i++) {
              int mirr = 2 * C - i;  
              
             
              if (i < R) {
                  P[i] = Math.min(R - i, P[mirr]);
              }
  

              while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                  P[i]++;
              }
  
              
              if (i + P[i] > R) {
                  C = i;
                  R = i + P[i];
              }
          }
  
          
          int maxLen = 0;
          int centerIndex = 0;
          for (int i = 1; i < n - 1; i++) {
              if (P[i] > maxLen) {
                  maxLen = P[i];
                  centerIndex = i;
              }
          }
  
          
          int start = (centerIndex - maxLen) / 2;
          return s.substring(start, start + maxLen);
      }
  
      
      private String preprocess(String s) {
          StringBuilder sb = new StringBuilder();
          sb.append('#');
          for (char c : s.toCharArray()) {
              sb.append(c).append('#');
          }
          return sb.toString();
      }
  
      public static void main(String[] args) {
          LongestPalindromicSubstring ma = new LongestPalindromicSubstring();
          String result = ma.longestPalindrome("babad");
          System.out.println("Longest Palindromic Substring: " + result);
      }
  }
  