package com.ohgiraffers.section03.filterstream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/* 설명. 객체 출력을 기존파일에 이어쓰기 하고 싶을 때, 헤더가 추가되는 것 때문에 헤더가 생기지 않는 ObjectOutputStream 생성*/
public class MyOutput extends ObjectOutputStream {

    public MyOutput(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        /* 설명. 객체 저장(출력) 시, 헤더에 아무것도 안적히도록 오버라이딩 */
    }
}
