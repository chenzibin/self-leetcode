package self.leetcode;

/**
 * Leetcode53
 *
 * 暴力解法：三层遍历, 时间复杂度O(n^3)
 *  -- 外层循环：按数组个数, 从1到数组长度
 *  -- 内层循环：按数组索引, 从0到数组长度-数组个数
 *  -- 求和循环
 *  -- leetcode:
 *          Time Limit Exceeded
 *
 * 暴力解法-优化：双层遍历, 时间复杂度O(n^2)
 *  -- 外层循环：按数组索引，从0到数组长度-1
 *  -- 内层循环：按数组个数，从1到数组长度-数组索引
 *  -- leetcode:
 *          执行耗时:246 ms,击败了5.06% 的Java用户
 *          内存消耗:38.4 MB,击败了58.73% 的Java用户
 *
 * 解法：单层遍历, 时间复杂度O(n)
 *  -- 循环：按数组索引， 从0到数组长度-1
 *  -- leetcode:
 *          执行耗时:1 ms,击败了94.79% 的Java用户
 *          内存消耗:38.4 MB,击败了63.57% 的Java用户
 *
 * @author chenzb
 * @date 2021/4/13
 */
public class Leetcode53 {

    Solution solution = Solution.BRUTE;

    public int maxSubArray(int[] nums) {
        switch (solution)  {
            case BRUTE_FORCE:
                return bruteForce(nums);
            case BRUTE_FORCE_OPTIMIZATION:
                return bruteForceOptimization(nums);
            case BRUTE:
                return brute(nums);
            default:
                return bruteForce(nums);
        }
    }

    private int brute(int[] nums) {
        int maxSum = nums[0];
        int partSum = 0;
        for (int i = 0; i < nums.length; i++) {
            partSum += nums[i];
            if (partSum > maxSum) {
                maxSum = partSum;
            }
            if (partSum < 0) {
                partSum = 0;
            }
        }
        return maxSum;
    }

    public int bruteForce(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= nums.length - i; j++) {
                int sum = sum(nums, j, j + i - 1);
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public int bruteForceOptimization(int[] nums) {
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 1; j <= nums.length - i; j++) {
                int value = nums[i + j - 1];
                sum += value;
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    private int sum(int[] nums, int startIndex, int endIndex) {
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += nums[i];
        }
        return sum;
    }


    enum Solution {
        BRUTE_FORCE,
        BRUTE_FORCE_OPTIMIZATION,
        BRUTE
    }

    public static void main(String[] args) {
        Leetcode53 leetcode = new Leetcode53();
        int maxSum = leetcode.maxSubArray(new int[]{5,4,-1,7,8});
        System.out.println(maxSum);
    }
}
