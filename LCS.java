import java.util.Scanner;

public class LongestCommonSubsequence {

    static void lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println("Length of LCS: " + dp[m][n]);

        // Reconstruct sequence
        int i = m, j = n;
        StringBuilder lcsStr = new StringBuilder();
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcsStr.append(X.charAt(i - 1));
                i--; j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println("LCS: " + lcsStr.reverse().toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length of first string: ");
        int len1 = sc.nextInt();
        System.out.print("Enter first string: ");
        String X = sc.next();

        System.out.print("Enter length of second string: ");
        int len2 = sc.nextInt();
        System.out.print("Enter second string: ");
        String Y = sc.next();

        if (X.length() != len1 || Y.length() != len2) {
            System.out.println("Error: Entered string lengths do not match!");
        } else {
            lcs(X, Y);
        }

        sc.close();
    }
}
