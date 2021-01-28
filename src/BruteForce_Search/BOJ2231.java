package BruteForce_Search;

//BOJ 2231 분해합
/*
이 문제를 처음 풀 때, %와 / 연산자를 이용해서 각 자리 숫자합을 더하는 방법은 알고 있었다.
그러나 처음 숫자, 즉 259는 259 + 2 + 5 + 9인데, 259를 어떻게 표현할지 계속 생각해보았다. 물론 이렇게도 풀 수 있지만, 풀고 나서 더욱 간단하게 할 수도 있다.
그리고, 출력에 있어서 k를 출력해야 하는데 계속해서 result를 출력하려고 했다. 문제를 풀면서 더욱더 신중하게 읽어야겠다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2231 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int k = 1;
        int moc = 0;
        int result = 0;
        while(true){
            int sum = 0;
            sum += k;
            for(int i = k; i < N; i /= 10){
                if(i <= 0) break;
                moc = i % 10;
                sum += moc;
            }
            if(k >= N) {
                break;
            }
            if(sum == N){
                result = sum;
                break;
            }
            k++;
        }
        if(result != 0)
            System.out.println(k);
        else
            System.out.println(result);
    }
    /*
    1. 자연수 N과 같아지면 반복문 바로 종료 -> 최솟값이라 했다.
    2. 반복문 구성
    2-1. i가 0이 되면 반복문 종료
    2-2. 처음에 i를 sum에 더하고, i % 10 더하고, i /10을 함
     */
}
