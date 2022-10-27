package boj.Sort;

//BOJ 11651 좌표 정렬하기 2

/*
comparable과 comparator를 이해하고 문제를 풀어 쉽게 풀렸다. 이 문제를 풀면서 느낀 점은 comparator를 익명 클래스로 사용하여 문제를 해결한다면 더욱 간결하게 풀 수 있다.
그래서 둘 중 어느 방법이 더 간단한지 문제에 따라 다르기 때문에 잘 생각하고 선택해야 한다.
*/

import java.io.*;
import java.util.*;

public class BOJ11651 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());

        List<Point2> list = new ArrayList<>();

        for(int i = 0; i < cnt; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point2(x,y));
        }

        Comparator<Point2> comparator = new Comparator<Point2>() {
            @Override
            public int compare(Point2 o1, Point2 o2) {
                if(o1.y == o2.y) return o1.x - o2.x;
                else return o1.y - o2.y;
            }
        };

        Collections.sort(list,comparator);

        for(Point2 index : list)
            System.out.println(index.x + " " + index.y);
    }
}

class Point2{
    int x, y;
    Point2(int x, int y){
        this.x = x;
        this.y = y;
    }
}
