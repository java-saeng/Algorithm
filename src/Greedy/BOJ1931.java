package Greedy;

//BOJ 1931 회의실 배정

import java.util.*;
import java.io.*;

public class BOJ1931{
    static ArrayList<MeetingPoint> al = new ArrayList<>();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = atoi(st.nextToken());
        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            int s1 = atoi(st.nextToken());
            int s2 = atoi(st.nextToken());
            al.add(new MeetingPoint(s1, s2));
        }
        Collections.sort(al);

        int result = 0;
        int count = 1;
        int end = al.get(0).end;
        for(int i = 1; i < al.size(); i++){
            if(al.get(i).start < end) continue;

            else{
                end = al.get(i).end;
                count++;
            }
        }
        System.out.println(count);
    }
    static int atoi(String str){
        return Integer.parseInt(str);
    }

}

class MeetingPoint  implements Comparable<MeetingPoint>{
    int start, end;

    MeetingPoint(int x, int y){
        start = x;
        end = y;
    }

    @Override
    public int compareTo(MeetingPoint o) {
        if(this.end - o.end == 0){
            return this.start - o.start;
        }
        else
            return this.end - o.end;
    }
}
