package boj.Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7662 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static TreeMap<Integer, Integer> hm = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test_case = atoi(br.readLine());

        for (int test = 0; test < test_case; test++) {
            int n = atoi(br.readLine());
            int s1 = 0, s2 = 0;
            hm.clear();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int order = atoi(st.nextToken());

                if(cmd.equals("I")){
                    hm.put(order, hm.getOrDefault(order, 0) + 1);
                }
                else{
                    if(hm.isEmpty()) continue;

                    int num = 0;
                    if(order == 1){
                        num = hm.lastKey();
                    }
                    else{
                        num = hm.firstKey();
                    }

//                    int cnt = hm.get(num);
//
//                    if(cnt == 1) hm.remove(num);
//                    else hm.put(num, cnt - 1);

                    if(hm.put(num, hm.get(num) - 1) == 1) hm.remove(num);

                    //put은 value를 반환함
                }
            }

            if(hm.isEmpty()) System.out.println("EMPTY");
            else{
                System.out.println(hm.lastKey() + " " + hm.firstKey());
            }
        }
    }
}

