package com.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 697. 数组的度
 *
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 */
public class FindShortestSubArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int[] v = map.get(nums[i]);
            if (v == null) {
                int[] a = {1, i, i};
                map.put(nums[i], a);
            } else {
                v[0] = v[0] + 1;
                v[2] = i;
                map.put(nums[i], v);
            }
        }
        List<Map.Entry<Integer, int[]>> list = map.entrySet().stream().sorted((o1, o2) -> 0 - Integer.compare(o1.getValue()[0], o2.getValue()[0])).collect(Collectors.toList());
        int du = list.get(0).getValue()[0];
        list = list.stream().filter(integerEntry -> integerEntry.getValue()[0] == du).collect(Collectors.toList());
        int result = 0;
        for (Map.Entry<Integer, int[]> entry : list) {
            result = Math.min(result, (entry.getValue()[2] - entry.getValue()[1] + 1));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1};
        FindShortestSubArray findShortestSubArray = new FindShortestSubArray();
        System.out.println(findShortestSubArray.findShortestSubArray(nums));
    }
}
