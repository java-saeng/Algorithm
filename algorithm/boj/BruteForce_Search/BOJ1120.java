package boj.BruteForce_Search;

import java.io.*;
import java.util.*;

public class BOJ1120 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static String a, b;
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        //최댓값은 모두 다 다를 때
        ans = a.length();

        for (int i = 0; i + a.length() <= b.length(); i++) {
            ans = boj.Math.min(ans, compareTwoString(a, b.substring(i, i + a.length())));
        }

        System.out.println(ans);
    }

    static int compareTwoString(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = st.nextToken();
        b = st.nextToken();

    }
}

