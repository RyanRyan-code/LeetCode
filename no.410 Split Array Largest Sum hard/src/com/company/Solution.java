package com.company;

public class Solution {

    public int splitArray(int[] nums, int m) {
        int ans=-1;

        int n = nums.length;

        int[][][] dp = new int[n][n][m+1];

        //when m=1:
        for(int i=0; i<n; i++){
            dp[i][i][1] = nums[i];
        }

        for(int k=1; k<n; k++){
            for(int i=0; i<n-k; i++){
                dp[i][i+k][1] = dp[i][i][1]+dp[i+1][i+k][1];
            }
        }

        int count=0;

        //when m>=2:
        for(int l=2; l<=m; l++){

            for(int i=0; i<n; i++){
                for(int j=i; j<n; j++){
                    count++;

                    //interval nums[i,j]
                    int len = j-i+1;
                    if(l<=len){

                        if(dp[i][i][1]>=dp[i+1][j][l-1]){
                            dp[i][j][l] = dp[i][i][1];
                        }else if(dp[i][j-l+1][1]<=dp[j-l+1+1][j][l-1]){
                            dp[i][j][l] = dp[j-l+1+1][j][l-1];
                        }else{
                            int left = i;
                            int right = j-l+1;

                            while(right-left>=2){

                                int mid = left + (right-left)/2;

                                if(dp[i][mid][1]<=dp[mid+1][j][l-1]){
                                    left = mid;
                                }else{
                                    right = mid;
                                }

                            }

                            dp[i][j][l]=Math.min(dp[left+1][j][l-1], dp[i][left+1][1]);

                        }

                        /*
                        for(int firstBlock=i; firstBlock<=j-l+1; firstBlock++){
                            temp = Math.min(temp, Math.max(dp[i][firstBlock][1], dp[firstBlock+1][j][l-1]));
                        }

                        dp[i][j][l]=temp;
                         */

                    }






                }
            }

        }


        ans = dp[0][n-1][m];


        System.out.println(count);



        return ans;
    }
}
