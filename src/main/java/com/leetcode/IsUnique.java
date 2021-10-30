package com.leetcode;


public class IsUnique {
    public boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if(chars[i] == chars[j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abc";
        IsUnique isUnique = new IsUnique();
        System.out.println(isUnique.isUnique(str));
    }
}
