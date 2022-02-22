package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Solution {

    public static int longestValidParentheses(String s){

        int l = s.length();

        int ans = 0;

        int[] line = new int[l];

        ArrayList<Pair> stack = new ArrayList<>();

        for (int i=0; i<l; i++){

            if (s.charAt(i)=='('){
                stack.add(new Pair('(',i));
            }else if(stack.size()>0){
                Pair popped = stack.remove(stack.size()-1);
                Array.set(line, popped.i, 1);
                Array.set(line, i, 1);
            }

        }

        int temp = 0;

        for (int i=0; i<l; i++){
            if (line[i]==0){
                temp=0;
            }else {
                temp++;
                if (temp>ans){
                    ans = temp;
                }

            }
        }

        return ans;

    }
}
