package Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int n, K;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = atoi(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = atoi(st.nextToken());
        }

        K = atoi(br.readLine());

        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += binarySearch(i, arr[i]);
        }
        System.out.println(cnt);
    }

    static int binarySearch(int idx, int target) {
        int s = idx + 1, e = n - 1, sum = 0, mid = 0;

        while (s <= e) {
            mid = (s + e) / 2;
            sum = target + arr[mid];

            if(sum > K) e = mid - 1;
            else if(sum == K) return 1;
            else s = mid + 1;
        }
        return 0;
    }
}
