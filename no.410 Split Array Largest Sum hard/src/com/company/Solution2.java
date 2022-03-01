package com.company;

public class Solution2 {

    public int splitArray(int[] nums, int m) {
        int ans=-1;

        int n = nums.length;

        int[] prefixSums = new int[n];
        prefixSums[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            prefixSums[i] = nums[i] + prefixSums[i+1];
        }
        int[][] dp = new int[n][m+1];

        //when m=1:


        for(int i=0; i<=n-1; i++){
            dp[i][1] = prefixSums[i];
        }

        //when m>=2
        for(int l=2; l<=m; l++){
            for(int i=0; i<=n-l; i++){

                int singleI = prefixSums[i] - prefixSums[i + 1];
                if( singleI>=dp[i+1][l-1]){



                    dp[i][l] = singleI;

                }else if((prefixSums[i]-prefixSums[n-l+1])<=dp[n-l+1][l-1]){



                    dp[i][l] = dp[n-l+1][l-1];

                }else{



                    int left = i;
                    int right = n-l;

                    while(right-left>=2){

                        int mid = left + (right-left)/2;

                        if((prefixSums[i]-prefixSums[mid+1])<=dp[mid+1][l-1]){
                            left = mid;
                        }else{
                            right = mid;
                        }
                    }



                    dp[i][l]=Math.min(dp[left+1][l-1], prefixSums[i]-prefixSums[left+2]);



                }
            }
        }

        ans = dp[0][m];
        return ans;
    }
}
