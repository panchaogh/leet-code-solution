package com.leetcode;

/**
 * 53. 最大子序和
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = new Solution().maxSubArray2(nums);
        System.out.println(max);
    }

    static class Solution {
        /**
         * 动态规划
         */
        public int maxSubArray(int[] nums) {
            int maxSub = nums[0], pre = 0;
            for (int num : nums) {
                pre = Math.max(pre + num, num);
                maxSub = Math.max(maxSub, pre);
            }
            return maxSub;
        }

        /**
         * 贪心算法
         */
        public int maxSubArray1(int[] nums) {
            //类似寻找最大最小值的题目,初始值一定要定义成理论上的最小最大值
            int result = Integer.MIN_VALUE;
            int sum = 0;
            for (int num : nums) {
                sum += num;
                result = Math.max(result, sum);
                //如果sum < 0,重新开始找子序串
                if (sum < 0) {
                    sum = 0;
                }
            }

            return result;
        }

        /**
         * 线段树
         */
        public int maxSubArray2(int[] nums) {
            return getInfo(nums, 0, nums.length - 1).msum;
        }

        public Status getInfo(int[] nums, int lIndex, int rIndex) {
            if (lIndex == rIndex) return new Status(nums[lIndex], nums[lIndex], nums[lIndex], nums[lIndex]);
            int middleIndex = lIndex + (rIndex - lIndex) / 2;
            Status lStatus = getInfo(nums, lIndex, middleIndex);
            Status rStatus = getInfo(nums, middleIndex + 1, rIndex);
            return Status.pushUp(lStatus, rStatus);
        }

    }

    static class Status {
        int lsum; //以左区间为端点的最大子段和
        int rsum; //以右区间为端点的最大子段和
        int isum; //区间所有数的和
        int msum; //区间的最大子段和

        public Status(int lsum, int rsum, int isum, int msum) {
            this.lsum = lsum;
            this.rsum = rsum;
            this.isum = isum;
            this.msum = msum;
        }

        /**
         * 通过既有的属性,计算上一层的属性,一步步往上返回,获得线段树
         */
        public static Status pushUp(Status lStatus, Status rStatus) {
            //新子段的lSum等于左区间的lSum或者左区间的区间和加上右区间的lSum
            int lsum = Math.max(lStatus.lsum, lStatus.isum + rStatus.lsum);
            //新子段的rSum等于右区间的rSum或者右区间的区间和加上左区间的rSum
            int rsum = Math.max(rStatus.rsum, rStatus.isum + lStatus.rsum);
            //新子段的区间和等于左右区间的区间和之和
            int isum = lStatus.isum + rStatus.isum;
            //新子段的最大子段和,其子段有可能穿过左右区间,或左区间,或右区间
            int msum = Math.max(lStatus.rsum + rStatus.lsum, Math.max(lStatus.msum, rStatus.msum));
            return new Status(lsum, rsum, isum, msum);
        }
    }
}
