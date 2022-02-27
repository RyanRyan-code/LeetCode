package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();


        //System.out.println(solution.nthMagicalNumber(10000000,39999,40000));

        //should be 999860007
        //System.out.println(solution2.nthMagicalNumber(1000000000,39999,40000));

        //should be 8
        //System.out.println(solution2.nthMagicalNumber(3,8,3));

        //should be 30
        //System.out.println(solution2.nthMagicalNumber(10,2,3));

        //System.out.println(solution2.nthMagicalNumber(1,4,6));
        //System.out.println(solution2.nthMagicalNumber(1,2,3));

        //should be 4
        System.out.println(solution2.nthMagicalNumber(3,3,2));




    }
}
