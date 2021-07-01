package BruteForce_Search;

import java.io.*;
import java.util.*;

public class BOJ5568 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    static Set<String> set;
    static String arr[];
    static boolean visit[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = atoi(st.nextToken()); //카드 갯수

        st = new StringTokenizer(br.readLine());

        int k = atoi(st.nextToken()); //뽑는 갯수

        set = new HashSet<>();
        arr = new String[n];
        visit = new boolean[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
        }

        perm("", k, 0);

        System.out.print(set.size());

    }
    //순열을 사용
    static void perm(String str, int pick, int count){
        if(count == pick){
            set.add(str);
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(visit[i]) continue;

            visit[i] = true;
            perm(str + arr[i], pick, count + 1);
            visit[i] = false;
        }
    }
}
