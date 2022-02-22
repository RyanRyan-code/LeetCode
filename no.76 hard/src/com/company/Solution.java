package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


class Solution {
    public static String minWindow(String s, String t) {

        String ans = "";

        List<Character> t_uk = t.chars().distinct().mapToObj(x -> (char) x).collect(Collectors.toList());

        for(int i=0; i<s.length()+1; i++){
            ans = ans + " ";
        }

        HashMap<Character, Integer> hashMap_t = new HashMap<>();
        for (int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if (hashMap_t.containsKey(ch)){
                int new_value = hashMap_t.get(ch) + 1;
                hashMap_t.replace(ch, new_value);
            }else{
                hashMap_t.put(ch, 1);
            }
        }

        System.out.println(hashMap_t.toString());

        HashMap<Character, Integer> hashMap_s = new HashMap<>();

        int window_left = 0;
        int window_right = 0;

        int l = s.length();

        while (window_left!=l){

            boolean include_it = true;
            for (char key:hashMap_t.keySet()){
                if (!hashMap_s.containsKey(key) || hashMap_t.get(key).intValue()>hashMap_s.get(key).intValue()){
                    include_it = false;
                    break;
                }
            }

            if (!include_it && window_right<l){

                char ch = s.charAt(window_right);
                if (t_uk.contains(ch)) {

                    if (hashMap_s.containsKey(ch)) {
                        int new_value = hashMap_s.get(ch) + 1;
                        hashMap_s.replace(ch, new_value);
                    } else {
                        hashMap_s.put(ch, 1);
                    }
                }

                window_right++;

            }else {
                if (include_it) {
                    if (window_right - window_left < ans.length()) {
                        ans = s.substring(window_left, window_right);
                    }
                }

                char ch = s.charAt(window_left);
                if (t_uk.contains(ch)) {

                    if (hashMap_s.get(ch) > 1) {
                        int new_value = hashMap_s.get(ch) - 1;
                        hashMap_s.replace(ch, new_value);
                    } else {
                        hashMap_s.remove(ch);
                    }
                }

                window_left++;
            }
        }

        if (ans.contains(" ")) {
            return "";
        }

        return ans;
    }
}
