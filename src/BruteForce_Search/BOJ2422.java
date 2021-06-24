package BruteForce_Search;

//BOJ 2422 한윤정이 이탈리아에 가서 아이스크림을 사먹는데

import java.io.*;
import java.util.*;

public class BOJ2422 {
    static int atoi(String srt){
        return Integer.parseInt(srt);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = atoi(st.nextToken());
        int no = atoi(st.nextToken());
        int result = 0;

        boolean cannot[][] = new boolean[n+1][n+1];

        for(int i = 0; i < no; i++){
            st = new StringTokenizer(br.readLine());
            int s1 = atoi(st.nextToken());
            int s2 = atoi(st.nextToken());
            cannot[s1][s2] = cannot[s2][s1] = true; //조합하면 안되는 것들은 true
        }

        for(int i = 1; i <= n; i++){
            for(int j = i + 1; j <= n; j++){
                //이 아래 부분이 포인트임
                //여기서 미리 경우의 수를 좁혀서 아래 k와 비교할 떄 경우의 수를 줄여줌
                //만약 해당 코드를 입력하지 않는다면 i, j, k 세 수 중에 두 수를 비교하여 [s1][s2]의 값이
                //true인지 false인지 총 3번 비교할 걸 줄여줌.
                if(cannot[i][j] == false) {
                    for (int k = j + 1; k <= n; k++) {
                        if(cannot[i][k] == false && cannot[j][k] == false) result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
