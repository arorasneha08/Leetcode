class Solution {
    static final int MOD = (int) 1e9 + 7;

    public static long power(long base, long exp) {
        if (exp == 0) return 1;
        long half = power(base, exp / 2);
        long result;
        if (exp % 2 == 0) {
            result = (half * half) % MOD;
        } else {
            result = (half * half % MOD * base) % MOD;
        }
        return result;
    }

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenWays = power(5, evenCount);
        long oddWays = power(4, oddCount);

        return (int)((evenWays * oddWays) % MOD);
    }
}
