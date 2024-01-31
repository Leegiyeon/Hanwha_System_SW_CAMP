package com.ohgiraffers.chap03.section01.graph_search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Application3 {
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    static Queue<Application2.Node> q = new LinkedList<>();
    static int dirX[] = {0, 0, -1, 1};     // memo. left, right
    static int dirY[] = {-1, 1, 0, 0};     // memo. down, up
    static int map[][];
    static boolean visit[][];       // memo. 방문한 좌표 배열
    static int n, m;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];

        /* 설명. 입력값이 공백없이 이어서 들어옴에 따라 한 문자 씩 뜯어어 int 배열(map)에 옮겨담는 반복문 */
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            char[] ch = str.toCharArray();

            for (int j = 0; j < ch.length; j++) {
                map[i][j] = Character.getNumericValue(ch[j]);
            }
        }

        visit[0][0] = true;
        bfs(0, 0);

        return map[n-1][m-1];
    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node node = q.poll();

            /* 설명. 상하좌우를 둘러보는 개념의 for문(벽이 있는지, 지나온 길인지 확인)*/
            for (int i = 0; i < 4; i++) {
                int curX = node.x + dirX[i];
                int curY = node.y + dirY[i];

                // 설명. 지금 좌표가 범위를 벗어난 경우
                if (curX < 0 || curY < 0 || curX >= n || curY >= m) {
                    continue;
                }
                // 설명. 방문했거나 벽이면
                if (visit[curX][curY] || map[curX][curY] == 0) {
                    continue;
                }
                // 설명. 가야할 방향의 좌표를 queue에 쌓는다.
                q.add(new Node(curX, curY));
//                System.out.println("mapCurrent: " + map[curX][curY] + ", X: " + curX + ", Y: " + curY);
                map[curX][curY] = map[node.x][node.y] + 1;
                System.out.println("mapAfer: " + map[curX][curY] + ", X: " + curX + ", Y: " + curY);
                visit[curX][curY] = true;
            }
        }
    }
}

