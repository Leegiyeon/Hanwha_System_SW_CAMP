package com.ohgiraffers.section04.dto;

import java.util.Date;

/* 필기.
 *  자바 빈(Java bean)이란
 *   JSP에서 배우게 될 표준 액션 태그로 접근할 수 있게 만든 자바 클래스
 *     자바코드를 모르는 웹퍼블리셔들도 자바를 사용할 수 있도록 태그형식으로 지원하는 문법
 *     그때 사용할 수 있도록 규칙을 지정해 놓은 java 클래스를 java bean 이라고 부른다.
 *
 * 필기.
 *  java bean 작성 규칙.
 *     1. 특정 패키지에 속해있어야 함(default 패키지X)
 *     2. 접근 제어자는 private
 *     3. 기본 생성자가 명시적으로 존재해야함
 *     4. 모든 필드에 접근 가능한 setter, getter이 public으로 작성되어야 함
 *     5. 직렬화를 고려(선택사항)
* */



public class UserDTO {          //Data Transfer Object

    private String id;
    private String pwd;
    private String name;
    private java.util.Date enrollDate;

    public UserDTO() {

    }

    public UserDTO(String id, String pwd, String name, Date enrollDate) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.enrollDate = enrollDate;
    }

    public void setId(String id) {
        this.id = id;
        System.out.println("데이터 세팅 중...");

    }

    public String getId() {
        System.out.println("데이터 불러오는 중...");
        return id;
    }

    /* 설명. 이후 나머지 setter, getter는 단축기를 사용 */
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String forInformation(){
        return id + " " + pwd + " " + name + " " + enrollDate;
    }
}
