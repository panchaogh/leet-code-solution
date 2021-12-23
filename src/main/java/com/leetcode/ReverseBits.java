package com.leetcode;

/**
 * 颠倒二进制位
 */
public class ReverseBits {
    public static void main(String[] args) {
        int result = new Solution().reverseBits1(0B10101010101010101010101010101010);
        System.out.println(result);
    }

    static class Solution {
        /**
         * 逐位颠倒
         */
        public int reverseBits(int n) {
            int result = 0;
            for (int i = 0; i < 32 && n != 0; i++) {
                result |= (n & 1) << (31 - i);
                n >>>= 1;
            }
            return result;
        }

        private final int a1 = 0B01010101010101010101010101010101;
        private final int a2 = 0B00110011001100110011001100110011;
        private final int a4 = 0B00001111000011110000111100001111;
        private final int a8 = 0B00000000111111110000000011111111;
        private final int a16 = 0B00000000000000001111111111111111;

        public int reverseBits1(int n) {
            n = n >>> 1 & a1 | (n & a1) << 1;
            n = n >>> 2 & a2 | (n & a2) << 2;
            n = n >>> 4 & a4 | (n & a4) << 4;
            n = n >>> 8 & a8 | (n & a8) << 8;
            return n >>> 16 | n << 16;
        }
    }
}
