package com.ohgiraffers.chap03.section01.graph_search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Application2 {

    /* 설명. 테스트 코드에서 입력받는 방식을 문제에서 요구하는 대호 작성하고 문자열로 입력 받기 위해 변경한 코드 */
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    static Queue<Node> q = new LinkedList<>();
    static int dirX[] = {0, 0, -1, 1};     // memo. left, right
    static int dirY[] = {-1, 1, 0, 0};     // memo. down, up
    static int map[][];             // memo. 배추밭
    static boolean visit[][];       // memo. 방문한 배추 좌표 배열
    static int cur_x, cur_y;        // memo. 현재 위치 좌표
    static int n, m, k;             // memo. 배추밭 가로 세로, 배추 개수
    static int count;               // memo. 필요한 배추흰지렁이 수(결과 값)


    /* 설명. x와 y좌표를 인지하는 static class */
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static Integer solution(String input) throws IOException {

        BufferedReader br = toBufferedReader(input);
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];

        /* 설명. 배추밭에 배추 심기 */
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());

            /* 설명. 입력받은 x, y 좌표와 배열을 만들 때의 순서(행, 열)는 반대의 개념이다. */
            map[y][x] = 1;
        }

        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (visit[i][j] == false && map[i][j] == 1){
                    count++;
                    bfs(j,i);               // memo. bfs의 인자는 (x,y)로 받을 것이므로 i와 j를 확인하고 넘겨준다.
                }
            }

        }


        return count;
    }

    /* 설명. 상하좌우에 배추가 심어져 있으면 한 번 씩 동작(기번적인 동작 / 방문 배열과는 다른 의미) */
    private static void bfs(int x, int y) {
        q.offer(new Node(x,y));
        visit[y][x] = true;

        /* 설명. 연속적으로 상하좌우에 배추가 심어져 있다면 반복 */
        while (!q.isEmpty()){
            Node node = q.poll();

            /* 설명. 상하좌우 이동 */
            for (int i = 0; i < 4; i++) {
                cur_x = node.x + dirX[i];
                cur_y = node.y + dirY[i];

                /* 설명. 지금 보는 방향이 좌표로써 존재하면서, 방문한 적이 없고, 배추가 심어져 있다면 */
                if (range_check() && visit[cur_y][cur_x] == false && map[cur_y][cur_x] == 1) {
                    q.offer(new Node(cur_x, cur_y));
                    visit[cur_y][cur_x] = true;
                }
            }
        }

    }

    private static boolean range_check() {
        return cur_x >= 0 && cur_x < m && cur_y >= 0 && cur_y < n;
    }
}
