package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static double round(double d){
        return Math.round(d*1000.0)/1000.0;
    }

    public List<Double> getAllResults(double d1, double d2){
        List<Double> result = new ArrayList<>();
        result.add(d1+d2);
        result.add(d1*d2);
        result.add(d1-d2);
        result.add(d2-d1);
        if(d1!=0){
            result.add(d2/d1);
        }
        if(d2!=0){
            result.add(d1/d2);
        }

        return result;
    }

    public boolean judgePair(double d1, double d2){
        boolean result = false;
        List<Double> list = getAllResults(d1, d2);
        for (Double d:list) {
            if(round(d)==24){
                
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean helperRecursive(double d, List<Double> list){
        boolean result = false;

        if(list.size()==1){
            result = judgePair(d, list.get(0));
        }else{

            for (int i=0; i<=list.size()-1; i++) {

                List<Double> newResult = getAllResults(d, list.get(i));
                List<Double> newList = new ArrayList<>();

                for(int j=0; j<=list.size()-1; j++){
                    if(j!=i){
                        newList.add(list.get(j));
                    }
                }

                for (int j=0; j<=newResult.size()-1; j++) {
                    if(helperRecursive(newResult.get(j), newList)){
                        result = true;
                        break;
                    }
                }
            }
        }

        return result;
    }

    public boolean helperRemainingCases(List<Double> list){
        boolean result = false;

        for(int i=1; i<=list.size()-1; i++){
            List<Double> list1 = new ArrayList<>();
            list1.add(list.get(0));
            list1.add(list.get(i));

            List<Double> listCompliment = new ArrayList<>();
            for(int j=1; j<=list.size()-1; j++){
                if(j!=i){
                    listCompliment.add(list.get(j));
                }
            }

            List<Double> result1 = getAllResults(list1.get(0), list1.get(1));
            List<Double> result2 = getAllResults(listCompliment.get(0), listCompliment.get(1));

            for(Double d1:result1){
                for(Double d2:result2){
                    if(judgePair(d1, d2)){

                        result = true;
                        break;
                    }
                }
            }

        }

        return result;
    }

    public boolean judgePoint24(int[] cards) {

        boolean result=false;

        List<Double> list = new ArrayList<>();
        for (int i: cards) {
            list.add((double)i);
        }

        for(int i=0; i<=list.size()-1; i++){
            List<Double> newList = new ArrayList<>();

            for(int j=0; j<=list.size()-1; j++){
                if(j!=i){
                    newList.add(list.get(j));
                }
            }
            if(helperRecursive(list.get(i), newList)){
                result = true;
                break;
            }

        }

        if(helperRemainingCases(list)){
            result = true;
        }

        return result;
    }


}
