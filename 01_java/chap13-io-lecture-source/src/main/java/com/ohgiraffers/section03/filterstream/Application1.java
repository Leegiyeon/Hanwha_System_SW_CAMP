package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. BufferedWriter와 BufferedReader에 대해 이해하고 사용할 수 있다. */
        /* 필기.
         *  내부적으로 버퍼를 활용해서 입출력 성능을 향상시킨다.
        * */

        /* 설명. BufferedWriter로 입력하기 */
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(
                    new FileWriter("src/main/java/com/ohgiraffers/section03/filterstream/testBuffered.txt", true));

            bw.write("===입력 확인===\n");
            bw.write("문자열 입력합니다.\n");
            bw.write("문자열 입력됐습니다.\n");

            bw.flush();     // Memo. Buffer는 내부 공간이 가득 차지않으면 데이터 입력값을 넘기지 않는다. 그래서 필요한 지점에서 flush를 호출한다.

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bw != null) bw.close(); // Memo. close 실행 시, flush 실행
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /* 설명. BufferedReader로 한 줄(\n 전까지)씩 읽어오기 */
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new FileReader("src/main/java/com/ohgiraffers/section03/filterstream/testBuffered.txt"));

            String str = null;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
