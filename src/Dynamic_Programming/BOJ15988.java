package Dynamic_Programming;

import java.util.*;
import java.io.*;

public class BOJ15988 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        long dp[] = new long[1000001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i < 1000001; i++){
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1000000009;
        }

        int test = s.nextInt();

        while(test-- > 0){
            int num = s.nextInt();

            System.out.println(dp[num]);
        }
    }
}