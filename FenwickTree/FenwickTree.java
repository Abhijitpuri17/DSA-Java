public class FenwickTree {
    long[] bit;
    int n;

    FenwickTree(int n) {
        bit = new long[n + 1];
        this.n = n;
    }

    void update(int ind, long val) {
        while (ind <= n) {
            bit[ind] += val;
            ind += (ind & -ind);
        }
    }

    long getSum(int ind) {
        long sum = 0;
        while (ind > 0) {
            sum += bit[ind];
            ind -= (ind & -ind);
        }
        return sum;
    }

}
