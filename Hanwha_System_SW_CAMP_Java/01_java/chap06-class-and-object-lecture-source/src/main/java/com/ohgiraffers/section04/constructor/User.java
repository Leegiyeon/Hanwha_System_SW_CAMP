package com.ohgiraffers.section04.constructor;

import java.util.Date;

public class User {

    private String id;
    private String pwd;
    private String name;
    private java.util.Date enrollDate;

    /* 필기.
     *  생성자 작성 위치
     *   문법상으로 클래스 내부 필드 선언 후, 메소드 선언부 이전에 작성하는 것이 일반적
    * */
    public User() {
        System.out.println("User 객체 생성");
    }

    /* 필기. Alt + Insert : 생성자와 같이 클래스 내부에 필수적으로 들어가는 요소 생성 단축키 */
    public User(String id, String pwd, String name) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
    }

    public User(String id, String pwd, String name, Date enrollDate) {

        /* 필기. 생성자 안의 this.은 해당 생성자를 통ㅎ해 생성될 객체에 접근하는 것 */
        /* 필기. 일반적으로 필드의 변수명과 매개변수명이 동일하므로 반드시 this.을 명시해야 함*/
//        this.id = id;
//        this.pwd = pwd;
//        this.name = name;
        this(id, pwd, name);            // 필기. this() : 위에 있는 다른 생성자를 참고하여 쓸때 사용 단, 하나의 생성자만 활용가능

        this.enrollDate = enrollDate;

//        this(id, pwd, name);          // 필기. 다른 생성자를 사용하는 구문(this())은 반드시 가장 먼저 명시

        System.out.println("모든필드를 초기화 하는 매개변수 있는 생성자를 통해 User 객체 생성");

    }



    public String forInformation() {
        return this.id + ", " + this.pwd + ", " + this.name + ", " + this.enrollDate;
    }

}
