package com.leetcode;

public class OneEditAway {
    public boolean oneEditAway(String first, String second) {
        if (first == null || second == null) return false;
        int firstLen = first.length();
        int secondLen = second.length();
        if (Math.abs(firstLen - secondLen) > 1) return false;

        if (firstLen > secondLen) {
            for (int i = 0; i < secondLen; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    return first.substring(i + 1).equals(second.substring(i));
                }
            }
            return true;
        } else if (firstLen < secondLen) {
            for (int i = 0; i < firstLen; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    return first.substring(i).equals(second.substring(i + 1));
                }
            }
            return true;
        } else {
            for (int i = 0; i < firstLen; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    return first.substring(i + 1).equals(second.substring(i + 1));
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String first = "pales";
        String second = "pal";
        OneEditAway oneEditAway = new OneEditAway();
        System.out.println(oneEditAway.oneEditAway(first, second));
    }
}
