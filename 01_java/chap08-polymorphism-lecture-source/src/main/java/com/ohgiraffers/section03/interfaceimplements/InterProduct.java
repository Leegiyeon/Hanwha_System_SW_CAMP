package com.ohgiraffers.section03.interfaceimplements;

public interface InterProduct extends ParentInterProduct, AnotherParentInterProduct{
    //    private String name;
//    public  String name;
//    public static String name;
//    public static final int MAX_NUM = 100;

    // Memo. (public static final) 생략해도 default로 작성됨
    int MAX_NUM = 100;              // EX) 상품 최대 100개만 저장 가능하고 이 값을 활용하여 조건식 작성

    /* 설명. 인터페이스는 생성자를 가질 수 없다. */
//    public InterProduct(){};

    /* 설명. public 추상메소드만 작성 가능하다. */
//    public abstract void nonStaticMethod();
//    public void nonStaticMethod();
    void nonStaticMethod();         // EX) 규약에 따라 생성하는 메소드

    /* 설명. 하지만 static 메소드는 바디부까지 작성을 허용하였다. (JDK 1.8부터 추가) */
    public static void staticMethod(){
        System.out.println("InterProduct 클래스의 staticMethod 호출됨!!!");
    }

    /* 설명. default 키워드를 사용하면 non-static 메소드로 작성 가능하다. (JDK 1.8부터 추가) */
    public default void defaultMethod(){
        System.out.println("InterProduct 클래스의 defaultMethod 호출됨!!!");
        privateMethod();
    }

    /* 설명. private도 abstract가 아닌 온전한 메소드로 사용은 가능하다. */
    private void privateMethod(){
        /* 설명 다른 public default 메소드에서 활용할 수만 있는 메소드 */
    }

}

