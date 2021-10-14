package BackTracking;

import java.io.*;
import java.util.*;

public class BOJ1759 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int L, C;
    static char A[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = atoi(st.nextToken());
        C = atoi(st.nextToken());

        A = new char[C + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= C; i++) {
            A[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(A, 1, C + 1);

        pro(1, 1, "");

        System.out.print(sb);
    }

    private static void pro(int start, int cnt, String s) {
        if (cnt == L + 1) {
            if(possible(s)){
                sb.append(s).append("\n");
                return;
            }
        }

        for (int i = start; i <= C; i++) {
            String new_s = s + A[i];
            pro(i + 1, cnt + 1, new_s);
        }
    }

    static boolean possible(String s) {
        int vo = 0, nonvo = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' ||
                    s.charAt(i) == 'i' || s.charAt(i) == 'o' ||
                    s.charAt(i) == 'u') vo++;
            else nonvo++;
        }

        return vo >= 1 && nonvo >= 2;
    }
}
