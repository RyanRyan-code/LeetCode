package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException {

        File file_s = new File("s.txt");
        File file_t = new File("t.txt");


        String s = Files.readString(file_s.toPath());
        String t = Files.readString(file_t.toPath());

        //String s = "bdab";
        //String t ="ab";

        //String s = "ADOBECODEBANC";
        //String t = "ABC";

        //String s = "bbaac";
        //String t = "aba";


        String ans = Solution.minWindow(s,t);

        System.out.println(ans);
        System.out.println(ans.length());






    }
}
