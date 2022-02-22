package com.company;

import java.util.List;

public class Solution {



    public int maxCoins(int[] nums) {

        int ans = 0;

        int length = nums.length;
        int[] n = new int[length+2];

        n[0] = 1;
        n[length+1] = 1;
        for (int i=1; i<length+1; i++){
            n[i] = nums[i-1];
        }

        if(length==1){
            return n[1];
        }else if(length==2){
            return n[1]*n[2]+Math.max(n[1],n[2]);
        }

        int[][] dp = new int[length+1][length+1];

        //range=1
        for (int i=1; i<length+1; i++){
            dp[i][i] = n[i-1]*n[i]*n[i+1];
        }

        //range=2



        //range>=3
        for (int j=1; j<length+1; j++){

            for (int i=1; i<length+1-j; i++){

                //sub-array nums[i,i+j]

                int maxSum = 0;

                for (int k=0; k<j+1; k++){

                    int tempSum = 0;

                    if(k==0){
                        tempSum += n[i-1]*n[i]*n[i+j+1] + dp[i+1][i+j];
                    }else if(k==j){
                        tempSum += n[i-1]*n[i+j]*n[i+j+1] + dp[i][i+j-1];
                    }else {
                        tempSum += n[i-1]*n[i+k]*n[i+j+1] + dp[i][i+k-1] + dp[i+k+1][i+j];
                    }

                    System.out.println("(i,j,k) sum: " +i +" " +j +" "+k +" "+tempSum);

                    maxSum = Math.max(maxSum, tempSum);

                }

                dp[i][i+j] = maxSum;

            }

        }


        ans = dp[1][length];







        return ans;
    }

}
