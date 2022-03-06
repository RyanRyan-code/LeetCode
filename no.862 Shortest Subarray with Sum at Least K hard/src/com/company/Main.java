package com.company;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] test1 = {2,-1,2};

        System.out.println(solution.shortestSubarray(test1, 3));
        System.out.println();

        int[] test2 = {56,-21,56,35,-9};

        System.out.println(solution.shortestSubarray(test2, 61));
        System.out.println();

        int[] test3 = {1};

        System.out.println(solution.shortestSubarray(test3, 1));
        System.out.println();

        int[] test4 = {-28,81,-20,28,-29};

        System.out.println(solution.shortestSubarray(test4, 89));
        System.out.println();









    }
}
