package Graph;

//BOJ 9466 텀 프로젝트

import java.io.*;
import java.util.*;

public class BOJ9466 {
    static ArrayList<Integer>[] arr;
    static boolean visit[];
    static int nV, count;
    static ArrayList<Integer> al;
    public static void main(String[] a) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int test = Integer.parseInt(st.nextToken());

        while(test -- > 0) {
            st = new StringTokenizer(br.readLine());

            nV = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            arr = new ArrayList[nV+1];
            visit = new boolean[nV+1];
            int result = nV;
            for(int i = 1; i < nV+1; i++){
                arr[i] = new ArrayList<>();
            }

            for(int i = 1; i < nV+1; i++) {
                int j = Integer.parseInt(st.nextToken());
                arr[i].add(j);
                //자기 자신을 선택할 경우에
                //바로 팀이 구성되기 때문에 result값에서 1을 빼줌
                if (i == j) {
                    result -= 1;
                    visit[i] = true;
                }
            }

            for(int i = 1; i < nV + 1; i++) {
                if (!visit[i]) {
                    count = 0;
                    al = new ArrayList<>();
                    //방문 한 경우가 없을 경우 dfs를 돌림
                    dfs(i);
                    result -= count;
                }
            }
            System.out.println(result);
        }


    }
    static void dfs(int num){


        //방문했는데 또 방문할 경우
        //ArrayList를 사용하여 다시 방문한 곳 ~ 끝까지 index의 개수를 구함
        //그래야지 팀이 몇명으로 이루어지는지 알 수 있음
        if(visit[num]){
            for(int i = 0; i < al.size(); i++){
                if(al.get(i) == num) {
                    count = al.size() - i;
                    return;
                }
            }
        }

        else {
            visit[num] = true;
            al.add(num);
            int next = arr[num].get(0);
            dfs(next);
        }
    }
}
