// LC 10. Regular Expression Matching
// 我选这个code原因是，这道题目设计到DP, 有一定的逻辑难度
// 其次, 我觉得自己的代码风格还是不错的

class Solution {
  public boolean isMatch(String s, String p) {
    // initial
    boolean[][] f = new boolean[s.length() + 1][p.length() + 1];
    f[0][0] = true;
    for (int j = 1; j <= p.length(); j++) {
      char c = p.charAt(j - 1);
      if (c == '*') {
        f[0][j] = f[0][j - 2];
      } else {
        f[0][j] = false;
      }
    }

    for (int i = 1; i <= s.length(); i++) {
      f[i][0] = false;
    }

    // calulate
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= p.length(); j++) {
        char c = p.charAt(j - 1);
        if (c == '.') {
          f[i][j] = f[i - 1][j - 1];
        } else if (c == '*') {
          f[i][j] = f[i][j - 2] || f[i][j - 1];
          if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
            f[i][j] = f[i][j] || f[i - 1][j];
          }
        } else {
          if (s.charAt(i - 1) == c) {
            f[i][j] = f[i - 1][j - 1];
          } else {
            f[i][j] = false;
          }
        }
      }
    }
    return f[s.length()][p.length()];
  }
}