package projectvice.algorithms;

public class LongestPalindrome {
  static boolean isSubstringPalindrome(String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) return false;
      start++;
      end--;
    }
    return true;
  }
  
  static String longestPalindrome(String s) {
    if (s.length() <= 1) return s;
    String last = s.substring(0, 1);
    for (int start = 0; start < s.length() - 1; start++) {
      for (int end = start + 1; end < s.length(); end++) {
        if (isSubstringPalindrome(s, start, end) && (end - start + 1) > last.length()) {
          last = s.substring(start, end + 1);
        }
      }
    }
    return last;
  }
  
  public static void main(String args[]) {
    System.out.println(longestPalindrome("aaaabbaa"));
    System.out.println(longestPalindrome("ab"));
  }
}
