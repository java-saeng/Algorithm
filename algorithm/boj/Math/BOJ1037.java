package boj.Math;

// BOJ 1037 약수

import java.io.*;
import java.util.*;

public class BOJ1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int cnt = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int arr[] = new int[cnt];
        for(int i = 0; i < cnt; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max)
                max = arr[i];
            if(arr[i] < min)
                min = arr[i];
        }

        int result = min * max;
        System.out.print(result);

    }
}