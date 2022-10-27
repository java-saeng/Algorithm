package boj.BackTracking;

// BOJ 9663 N-Queen

/*
퀸은 자신의 행, 열, 대각선에 공격을 할 수 있다. 따라서 퀸이 있는 열, 행에는 하나밖에 존재할 수 없다.
즉, 한 행에 퀸이 하나밖에 존재할 수 없다.(물론 한 열에도 퀸이 하나밖에 존재할 수 없다.)

1. 그래서 depth를 통해서 한 행 한 행 넘어가는데, 여기서 depth가 가리키는 게 size이면 index를 뛰어넘게 된다(크기가 size 배열이기 때문)
이 말은 즉, 퀸이 한 행에 한 개씩 잘 분포되어있다는 뜻으로 경우의 수가 하나 늘어나게 된다.

2. 여기서 이제 백트래킹이 시작된다. 첫 번째로, 0번째 행부터 시작한다. 0번째 행에 0열부터 size 열까지 퀸을 넣는다.
넣을 때마다 isRangeTrue라는 메소드를 통해 검사를 하고, true가 되면 다음 행으로 넘어가게 된다.
이 부분이 중요한 이유는 이 코드에 의하여(검사) dfs와 백트래킹의 차이를 나타낸다.
백트래킹은 다음으로 넘어가기 전에 검사를 실시하고, true면 그다음을 진행하고 아니면 그 전으로 돌아와 다른 곳으로 넘어간다.

3. 범위를 검사하는 isRangeTrue 메소드이다. 이 메소드는 퀸이 같은 열에 존재하는지, 대각선에 있는지 확인한다.
처음에 boolean형 변수 flag를 true로 초기화한다. 그리고 앞 행까지 검사를 실시한다. 여기서 arr의 값은 열을 나타내므로,
 if문 조건식을 보면 같은 열에 있거나, 대각선에 위치하면 false를 나타낸다. 대각선을 나타내는 방법은 행의 차이와 열의 차이가 같으면 대각선에 있는 것을 알 수 있다.
 그리고 절댓값을 사용하여 우상, 우하, 왼상, 왼하를 구분할 필요가 없어진다.
 */

import java.io.*;
import java.util.*;

public class BOJ9663 {
    static int arr[];
    static int size;
    static int count = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        arr = new int[size];

        backTracking(0);

        System.out.println(count);
    }

    static boolean isRangeTrue(int row){
        //3
        boolean flag = true;

        for(int i = 0; i < row; i++){
            if(arr[row] == arr[i] || boj.Math.abs(row-i) == boj.Math.abs(arr[row] - arr[i]))
                flag = false;
            //같은 열에 있거나 대각선에 있을 때 false
        }
        return flag;
    }

    static void backTracking(int depth){
        //1
        if(depth == size){
            count++;
            return;
        }

        for(int i = 0; i < size; i++){
            //2
            arr[depth] = i;
            if(isRangeTrue(depth)){ //이 부분이 백트래킹과 dfs의 차이를 나타냄.
                backTracking(depth + 1);
            }
        }
    }
}
