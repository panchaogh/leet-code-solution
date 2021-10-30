package com.leetcode;

public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder(s.length());
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "We are happy.";
        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace(str));
    }
}
