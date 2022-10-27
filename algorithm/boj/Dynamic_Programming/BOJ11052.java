package boj.Dynamic_Programming;

import java.util.*;
import java.io.*;

public class BOJ11052 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = atoi(br.readLine());

        int arr[] = new int[size+1];
        int dp[] = new int[size+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= size; i++){
            arr[i] = atoi(st.nextToken());
        }

        /////////////////////////////////////////입력 끝

        for(int i = 1; i <= size; i++){
            for(int j = 0; j < i; j++){
                dp[i] = boj.Math.max(dp[i], dp[j] + arr[i-j]);
            }
        }

        System.out.println(dp[size]);
    }
}
