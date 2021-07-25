package Dynamic_Programming;

import java.io.*;

public class BOJ2579_2{
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = atoi(br.readLine());
        int arr[] = new int[size+1];

        for (int i = 1; i <= size; i++) {
            arr[i] = atoi(br.readLine());
        }

        int dp[][] = new int[size+1][2];

        dp[1][0] = 0;
        dp[1][1] = arr[1];

        if (size >= 2) {
            dp[2][0] = arr[2];
            dp[2][1] = arr[1] + arr[2];
        }

        for (int i = 3; i <= size; i++) {
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + arr[i];
            dp[i][1] = dp[i - 1][0] + arr[i];
        }

        System.out.println(Math.max(dp[size][0], dp[size][1]));
    }
}
