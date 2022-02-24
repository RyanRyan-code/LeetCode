package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<List<Interval>> test = new ArrayList<>();

        List<Interval> e1 = new ArrayList<>();
        e1.add(new Interval(1,2));
        e1.add(new Interval(5,6));
        test.add(e1);

        List<Interval> e2 = new ArrayList<>();
        e2.add(new Interval(1,3));
        test.add(e2);

        List<Interval> e3 = new ArrayList<>();
        e3.add(new Interval(4,10));
        test.add(e3);





        Solution solution = new Solution();
        System.out.println(solution.employeeFreeTime(test));




    }
}
