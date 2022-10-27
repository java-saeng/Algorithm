package boj.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16472 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static int N;
    static int A[];
    static int possible[] = new int[27];
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());
        str = br.readLine();

        pro();
    }

    static void pro() {
        int e = -1, len = Integer.MIN_VALUE, cnt = 0;

        for (int s = 0; s < str.length(); s++) {
            if(s>=1 && possible[str.charAt(s-1) - 'a'] > 0){
                possible[str.charAt(s-1) - 'a']--;
                if(possible[str.charAt(s-1) - 'a'] == 0) cnt--;
            }

            while (e + 1 < str.length() && cnt < N) {
                possible[str.charAt(++e) - 'a']++;

                if(possible[str.charAt(e) - 'a'] == 1) cnt++;
            }

            while(e+1 < str.length() && possible[str.charAt(e+1) - 'a'] > 0){
                possible[str.charAt(++e) - 'a']++;
            }

            len = boj.Math.max(len, e - s + 1);
        }
        System.out.println(len);
    }
}
