package pl.t32.newmathtools.algorithms;


import java.math.BigInteger;

public class ArithmeticProgression {

    public static BigInteger sum(long a, long d, long n) {
        // ( 2a + d(n-1) ) * n / 2
        BigInteger sum = BigInteger.valueOf(2).multiply(BigInteger.valueOf(a));
        sum = sum.add(BigInteger.valueOf(d)
                .multiply(BigInteger.valueOf(n).subtract(BigInteger.valueOf(1))));
        sum = sum.multiply(BigInteger.valueOf(n));
        sum = sum.divide(BigInteger.valueOf(2));

        return sum;
    }

    public static BigInteger product(long a, long d, long n) {
        BigInteger product = BigInteger.valueOf(a);
        for (long i = 1; i < n; i++) {
            BigInteger tmp = BigInteger.valueOf(i)
                    .multiply(BigInteger.valueOf(d)).add(BigInteger.valueOf(a));
            product = product.multiply(tmp);
        }

        return product;
    }
}
