package Sort;

//BOJ 10989 수 정렬하기 3

// https://c-king.tistory.com/

/*
이 문제는 카운팅 정렬(계수 정렬)을 이용한 문제였다. 수 정렬하기 2 문제랑 다른 것은 중복되는 숫자가 있다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10989 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(st.nextToken());

        int count[] = new int[10001];

        for(int i = 0; i < test; i++){
            st = new StringTokenizer(br.readLine());
            count[Integer.parseInt(st.nextToken())]++;
        }

        for(int i = 1; i < count.length; i++){
            int limit = count[i];
            while(limit > 0){
                sb.append(i + "\n");
                limit--;
            }
        }

        System.out.println(sb);
    }
}
