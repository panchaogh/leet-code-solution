package com.leetcode;

public class Test {
    public static void main(String[] args) {
//        a();
        b();
    }

    public static void a() {
        int[] params = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 5, 6, 7, 8, 9, 0};
        int temp = 0;
        for (int i = 0; i < params.length; i++) {
            temp = temp ^ params[i];
        }
        System.out.println(temp);
    }

    public static void b() {
        int[] params = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 5, 6, 7, 8, 0}; // 4  9  0100  1001  1101
        int temp = 0;
        for (int i = 0; i < params.length; i++) {
            temp = temp ^ params[i];
        }
        int rightOne = temp & (~temp + 1);
        int temp1 = 0;
        for (int i = 0; i < params.length; i++) {
            if ((rightOne & params[i]) == 0) {
                temp1 = temp1 ^ params[i];
            }
        }
        System.out.println(temp1);
        System.out.println(temp1^temp);
    }
}
