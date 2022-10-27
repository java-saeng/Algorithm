package boj.TwoPointers;

import java.io.*;
import java.util.*;

public class BOJ2461 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M;
    static ArrayList<Student> al = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        Collections.sort(al, (o1, o2)->{
            return o1.abil - o2.abil;
        });

        int s = 0, e = 0;
        int count[] = new int[N];
        int min = al.get(al.size() - 1).abil - al.get(0).abil;
        count[al.get(0).cls] += 1;
        int cnt = 1; //각 학급이 모두 들어가있는지 확인

        while (true) {
            //각 학급의 대표자들이 1명씩 뽑힌 상황
            if (cnt == N) {
                min = boj.Math.min(min, al.get(e).abil - al.get(s).abil);
                count[al.get(s).cls] -= 1;
                if(count[al.get(s).cls] == 0) cnt--;
                s++;
            } else if (cnt < N) {
                e++;
                if(e == al.size()) break;

                if(count[al.get(e).cls] == 0){
                    cnt++;
                }
                count[al.get(e).cls] += 1;
            }
        }
        System.out.println(min);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int abli = atoi(st.nextToken());
                al.add(new Student(abli, i));
            }
        }

    }
    static class Student{
        int abil, cls;

        public Student(int abil, int cls) {
            this.abil = abil;
            this.cls = cls;
        }
    }
}
