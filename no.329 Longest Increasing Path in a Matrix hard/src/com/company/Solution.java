package com.company;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    int[][] matrixC;
    int m;
    int n;
    Map<Point, Integer> map;


    public int searchThisPoint(int a, int b){
        int ans = 1;
        Point p = new Point(a,b);

        boolean marked = map.containsKey(p);

        if(marked){
            ans = map.get(p);
        }else{

            int next = 0;
            if(a-1>=0 && matrixC[a-1][b]>matrixC[a][b]){
                next = Math.max(next, searchThisPoint(a-1, b));
            }

            if(a+1<m && matrixC[a+1][b]>matrixC[a][b]){
                next = Math.max(next, searchThisPoint(a+1, b));
            }

            if(b-1>=0 && matrixC[a][b-1]>matrixC[a][b]){
                next = Math.max(next, searchThisPoint(a, b-1));
            }

            if(b+1<n && matrixC[a][b+1]>matrixC[a][b]){
                next = Math.max(next, searchThisPoint(a, b+1));
            }

            ans += next;
            map.put(p, ans);
        }

        return ans;
    }

    public int longestIncreasingPath(int[][] matrix) {
        matrixC = matrix;
        m = matrixC.length;
        n = matrixC[0].length;
        map = new HashMap<>();
        int ans=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                Point p = new Point(i,j);
                if(!map.containsKey(p)){
                    int temp = searchThisPoint(i, j);
                    ans = Math.max(ans, temp);


                }
            }
        }

        return ans;
    }
}
