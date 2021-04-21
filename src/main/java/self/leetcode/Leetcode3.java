package self.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode3
 *  -- leetcode
 *          执行耗时:6 ms,击败了85.63% 的Java用户
 *          内存消耗:38.5 MB,击败了68.53% 的Java用户
 *
 * @author chenzb
 * @date 2021/4/19
 */
public class Leetcode3 {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int startIndex = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer resetStartIndex = map.put(s.charAt(i), i);
            if (resetStartIndex != null && resetStartIndex > startIndex) {
                startIndex = resetStartIndex;
            }
            maxLength = Math.max(maxLength, i - startIndex);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Leetcode3 leetcode = new Leetcode3();
        int result = leetcode.lengthOfLongestSubstring("ababcabc");
        System.out.println(result);
    }
}
