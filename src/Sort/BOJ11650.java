package Sort;


//BOJ 11650 좌표 정렬하기

/*
comparable과 comparator를 모두 사용하여 문제를 해결해보았다.
comparator를 사용할 때는 sort메소드에 comparator 클래스 참조 변수를 만들어서 인자로 넣어줘야 하고, comparable를 사용할 때는 sort메소드에 인자로 넣어주지 않아도 된다.
왜 이러는지 공부를 해보아야겠다. 둘의 차이가 무엇인지 잘 모르겠다.
comparator를 구현하는 방법은 익명 클래스 또는 클래스 하나를 만들어 comparator를 구현하는 방법이 있고,
comparable은 클래스에 바로 구현해서 오버라이딩 하면 되는 것 같다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11650 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());

        List<Point> list = new ArrayList<>();

        for(int i = 0; i < cnt; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x,y));
        }
        MyComparator mc = new MyComparator();
        Collections.sort(list,mc);

        for(Point index : list){
            System.out.println(index.x + " " + index.y);
        }
    }
}

class Point{
    int x,y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class MyComparator implements Comparator<Point>{
    @Override
    public int compare(Point p1, Point p2){
        if(p1.x == p2.x) return p1.y - p2.y;
        else return p1.x - p2.x;
    }
}
