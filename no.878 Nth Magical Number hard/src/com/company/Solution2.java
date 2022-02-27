package com.company;

import java.math.BigInteger;

public class Solution2 {

    public int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }

    public int binarySearchCriteria(int a, int b, int n, int k){

        BigInteger c1 = BigInteger.valueOf(k).multiply(BigInteger.valueOf(a));
        BigInteger c2 = BigInteger.valueOf(n-(k-k/b)+1).multiply(BigInteger.valueOf(b));

        return c1.compareTo(c2);

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

        BigInteger bByN = BigInteger.valueOf(n).multiply(BigInteger.valueOf(b));
        if(bByN.compareTo(BigInteger.valueOf(a))<=0){
            return bByN.multiply(BigInteger.valueOf(gcd)).divideAndRemainder(BigInteger.valueOf(m))[1].intValue();
        }

        int left = 1;
        int right = n;

        while(right-left>=2){

            int k = left + (right-left)/2;

            System.out.println("(a,b,n,k): "+binarySearchCriteria(a,b,n,k));

            if(binarySearchCriteria(a,b,n,k)<0){
                left = k;
            }else{
                right = k;
            }

        }

        BigInteger c1 = BigInteger.valueOf(left).multiply(BigInteger.valueOf(a));
        BigInteger c2 = BigInteger.valueOf(n-(left-left/b)).multiply(BigInteger.valueOf(b));

        BigInteger c3;

        if(c1.compareTo(c2)>=0){
            c3=c1;
        }else{
            c3=c2;
        }

        ans = c3.multiply(BigInteger.valueOf(gcd)).divideAndRemainder(BigInteger.valueOf(m))[1].intValue();

        return ans;
    }
}
