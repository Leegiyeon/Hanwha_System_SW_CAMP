package com.ohgiraffers.section03.filterstream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. BufferedWriter와 BufferedReader에 대해 이해하고 사용할 수 있다. */
        /* 필기.
         *  내부적으로 버퍼를 활용해서 입출력 성능을 향상시킨다.
        * */

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("src/main/java/com/ohgiraffers/section03/filterstream/testBuffered.txt"));

            bw.write("문자열 입력합니다.");


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bw != null) bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
