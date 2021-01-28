package BruteForce_Search;

//BOJ 2798 블랙잭

/*
카드의 최대 개수가 100이므로 시간 복잡도를 근거로 하여, 삼중 포문을 사용하여 문제를 풀었다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2798 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int card, limit, sum = 0, result = 0;
        card = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        int []cardarr = new int[card];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < card; i++){
            cardarr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < card; i++){
            for(int j = i+1; j < card; j++){
                for(int k = j+1; k < card; k++){
                    sum = 0;
                    sum += cardarr[i] + cardarr[j] + cardarr[k];
                    if(sum == limit){
                        System.out.println(sum);
                        return;
                    }
                    else if(sum < limit){
                        result = Math.max(result,sum);
                    }
                }
            }
        }
        System.out.println(result);
    }
    //1. 삼중포문 사용해서 i, j = i+1, k = j+1에서 시작해서 sum에 더함
    //2. 만약 limit을 넘지 않으면 result에 저장을 함.
    //3. 그 result을 저장함에 있어서, Math.max를 사용하여 최댓값을 구함.
}
