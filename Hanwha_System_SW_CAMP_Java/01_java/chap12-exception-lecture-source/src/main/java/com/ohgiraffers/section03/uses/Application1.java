package com.ohgiraffers.section03.uses;

import java.io.*;
import java.nio.Buffer;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 예외처리를 많이 사용하는 io 패키지에서 사용하는 예외처리 구문을 이해할 수 있다. */
        /* 설명
         *  예외처리를 가장 많이 사용하게 되는 상황에서 try-catch 구문을 실제와 유사하게 해보자.(호출흐름 이해)
        * */

        BufferedReader br = null;

        System.out.println(new File("").getAbsoluteFile());
        /* Memo. 파일의 기본 디렉토리는 프로젝트의 경로*/
        try {
            br = new BufferedReader(new FileReader("test.dat"));

            String s = "";

            while ((s=br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /* 필기
             *  예외처리 구문과 상관없이 반드시 수행해야하는 경우, finally 에 작성하며
             *  보통 사용한 자원을 반납할 목적으로 사용된다.
             * */
            try {
                /* 설명.
                 *  스트림이 생성되지 않았을 때, 접근하여 close()메소드를 호출하게 되면 NullPointException 이 발생할 수 있다.
                 *  (방지를 위해 if 사용)
                * */
                if (br != null) {

                    /* 설명.
                     *  입출력에서 사용한 스트림을 닫아주는 메소드
                     *  API에서 확인해보면 IOException을 throw하는 메소드이기에 finally 블럭 안이어도 예외처리를 추가로 해주어야한다.
                    * */
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
    }
}
