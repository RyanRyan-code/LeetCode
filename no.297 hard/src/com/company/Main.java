package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        List<Integer> l = new ArrayList<>();
        l.add(5);
        l.add(6);
        l.add(null);



        String s = l.toString();
        int len = s.length();

        String[] parsedString = s.substring(1,len-1).split(", ");

        Arrays.stream(parsedString).forEach(System.out::println);


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        Solution solution = new Solution();
        System.out.println(solution.serialize(root));

        TreeNode rootTest = solution.deserialize(solution.serialize(root));

        System.out.println(rootTest.left.left.left.val);
        System.out.println(rootTest.left.left.left.left);
        System.out.println(rootTest.right.right.val);


    }
}
