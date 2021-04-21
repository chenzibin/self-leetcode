package self.leetcode;

/**
 * 最长回文子串
 *
 * 暴力破解：时间复杂度O(N^3)
 *  -- leetcode
 *      执行耗时:606 ms,击败了6.84% 的Java用户
 *      内存消耗:38.4 MB,击败了89.48% 的Java用户
 * 中心扩散：时间复杂度O(N^2)
 *  -- leetcode
 *      执行耗时:40 ms,击败了72.17% 的Java用户
 *      内存消耗:38.5 MB,击败了85.02% 的Java用户
 *
 * @author chenzb
 * @date 2021/3/1
 */
public class Leetcode5{

    Solution solution = Solution.CENTER_SPREAD;

    public String longestPalindrome(String s) {
        switch (solution) {
            case BRUTE_FORCE:
                return bruteForce(s);
            case DP:
                return dp(s);
            case CENTER_SPREAD:
                return centerSpread(s);
        }
        return bruteForce(s);
    }

    class BruteForce {

    }

    public String bruteForce(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j <= s.length() - i; j++) {
                if (isPalindrome(s, j, i + j - 1)) {
                    return s.substring(j, i + j);
                }
            }
        }
        return null;
    }

    public boolean isPalindrome(String s, int from, int end) {
        while (from < end) {
            if (s.charAt(from) != s.charAt(end)) {
                return false;
            }
            from++;
            end--;
        }
        return true;
    }

    public String dp(String s) {
        return null;
    }

    public String centerSpread(String s) {
        int from = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i, k = i; j >= 0 && k < s.length(); j--, k++) {
                if (s.charAt(j) != s.charAt(k)) {
                    break;
                }
                if (k - j > end - from) {
                    from = j;
                    end = k;
                }
            }

            for (int j = i, k = i + 1; j >= 0 && k < s.length(); j--, k++) {
                if (s.charAt(j) != s.charAt(k)) {
                    break;
                }
                if (k - j > end - from) {
                    from = j;
                    end = k;
                }
            }
        }
        return s.substring(from, end + 1);
    }

    enum Solution {
        BRUTE_FORCE,
        DP,
        CENTER_SPREAD
    }

    public static void main(String[] args) {
        Leetcode5 leetcode = new Leetcode5();
        leetcode.solution = Solution.CENTER_SPREAD;
        String text = "abggbc";
        long startTime = System.currentTimeMillis();
        String result = leetcode.longestPalindrome(text);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时: " +  (endTime - startTime));
        System.out.println("结果: " + result);
    }

}
