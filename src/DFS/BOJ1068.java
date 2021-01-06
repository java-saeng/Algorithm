package DFS;

//BOJ 1068 트리

/*
이 문제를 처음에 접했을 때는 그림 2과 같은 경우밖에 생각을 하지 못했다.
그림 2는 -1, 즉, root 노드가 하나만 나올 경우이다. 그래서 처음에는 dfs_start라는 변수에 -1 이 나오면 그 때의 i값을 dfs_start에 저장하여 dfs 메소드를 돌렸다.
하지만 그럴 경우에는 그림 1을 충족시키지 못한다. 그림 1은 root노드가 두 개일 경우이다. 문제에서는 root노드가 몇 개인지 개수가 정해지지 않았기 때문에 이러한 경우도 생각해주어야 한다.
 */

import java.util.*;
import java.io.*;
public class BOJ1068 {
    static boolean[]visit;
    static ArrayList<Integer> []ad;
    static int nV; //노드의 개수
    static int leaf_Node;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int delete_num;
        int delete_numIndex;
        nV = Integer.parseInt(st.nextToken());
        int start_dfs[] = new int[nV];      //예시만 0에서 시작하는거지 다른 노드에서도 시작할 수가 있음
        visit = new boolean[nV];
        ad = new ArrayList[nV];
        int leaf_Node_sum = 0;

        for(int i = 0; i < nV; i++)
            ad[i] = new ArrayList<>();
        st = new StringTokenizer(br.readLine());    //부모노드에서 자식노드로 direct 노드를 생성함

        for(int i = 0; i < nV; i++){
            int t1 = Integer.parseInt(st.nextToken());
            if(t1 == -1)
                start_dfs[i] = t1;                     //-1인 노드는 root노드
            else
                ad[t1].add(i);
        }

        st = new StringTokenizer(br.readLine());    //삭제할 노드
        delete_num = Integer.parseInt(st.nextToken());

        //root 노드를 삭제할 때
        for(int i = 0; i < nV; i++){
            int k = 0;
            if(start_dfs[i] == -1) {         //만약에 delete_num이 root노드일 경우에는
                k = i;                       //ad[delete_num] 부분을 clear 메소드를 사용해 아예 비워버린다
                if(k == delete_num) {        //그리고 start_dfs배열에서의 index도 지워주어야한다
                    ad[k].clear();
                    start_dfs[k] = 0;
                }
            }
        }

        //root 노드가 아닌 것을 삭제 할 때
        for(int i = 0; i < nV; i++){
            if(ad[i].contains(delete_num)) {        //contains 메소드는 이 숫자가 그 배열안에 있으면 true 반환
                delete_numIndex = ad[i].indexOf(delete_num);    //indexOf은 숫자가 어느 index인지 반환
                ad[i].remove(delete_numIndex);      //그 해당 index에 있는 값 삭제
            }
        }

        for(int i = 0; i < nV; i++){
            leaf_Node = 0;
            if(start_dfs[i] == -1) {
                dfs(i);
                leaf_Node_sum += leaf_Node;
            }
        }

        System.out.println(leaf_Node_sum);
    }

    static void dfs(int start){
        visit[start] = true;
        if(ad[start].isEmpty()) {       //ad[start] 가 비어있으면 리프노드이므로 ++시킴
            leaf_Node++;
            return;
        }
        for(int index : ad[start])
            if(!visit[index])
                dfs(index);
    }
}
