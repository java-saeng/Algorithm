package BruteForce_Search;

//BOJ 10448 유레카 이론

/*
math 배열의 크기를 44로 제한할 수 있었던 근거는, K가 1000이 넘지 않기 때문에, Tn의 최댓값이 1000을 넘을 수 없다는 뜻이다.
]그래서 K가 43일 때 최댓값을 갖기 때문에 크기를 44로 제한할 수 있었다.
그리고 countarr이 제시된 K이고, result는 countarr이 sum과 같게 되면 1 또는 0으로 나타내는 배열이다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10448 {
    static int countarr[];
    static int result[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());

        countarr = new int[count];
        result = new int[count];

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            countarr[i] = Integer.parseInt(st.nextToken());
        }

        int math[] = new int[44];

        for (int i = 1; i < 44; i++) {
            math[i] = (i * (i + 1)) / 2;
        }


        for (int i = 1; i < 44; i++) {
            for (int j = 1; j < 44; j++) {
                for (int k = 1; k < 44; k++) {
                    int sum = 0;
                    sum += math[i] + math[j] + math[k];
                    matching(sum);
                }
            }
        }

        for (int i = 0; i < countarr.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static void matching(int sum) {
        for (int i = 0; i < countarr.length; i++) {

            if (result[i] != 1) {
                if (countarr[i] == sum) {
                    result[i] = 1;
                } else {
                    result[i] = 0;
                }
            }
        }
    }
}
