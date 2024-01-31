package com.ohgiraffers.chap03.section01.graph_search;

import java.io.*;
import java.util.StringTokenizer;

public class Application1 {

    static boolean[] visit;
    static int[][] map;
    static int count = 0;
    static int node, edge;

    /* 설명. 테스트 코드에서 입력받는 방식을 문제에서 요구하는 대호 작성하고 문자열로 입력 받기 위해 변경한 코드 */
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    /* 설명. 문제에서 요구하는 입력 값을 받아 감염된 컴퓨터의 갯수(int/Integer)를 반환하는 메소드 */
    public static Integer solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        node = Integer.valueOf(br.readLine());
        edge = Integer.valueOf(br.readLine());

        /* 설명. 노드와 간선에 대한 정보가 담길 map을 작성(node 갯수에 기반한 int 형 2차원 배열 */
        map = new int[node + 1][node + 1];      // node 의 번호와 인텍스 위치를 일치시키기 위해 크기 1 증가

        /* 설명. 방문배열 작성(방문했던 node를 다시 stack에 담지 않거나 재귀함수 호줄을 하지 않도록 생성) */
        visit = new boolean[node + 1];          // 방문배열도 node 의 번호와 인텍스 위치를 일치시키기 위해 크기 1 증가

        /* 설명. 인접리스트(map)로 그래프에 대한 정보 작성 */
        for (int i = 0; i < edge; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.valueOf(str.nextToken());
            int b = Integer.valueOf(str.nextToken());

            /* 설명. 무방향 그래프로 처리하기 위해 노들 번호(인데스 번호)들을 반대로도 적용한다. */
//            map[a][b] = 1;
//            map[b][a] = 1;
            map[a][b] = map[b][a] = 1;
        }

        /* 설명. dfs 그래프 탐색기법으로 1번 노드부터 1번노브와 관련된 모든 노드들을 카운팅 */
        dfs(1);

        return count - 1;
    }

    /* 설명. 재귀함수로 dfs 알고리즘 구현할 메소드 */
    public static void dfs(int start) {
        visit[start] = true;
        count++;

        /* 설명. 넘어온 노드와 연관된 노드를 찾는 반복문(기존에 방문하지 않은 노드) */
        for (int i = 1; i < node; i++) {
            if (map[start][i] == 1 && !visit[i]){
                dfs(i);
            }
        }

    }
}
