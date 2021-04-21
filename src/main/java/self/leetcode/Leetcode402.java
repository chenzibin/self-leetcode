package self.leetcode;

import java.util.Stack;

/**
 * Leetcode402
 *
 * 贪心算法： 时间复杂度O(n^2)
 *  -- 左边越小收益越高，所以从左开始判断是否需要删除
 *  -- 左边开始查找右边小于左边的值，然后往左删除
 *  -- 如果还有剩余可删除机会，重新进行
 *  -- leetcode:
 *          执行耗时:8 ms,击败了81.28% 的Java用户
 *          内存消耗:38.3 MB,击败了90.14% 的Java用户
 *
 *
 * @author chenzb
 * @date 2021/4/13
 */
public class Leetcode402 {

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (Character c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0) {
                if (c >= stack.peek()) {
                    break;
                }
                stack.pop();
                k--;
            }
            if (stack.isEmpty() && c == '0') {
                continue;
            }
            stack.push(c);
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        if (stack.isEmpty()) {
            return "0";
        }
        char[] chars = new char[stack.size()];
        for (int i = chars.length -1; i >= 0; i--) {
            chars[i] = stack.pop();
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Leetcode402 leetcode = new Leetcode402();
        String result = leetcode.removeKdigits("1432219", 3);
        System.out.println(result);
    }
}
