package com.ohgiraffers.chap03.section01.graph_search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Application4 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    static boolean visit[];       // memo. 방문한 좌표 배열
    static int arr[][];
    static int node, line, start;
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();


    public static String solution(String input) throws IOException {
        // memo. 2번째 이후 Test Code 실행 시, 문자열 넘어오면 누적된 앞의 값을 지워주는 코드
        sb.delete(0, sb.length());

        BufferedReader br = toBufferedReader(input);
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        node = Integer.valueOf(str1.nextToken());
        line = Integer.valueOf(str1.nextToken());
        start = Integer.valueOf(str1.nextToken());

        arr = new int[node + 1][node + 1];
        visit = new boolean[node + 1];


        for (int i = 0; i < line; i++) {
            StringTokenizer str2 = new StringTokenizer(br.readLine());

            int a = Integer.valueOf(str2.nextToken());
            int b = Integer.valueOf(str2.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(start);
        sb.append("\n");

        // 설명. dfs 할 때, visit 배열을 활용하기 때문에 아래 bfs 를 위해 false로 채워진 boolean[] 초기화
        visit = new boolean[node + 1];

        bfs(start);

        // memo. StringBuilder > String: toString()
        return sb.toString();
    }



    private static void dfs(int start) {

        visit[start] = true;
        sb.append(start + " ");

        // memo. node 번호와 index가 같은 체계이기에 for 조건문에 '='을 추가해야한다.
        for (int i = 1; i <= node; i++) {
            if (arr[start][i] == 1 && !visit[i]){
                dfs(i);
            }
        }
    }



    private static void bfs(int start) {
        q.add(start);
        visit[start] = true;

        while (!q.isEmpty()){
            start = q.poll();
            sb.append(start+ " ");

            // memo. node 번호와 index가 같은 체계이기에 for 조건문에 '='을 추가해야한다.
            for (int i = 1; i <= node; i++) {
                if (arr[start][i] == 1 && !visit[i]){
                    q.add(i);
                    visit[i] = true;
                }

            }
        }
    }
}
