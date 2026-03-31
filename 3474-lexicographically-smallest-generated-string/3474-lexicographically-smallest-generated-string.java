class Solution {
    public String generateString(String S, String t) {
        char[] s = S.toCharArray();
        int n = s.length;
        int m = t.length();
        char[] ans = new char[n + m - 1];
        Arrays.fill(ans, '?');

        // Process T
        int[] z = calcZ(t);
        int pre = -m;
        for (int i = 0; i < n; i++) {
            if (s[i] != 'T') {
                continue;
            }
            int size = Math.max(pre + m - i, 0);
            // The prefix and suffix of t with length size must be equal
            if (size > 0 && z[m - size] < size) {
                return "";
            }
            // Positions after size are all '?', so fill in t
            for (int j = size; j < m; j++) {
                ans[i + j] = t.charAt(j);
            }
            pre = i;
        }

        // Compute the nearest undecided position <= i
        int[] preQ = new int[ans.length];
        pre = -1;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == '?') {
                ans[i] = 'a'; // Initial value for undecided positions is a
                pre = i;
            }
            preQ[i] = pre;
        }

        // Find positions in ans equal to t, using KMP or the Z-function
        z = calcZ(t + new String(ans));

        // Process F
        for (int i = 0; i < n; i++) {
            if (s[i] != 'F') {
                continue;
            }
            // The substring must not equal t
            if (z[m + i] < m) {
                continue;
            }
            // Find the last undecided position
            int j = preQ[i + m - 1];
            if (j < i) { // None exists
                return "";
            }
            ans[j] = 'b';
            i = j; // Jump directly to j
        }

        return new String(ans);
    }

    private int[] calcZ(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[] z = new int[n];
        int boxL = 0; // Left and right boundaries of the z-box (inclusive)
        int boxR = 0;
        for (int i = 1; i < n; i++) {
            if (i <= boxR) {
                z[i] = Math.min(z[i - boxL], boxR - i + 1);
            }
            while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
                boxL = i;
                boxR = i + z[i];
                z[i]++;
            }
        }
        z[0] = n;
        return z;
    }
}