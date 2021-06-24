package BruteForce_Search;

//BOJ 1969 DNA

import java.util.*;
import java.io.*;

public class BOJ1969{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); //문자열 갯수
        int m = Integer.parseInt(st.nextToken()); //문자열 길이
        String []arr = new String[n];


        for(int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
        }

        for(int i = 0; i < m; i++){
            String str = "";
            for(int j = 0; j < n; j++){
                str += String.valueOf(arr[j].charAt(i));
            }
            sb.append(maxChar(str));
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(sb.charAt(j) != arr[i].charAt(j))
                    cnt++;
            }
        }

        sb.append("\n" + cnt);
        System.out.println(sb);
    }

    static String maxChar(String str){
        int cnt[] = new int[4];
        int max =  0;
        int idx = 0;
        for(int i = 0; i < str.length(); i++){
            switch(str.charAt(i)){
                case 'A':
                    cnt[0]++;
                    break;
                case 'C' :
                    cnt[1]++;
                    break;
                case 'G':
                    cnt[2]++;
                    break;
                case 'T':
                    cnt[3]++;
                    break;
            }
        }

        for(int i = 0; i < 4; i++){
            if(max < cnt[i]){
                max = cnt[i];
                idx = i;
            }
        }

        switch(idx){
            case 0 :
                return "A";
            case 1:
                return "C";
            case 2:
                return "G";
            case 3:
                return "T";
        }
        return "";
    }
}
