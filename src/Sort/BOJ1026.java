package Sort;

//BOJ 1026 보물

// https://c-king.tistory.com/

/*
이 문제를 풀면서 처음에 이진 탐색과 upperbound에 대해 생각하면서 풀었다.
왜냐하면 index를 바꿔야 하는 줄 알고 문제를 해석했다. 그래서 시간 복잡도가 50^50까지 생각되어 이분 탐색을 생각했다.
그러나 문제를 다시 읽어보니 최솟값만 구하면 되는 것이었다.
그래서 A와 B 배열을 정렬한 뒤에, A의 첫 번째 index, B의 마지막 index 순차대로 곱하면서 더해주어 문제를 해결했다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1026 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = Integer.parseInt(br.readLine());
        int sum = 0;
        int arrA[] = new int[cnt];
        int arrB[] = new int[cnt];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cnt; i++)
            arrA[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cnt; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        for(int i = 0; i < cnt; i++){
            sum += arrA[i] * arrB[cnt - i - 1];
        }

        System.out.println(sum);
    }
}
