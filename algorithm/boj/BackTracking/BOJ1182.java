package boj.BackTracking;

//BOJ 1182 부분 수열의 합

/*
이 문제는 배열을 집합이라 생각하고, 부분 집합들의 원소들의 합이 주어진 합을 만족시키면 count를 ++해주는 방식으로 생각했다.
backTracking 함수를 호출할 때, 인자에 sum을 1222222를 넣었다. 왜냐하면 만약 주어진 합이 0일 때, 처음에 인자를 0으로 보낸다면 count를 늘리고 시작해서 답이 틀리게 된다.
그래서 주어진 조건을 보면 sum은 절댓값 1,000,000보다 작거나 같다고 주어져있어서, 이 조건을 뛰어넘는 숫자를 대입하여 그러한 실수를 방지했다.
 */
import java.io.*;
import java.util.*;

public class BOJ1182 {
    static int[] arr;
    static int resultsum;
    static boolean[] visit;
    static int index;
    static int count = 0;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        index = Integer.parseInt(st.nextToken());
        resultsum = Integer.parseInt(st.nextToken());

        arr = new int[index];
        visit = new boolean[index];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < index; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        backTracking(0,1222222);

        System.out.print(count);
    }
    static void backTracking(int start, int sum){
        if(sum == resultsum) {
            count++;
        }
        if(start >= index) return;

        for(int i = start; i < index; i++){
            if(visit[i]) continue;

            visit[i] = true;
            sum = getsum();
            backTracking(i+1, sum);
            visit[i] = false;
        }
    }
    static int getsum(){
        int sum = 0;
        for(int i = 0; i < index; i++){
            if(visit[i]) sum += arr[i];
        }
        return sum;
    }
}
