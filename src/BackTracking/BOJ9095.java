package BackTracking;

//BOJ 9095 1, 2, 3 더하기

/*
문제를 다 풀고 나서, 카테고리를 보았는데 dp로 되어있었다. 하지만 처음에는 백트레킹 문제라고 생각하여 백트레킹으로 문제를 해결했다.
값은 어차피 1, 2, 3만 이용할 수 있어, 배열을 만들 때 1, 2, 3으로 바로 초기화를 시켰다. 그리고 중요한 점은 중복이 가능했기 때문에 visit배열을 사용할 필요가 없고,
메소드 인자로 start를 사용하여 시작점을 설정할 필요도 없었다.
문제 해결을 하면서 가장 애먹었던 부분은 메소드를 작성할 때, 1 1 1 1 1을 만족하지 않으면 1 1 1 2로 넘어가는 과정에서, sum값이 계속해서 더해져 갔다.
그래서 resum이라는 변수를 사용하여, 그 해당 메소드 인자인 sum을 저장하였다. 그래서 sum값이 재귀 함수로 인해 다시 돌아와도 계속해서 더해져가지 않고, resum을 이용해 원래의 sum값으로 계산할 수 있었다.
 */
import java.io.*;
import java.util.*;

public class BOJ9095{
    static int arr[] = {1,2,3};
    static int limit, count = 0;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int test = Integer.parseInt(st.nextToken());

        while(test-- > 0){
            st = new StringTokenizer(br.readLine());
            limit = Integer.parseInt(st.nextToken());
            count = 0;
            backTracking(0);
            System.out.println(count);
        }
    }
    static void backTracking(int sum){
        if(sum == limit) count++;
        else if(sum > limit) return;
        for(int i = 0; i < 3; i++){
            int resum = sum;
            resum += arr[i];
            backTracking(resum);
        }
    }
}
