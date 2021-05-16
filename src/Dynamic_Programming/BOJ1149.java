package Dynamic_Programming;

//BOJ 1149 RGR 거리

/*
문제를 자세히 읽고 이해했다면, 1 2 3을 색칠할 때, 2는 1과 3 색깔과 같을 수 없다. 즉, 1과 3은 색깔이 같아도 된다는 말이다. 그래서 처음에는 위에서 아래로 문제를 읽었다.
즉, 1은 2,3을 가고 또, 2는 1,3을 가면서 규칙성을 찾아보려고 했다. 그래서 중복이 있는 것 같기도 해서 4번째까지 손으로 표를 작성해서 만들어보았는데 점점 가지 수가 많아지면서 규칙성을 찾기 어려웠다.
그래서 문제를 어떻게 접근하는지 힌트를 찾아보았는데, 아래에서 위로 보면 문제가 바로 쉬워진다.

두 번째 행에서(코드에서는 i = 1일 때) 빨간색을 칠할 경우, 그 전 행(첫 번째 행)에서는
빨간색을 칠할 경우엔 j가 1,2만 접근 가능하고,
초록색을 칠할 경우엔 j가 0, 2에만 접근 가능하고,
파란색을 칠할 경우에는 j가 1,2에만 접근이 가능하다.

그래서 정리하자면 N 번째 행에서 빨간색, 초록색, 파란색을 칠할 경우를 나누고, N-1번째 행에서 그 해당 색깔이 아닌 다른 색깔의 arr값과, 해당 N 번째 행에서의 arr값을 더한 것 중 최솟값을 구하면 된다.
*/

import java.io.*;
import java.util.*;

public class BOJ1149 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        int arr[][] = new int[size][3];

        for(int i = 0; i < size; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < size; i++){
            arr[i][0] = arr[i][0] + Math.min(arr[i-1][1], arr[i-1][2]);
            arr[i][1] = arr[i][1] + Math.min(arr[i-1][0], arr[i-1][2]);
            arr[i][2] = arr[i][2] + Math.min(arr[i-1][1], arr[i-1][0]);
        }

        int min = 0;
        min = Math.min(arr[size-1][0], Math.min(arr[size-1][1], arr[size-1][2]));
        System.out.print(min);
    }
}
