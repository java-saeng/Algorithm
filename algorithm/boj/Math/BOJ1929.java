package boj.Math;

// BOJ 1929 소수 구하기

import java.io.*;
import java.util.*;

public class BOJ1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        boolean visit[] = new boolean[num2+1];
        Arrays.fill(visit, true);
        visit[0] = false;
        visit[1] = false;
        for(int i = 2; i <= num2; i++){
            if(visit[i] == false) continue;

            for(int j = 2 * i; j <= num2; j += i)
                visit[j] = false;
        }

        for(int index = num1; index <= num2; index++){
            if(visit[index]) sb.append(index + "\n");
        }
        System.out.print(sb);
    }

}
