class Solution {
    public int countTriples(int n) {
        int count = 0;

        for (int m = 2; m * m <= n; m++) {
            for (int k = 1; k < m; k++) {

                // primitive triple conditions
                if (((m - k) % 2 == 1) && gcd(m, k) == 1) {

                    int a = m * m - k * k;
                    int b = 2 * m * k;
                    int c = m * m + k * k;

                    if (c > n) break;

                    // generate multiples
                    int multiple = 1;
                    while (multiple * c <= n) {

                        int aa = multiple * a;
                        int bb = multiple * b;

                        if (aa <= n && bb <= n) {
                            // (a,b) and (b,a) are different ordered pairs
                            count += (aa == bb) ? 1 : 2;
                        }

                        multiple++;
                    }
                }
            }
        }

        return count;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}