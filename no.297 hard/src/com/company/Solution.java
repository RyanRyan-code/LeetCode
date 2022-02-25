package com.company;


import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<Integer> l = new ArrayList<>();

    private void helperPushNode(TreeNode currentNode, int index, int slotNumToAdd){

        l.set(index, currentNode.val);

        boolean a = currentNode.left!=null;
        boolean b = currentNode.right!=null;

        if (a || b){
            for (int i=0; i<slotNumToAdd; i++){
                l.add(null);
            }
        }

        if (a){
            helperPushNode(currentNode.left, (index+1)*2-1, slotNumToAdd*2);
        }

        if (b){
            helperPushNode(currentNode.right, (index+1)*2, slotNumToAdd*2);
        }

    }



    public String serialize(TreeNode root) {

        if(root==null){
            return "";
        }else{
            l.add(0);
        }

        helperPushNode(root, 0, 2);

        return l.toString();
    }







    List<Integer> l2 = new ArrayList<>();
    TreeNode root;
    int lenReal;

    private void helperExtendNode(TreeNode currentNode, int index){
        int leftIndex = (index+1)*2-1;
        int rightIndex = (index+1)*2;

        if(leftIndex<lenReal && l2.get(leftIndex)!=null){
            currentNode.left = new TreeNode(l2.get(leftIndex));
            helperExtendNode(currentNode.left, leftIndex);
        }

        if(rightIndex<lenReal && l2.get(rightIndex)!=null){
            currentNode.right = new TreeNode(l2.get(rightIndex));
            helperExtendNode(currentNode.right, rightIndex);
        }

    }


    public TreeNode deserialize(String data) {

        if(data.length()<=2){
            return null;
        }

        int len = data.length();
        String[] parsedString = data.substring(1, len-1).split(", ");


        for(String s:parsedString){
            if(s.equals("null")){
                l2.add(null);
            }else{
                l2.add(Integer.valueOf(s));
            }
        }


        if(l2.size()==0){
            root = null;
        }else{
            root = new TreeNode(l2.get(0));
        }

        lenReal = l2.size();

        helperExtendNode(root, 0);




        return root;
    }




}
