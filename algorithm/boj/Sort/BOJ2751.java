package boj.Sort;

//BOJ 2751 수 정렬하기2

// https://c-king.tistory.com/

/*
이 문제는 카운팅 정렬(계수 정렬)을 이용한 문제였다. 일반적으로 선택 정렬을 사용하게 되면 O(n^2)으로 시간초과가 뜨기 때문이다.
그래서 O(n)인 카운팅 정렬을 이용하여 문제를 풀었다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2751 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(st.nextToken());

        boolean visit[] = new boolean[2000001];

        for(int i = 0; i < test; i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            visit[index + 1000000] = true;
        }

        for(int i = 0; i < visit.length; i++){
            if(visit[i]) sb.append(i - 1000000 + "\n");
        }

        System.out.println(sb);
    }
}
