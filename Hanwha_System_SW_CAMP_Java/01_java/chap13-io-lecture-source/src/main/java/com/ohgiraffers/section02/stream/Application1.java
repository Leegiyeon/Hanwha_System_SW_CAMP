package com.ohgiraffers.section02.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 입출력 스트림에 대해 이해하고 파일을 대상으로 하는 FileInputStream 을 사용할 수 있다. */

        FileInputStream fin = null;

        try {
            /* Memo. fin은 스트림으로 fin.을 통해 불러오는 기능들은 스트림에서 제공하는 기능이다. */
            fin = new FileInputStream(
                    new File("src/main/java/com/ohgiraffers/section02/stream/testInputStream.txt"));
            int input = 0;
            /* Memo. read()메소드는 int를 반환하므로 문자의 경우 형 변환을 하여 출력한다.(1byte씩 읽어옴) */
            while ((input = fin.read()) != -1) {
                System.out.print((char)input);
            }

        } catch (FileNotFoundException e) {
            System.out.println("해당 파일이 없습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fin.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
