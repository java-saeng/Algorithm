package Math;

// BOJ 6588 골드바흐의 추측

/*
이 문제를 풀면서 다시 한번 에라토스테네스의 체에 대해 공부하게 됐다. 또한, n의 최댓값이 1,000,000이라고 했다. 그러면 visit배열의 크기를 1,000,001로 해주고,
소수 판별하는 이중 포문도 범위를 1,000,000까지 해줘야 한다. 제곱 수까지 범위를 구해야 한다고 생각하여 처음에 1,001까지 선언해줘서 런타임 에러가 났다.
그리고, printPrimeSum 메소드에서 인자로 받는 num부터 탐색하면 된다. 이것 또한 1,000,000부터 시작해주어 TLE가 났었다.
 */

import java.util.*;
import java.io.*;

public class BOJ6588 {
    static int size = 1000001;
    static boolean[] visit = new boolean[size];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Arrays.fill(visit, true);
        visit[0] = false;
        visit[1] = false;
        for(int i = 2; i < size; i++){
            if(!visit[i]) continue;
            for(int j = 2 * i; j < size; j += i){
                visit[j] = false;
            }
        }

        while(true){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num == 0) break;
            printPrimeSum(num);
        }
    }

    static void printPrimeSum(int num){
        int max = 0, min = 0;
        boolean flag = false;
        for(int i = num; i >= 0; i--){
            if(visit[i]) {
                max = i;

                if(num < max) continue;

                min = num - max;

                if(visit[min]){
                    flag = true;
                    break;
                }
            }
        }
        if(flag)
            System.out.println(num + " = " + min + " + " + max);
        else
            System.out.println("Goldbach's conjecture is wrong");
    }
}
