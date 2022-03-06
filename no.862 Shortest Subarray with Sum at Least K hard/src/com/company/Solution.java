package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public int shortestSubarray(int[] nums, int k) {

        int ans = -1;
        int n = nums.length;

        int[] prefixSums = new int[n+1];
        prefixSums[0] = 0;
        for(int i=1; i<n+1; i++){
            prefixSums[i] = prefixSums[i-1] + nums[i-1];
        }

        Deque<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            while(!q.isEmpty() && prefixSums[i+1] <= prefixSums[q.getLast()]){
                q.removeLast();
            }
            if(nums[i]>0) {
                q.addLast(i);
            }
        }

        System.out.println("q: ");
        q.stream().forEach(System.out::println);
        System.out.println("");

        if(nums[0]>=k){
            return 1;
        }

        int left=n-1;
        if(!q.isEmpty()){
            left = q.pollFirst();
        }

        int right = left;

        int lenCurrent = 0;
        int lenMin = Integer.MAX_VALUE;

        int tempSum = 0;

        while(right<=n-1){
            
            if(right>=left) {

                tempSum = prefixSums[right+1] - prefixSums[left];
                System.out.println("temp sum: " + tempSum);

                lenCurrent = right - left + 1;

                if(tempSum>=k){

                    lenMin = Math.min(lenMin, lenCurrent);

                    if(q.isEmpty()){
                        break;
                    }else{
                        left = q.pollFirst();
                    }

                }else{
                    right++;
                }

            }else{
                right = left;
            }


        }




        if(lenMin!=Integer.MAX_VALUE) ans = lenMin;

        return ans;

    }
}
