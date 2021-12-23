package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FirstBadVersion {
    public static void main(String[] args) {
        boolean[] versions = {false, false, false, true, true, true, true, true, true, true, true, true};
        int result = new Solution(versions).firstBadVersion(versions.length);
        System.out.println(result);
    }

    public static class VersionControl {
        Map<Integer, Boolean> map;

        public VersionControl(boolean[] versions) {
            this.map = new HashMap<>();
            for (int i = 0; i < versions.length; i++) {
                map.put(i + 1, versions[i]);
            }
        }

        public boolean isBadVersion(int version) {
            return map.getOrDefault(version, true);
        }
    }


    public static class Solution extends VersionControl {
        public Solution(boolean[] versions) {
            super(versions);
        }

        /**
         * 暴力解法
         */
        public int firstBadVersion1(int n) {
            for (int i = n; i > 0; i--) {
                if (!isBadVersion(i)) {
                    if (i == n) {
                        return i;
                    } else {
                        return i + 1;
                    }
                }
            }
            return 1;
        }

        /**
         * 二分查找法
         */
        public int firstBadVersion(int n) {
            int left = 1, right = n, middle;
            while (left < right) {
                middle = left + (right - left) / 2;
                if (isBadVersion(middle)) {
                    right = middle;
                } else {
                    left = middle + 1;
                }
            }
            return left;
        }
    }
}
