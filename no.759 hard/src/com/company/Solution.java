package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        List<Interval> workTimeUnion = new ArrayList<>();
        List<Interval> ans = new ArrayList<>();

        List<Interval> scheduleSorted= schedule.stream().flatMap(Collection::stream).sorted(Comparator.comparingInt(x -> x.start)).toList();

        int a = -1;
        int b = -1;

        for(Interval i:scheduleSorted){
            if(i.start>b){
                workTimeUnion.add(new Interval(a,b));
                a=i.start;
                b=i.end;
            }else{
                b=Math.max(b, i.end);
            }
        }

        workTimeUnion.add(new Interval(a,b));

        for (int i=1; i<workTimeUnion.size()-1; i++){

            ans.add(new Interval(workTimeUnion.get(i).end, workTimeUnion.get(i+1).start));

        }

        return ans;
    }

}
