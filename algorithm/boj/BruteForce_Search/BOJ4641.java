package boj.BruteForce_Search;

//BOJ 4641 Doubles

/*

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ4641 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            int cnt = 0;
            int i = 0;
            int num[] = new int[16];
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int token = Integer.parseInt(st.nextToken());
                if(token == -1) return;
                num[i] = token;
                i++;
            }
            Arrays.sort(num);
            for(int j = 0; j < 16; j++){
                for(int k = j; k < 16; k++){
                    if(num[j] == 0 || num[k] == 0) continue;
                    if(num[k] == num[j] * 2)
                        cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
    //1.hasmoretokens을 이용해 배열에 입력된 숫자들을 전부 넣는다.
    //2.배열을 정렬하고, 항상 앞에는 0 이 있기 때문에 1부터 시작하면 된다.
    //3. 2배인 수가 있으면 cnt++해주고, 마지막에 숫자 하나를 받아서 -1이면 while문을 break한다.
}
