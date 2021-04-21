package self.leetcode;

/**
 * Leetcode4
 *
 * 解法1：时间复杂度 O(N), 空间复杂度O(N)
 *  -- 归并排序两个数组，取中位
 *  -- leetcode
 *      执行耗时:3 ms,击败了82.38% 的Java用户
 *      内存消耗:39.5 MB,击败了86.19% 的Java用户
 *
 *
 *
 * @author chenzb
 * @date 2021/4/19
 */
public class Leetcode4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int countLength = nums1.length + nums2.length;
        int medianIndex = (countLength) / 2;
        boolean single = (countLength % 2 == 1);
        int i = 0;
        int j = 0;
        int prev = 0;
        while(nums1.length > i || nums2.length > j) {
            int cur = 0;

            if (nums1.length == i) {
                cur = nums2[j];
                j++;
            } else if (nums2.length == j) {
                cur = nums1[i];
                i++;
            } else if (nums1[i] > nums2[j]) {
                cur = nums2[j];
                j++;
            } else {
                cur = nums1[i];
                i++;
            }
            if (medianIndex == i + j - 1) {
                if (single) {
                    return cur;
                } else {
                    return (prev + cur) / 2.00000;
                }
            }
            prev = cur;
        }
        return 0;
    }

    public static void main(String[] args) {
        Leetcode4 leetcode = new Leetcode4();
        double result = leetcode.findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{4, 5});
        System.out.println(result);
    }
}
