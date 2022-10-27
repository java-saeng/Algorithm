package boj.BruteForce_Search;

//BOJ 1668 트로피 진열

/*
처음에 max를 구해서 배열끼리 비교할 때, height[i] < height[i-1] 이런 식으로 접근을 했지만, 답이 나오질 않아 무엇이 문제인지 생각하는데 꽤 시간이 걸렸다.
그래서 max값을 이용해 비교하였더니 문제가 풀렸다. 아직 컴퓨터적 사고가 부족해서 그런 것 같다. 완전 탐색 문제를 많이 풀어 컴퓨터적 사고를 길러야 함을 느꼈다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1668 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //트로피 개수
        int result_left = 1;
        int result_right = 1;
        int max_left = 0;
        int max_right = 0;
        int height[] = new int[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            height[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N-1; i++){
            if(max_left < height[i])
                max_left = height[i];

            if(max_left < height[i+1]){
                result_left++;
                max_left = height[i+1];
            }
        }

        for(int i = N-1; i > 0; i--){
            if(max_right < height[i])
                max_right = height[i];

            if(max_right < height[i-1]){
                result_right++;
                max_right = height[i-1];
            }
        }
        System.out.println(result_left + "\n" + result_right);
    }
    /*
    1. 처음에 max를 구한 뒤에, 다음 index가 max보다 크면 result++해줌
     */
}
