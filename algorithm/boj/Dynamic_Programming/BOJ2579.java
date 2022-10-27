package boj.Dynamic_Programming;

//BOJ 2579 계단 오르기

/*
힌트를 보면서 어떻게 이런 규칙을 찾을 수 있지라는 생각이 들었다. dp는 특정 공식이나 풀이 방법이 있는 것이 아니라 반복된 연산을 피하기 위해서 사용하는 알고리즘이라 생각한다.
그래서 규칙성 찾는 것도 필요하다. 이 문제를 통해 아 이런 규칙도 있구나라는 경험을 하게 됐다.
 */

import java.util.*;
import java.io.*;

public class BOJ2579{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int staircnt = Integer.parseInt(st.nextToken());

        int stair[] = new int[staircnt+1];
        int score[] = new int[staircnt+1];

        for(int i = 1; i <= staircnt; i++){
            st = new StringTokenizer(br.readLine());
            stair[i] = Integer.parseInt(st.nextToken());
        }

        score[0] = 0;
        score[1] = stair[1];
        if(staircnt >= 2) score[2] = stair[1] + stair[2];

        for(int i = 3; i <= staircnt; i++){
            score[i] = boj.Math.max(score[i-2] + stair[i], stair[i] + stair[i-1] + score[i-3]);
        }

        System.out.println(score[staircnt]);

    }
}