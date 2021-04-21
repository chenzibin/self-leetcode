package self.leetcode;

import java.util.*;

/**
 * Leetcode1
 *
 * 分析：
 *  -- nums[x] + nums[y] = target
 * 解法：时间复杂度 O(n), 空间复杂度 O(n)
 *  -- 循环遍历num[x]， 通过哈希尝试获取nums[y]
 *  -- leetcode
 *      执行耗时:0 ms,击败了100.00% 的Java用户
 *      内存消耗:38.7 MB,击败了46.27% 的Java用户
 *
 * @author chenzb
 * @date 2021/4/15
 */
public class Leetcode1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int other = target - num;
            if (numMap.containsKey(other)) {
                return new int[] {i, numMap.get(other)};
            }
            numMap.put(num, i);
        }
        return null;
    }

    public static void main(String[] args) {
        Leetcode1 leetcode = new Leetcode1();
        int[] result = leetcode.twoSum(new int[] {2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));
    }
}
