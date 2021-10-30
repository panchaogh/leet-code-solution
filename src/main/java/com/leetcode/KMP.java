package com.leetcode;

public class KMP {
    public static void main(String[] args) {
        String str = "";
        String subStr = "a";
        KMP kmp = new KMP();
        int index = kmp.strStr(str, subStr);
        System.out.println(index);
    }

    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }
        int[] next = getNext(needle);
        return strStr(haystack, needle, next);
    }

    public int[] getNext(String needle) {
        int needleLength = needle.length();
        char[] needleChars = needle.toCharArray();
        int[] next = new int[needleLength];
        next[0] = 0;
        if (needleLength == 1) {
            return next;
        }
        next[1] = 0;
        int i = 0, j = 1;
        while (j < needleLength - 1) {
            if (needleChars[i] == needleChars[j]) {
                i++;
                j++;
                if(needleChars[i] == needleChars[j]){
                    next[j] = next[i];
                }else {
                    next[j] = i;
                }
            } else {
                if (i == 0) {
                    j++;
                } else {
                    i = next[i];
                }
            }
        }
        return next;
    }

    public int strStr(String haystack, String needle, int[] next) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int i = 0, j = 0;
        while (i < haystackLength && j < needleLength) {
            if (haystackChars[i] == needleChars[j]) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                }
                j = next[j];
            }
        }
        if (j == needleLength) {
            return i - j;
        }
        return -1;
    }
}
