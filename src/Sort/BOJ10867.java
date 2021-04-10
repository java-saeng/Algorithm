package Sort;

//BOJ 10867 중복 빼고 정렬하기

/*
문제에서 중복을 뺀다는 걸 본 순간 Set이 생각났다.
그래서 Set에 입력값을 넣어주고 ArrayList를 Set 데이터 기반으로 만들어 sort를 이용해 오름차순 정렬하였다.
 */

import java.io.*;
import java.util.*;

public class BOJ10867 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();

        int cnt = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < cnt; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> list = new ArrayList<>(set);

        Collections.sort(list);

        for(int index : list)
            sb.append(index + " ");

        System.out.print(sb);
    }
}
