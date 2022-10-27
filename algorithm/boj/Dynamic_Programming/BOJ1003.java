package boj.Dynamic_Programming;

//BOJ 1003 피보나치 함수

/*
처음에 피보나치 문제여서 쉬울 줄 알았다. 그러나 일반적으로 많이 사용하는 재귀 함수를 통해 이 문제를 풀게 되면 TLE가 나온다.
그래서 시간제한이 0.25초인 것을 보고, 절대 재귀 함수를 사용하면 안 된다라는 생각이 들었다.  그래서 포문을 사용하여 문제를 해결해야 한다.
피보나치는 f(n) = f(n-1) + f(n-2)이다. 하지만 일반적인 숫자들 말고, 0과 1도 이 규칙성을 따른다.
그래서 이차원 배열을 만들어 최대 N이 40이기 때문에 40까지 0과 1의 개수를 다 구한 뒤, 입력 값에 맞게 0과 1의 개수를 출력했다.
 */

import java.util.*;
import java.io.*;

public class BOJ1003 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int test = Integer.parseInt(st.nextToken());
        int arr[][] = new int[41][2];
        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;
        for(int i = 2; i < 41; i++){
            arr[i][0] = arr[i-2][0] + arr[i-1][0];
            arr[i][1] = arr[i-2][1] + arr[i-1][1];
        }
        while(test-- > 0){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            System.out.println(arr[num][0] + " " + arr[num][1]);
        }
    }

}