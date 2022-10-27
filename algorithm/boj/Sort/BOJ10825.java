package boj.Sort;

//BOJ 10825 국영수

import java.util.*;
import java.io.*;

public class BOJ10825 {

    static int atoi(String str){
        return Integer.parseInt(str);
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int test = atoi(st.nextToken());
        ArrayList<Student> student = new ArrayList<>();
        for(int i = 0; i < test; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = atoi(st.nextToken());
            int eng = atoi(st.nextToken());
            int math = atoi(st.nextToken());

            student.add(new Student(name, kor, eng, math));
        }

        Collections.sort(student);

        for(Student stu : student){
            System.out.println(stu.name);
        }

    }
}

class Student implements Comparable<Student>{
    String name;
    int korScore, mathScore, engScore;

    Student(String n, int k, int e, int m){
        name = n;
        korScore = k;
        engScore = e;
        mathScore = m;
    }

    @Override
    public int compareTo(Student o) {
        if(korScore != o.korScore)
            return o.korScore - korScore;
        if(engScore != o.engScore)
            return engScore - o.engScore;
        if(mathScore != o.mathScore)
            return o.mathScore - mathScore;

        return name.compareTo(o.name);
    }
}