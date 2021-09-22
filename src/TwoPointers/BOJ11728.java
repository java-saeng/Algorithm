package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11728 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int sizeA, sizeB;
    static int A[], B[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sizeA = atoi(st.nextToken());
        sizeB = atoi(st.nextToken());

        A = new int[sizeA];
        B = new int[sizeB];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < sizeA; i++) A[i] = atoi(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < sizeB; i++) B[i] = atoi(st.nextToken());

        pro();
    }

    static void pro() {
        int s = 0, e = 0;

        while (s < sizeA && e < sizeB) {
            if(A[s] > B[e]){
                sb.append(B[e]).append(" ");
                e++;
            }
            else if(A[s] < B[e]){
                sb.append(A[s]).append(" ");
                s++;
            }
            else{
                sb.append(A[s]).append(" ");
                sb.append(B[e]).append(" ");
                s++;
                e++;
            }
        }

        if(s == sizeA){
            for (int i = e; i < sizeB; i++) {
                sb.append(B[i]).append(" ");
            }
        }

        if(e == sizeB){
            for (int i = s; i < sizeA; i++) {
                sb.append(A[i]).append(" ");
            }
        }

        System.out.println(sb);
    }
}
