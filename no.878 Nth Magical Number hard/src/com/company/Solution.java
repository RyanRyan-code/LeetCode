package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }

    public int nthMagicalNumber(int n, int a, int b) {
        int ans = -1;
        int m = 1000000007;

        int gcd = gcdByEuclidsAlgorithm(a,b);
        a = a/gcd;
        b = b/gcd;

        //make sure a>=b
        if(a<b){
            int temp;
            temp = a;
            a = b;
            b = temp;
        }

        if(b==1){
            int quickAnswer = BigInteger.valueOf(n).multiply(BigInteger.valueOf(gcd)).divideAndRemainder(BigInteger.valueOf(m))[1].intValue();
            return quickAnswer;
        }

        List<BigInteger> s = new ArrayList<>();

        for(int i=1; i<=n; i++) s.add(BigInteger.valueOf((long)i*(long)b));

        int l = (int) Math.floor((b/a)*n);

        //need to be updated in the while loop
        int i=1;
        BigInteger temp = BigInteger.valueOf((long)a*(long)i);


        while(s.get(n-1).compareTo(temp)>0){

            //System.out.println("i: "+i);

            int left = 0;
            int right = n-1;

            int mid = left;

            boolean aa = temp.compareTo(s.get(mid))<0;
            boolean bb = temp.compareTo(s.get(mid+1))>=0;

            while(aa || bb){

                //System.out.println("look at these: ");
                //System.out.println(left+" "+right+" "+mid);

                int temp2 =mid;
                mid = (right-left)/2+left;

                aa = temp.compareTo(s.get(mid))<0;
                bb = temp.compareTo(s.get(mid+1))>=0;

                if(aa){
                    right = mid;
                }else{
                    left = mid;
                }

            }

            //System.out.println("mid and temp: "+mid+" "+temp);

            if(temp.compareTo(s.get(mid))!=0){
                s.remove(n -1);
                s.add(mid+1, temp);
            }

            i++;
            temp = BigInteger.valueOf((long)a*(long)i);

            //s.stream().forEach(System.out::println);
        }


        ans = s.get(n -1).multiply(BigInteger.valueOf(gcd)).divideAndRemainder(BigInteger.valueOf(m))[1].intValue();









        return ans;
    }


}
