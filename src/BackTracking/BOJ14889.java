package BackTracking;

import java.util.*;
import java.io.*;

public class BOJ14889 {
    static int size;
    static int arr[][];
    static boolean visit[];
    static int min = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        arr = new int[size][size];
        visit = new boolean[size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        choiceTeam(0,0);

        System.out.print(min);
    }

    //팀 뽑기 메소드
    static void choiceTeam(int start, int count){
        if(count == size/2){
            diffSum();
            return;
        }

        for(int i = start; i < size; i++){
            if(visit[i]) continue;
            visit[i] = true;
            choiceTeam(i+1,count+1);
            visit[i] = false;
        }

    }

    static void diffSum(){
        int sum_start = 0, sum_link = 0;

        //visit가 true면 start팀, false면 link팀이라 생각

        for(int i = 0; i < size - 1; i++){
            for(int j = i+1; j < size; j++){
                if(visit[i] == true && visit[j] == true){
                    sum_start += arr[i][j];
                    sum_start += arr[j][i];
                }
                else if(visit[i] == false && visit[j] == false){
                    sum_link += arr[i][j];
                    sum_link += arr[j][i];
                }
            }
        }

        int result = Math.abs(sum_start - sum_link);

        if(min > result)
            min = result;
    }
}

