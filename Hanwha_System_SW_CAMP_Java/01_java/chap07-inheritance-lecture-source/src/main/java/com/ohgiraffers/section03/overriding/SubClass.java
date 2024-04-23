package com.ohgiraffers.section03.overriding;

public class SubClass extends SuperClass {
    /* 설명. 부모 메소드와 이름, 반환형, 매개변수, 접근제어자 모두 동일하게 하면 오버라이딩이 성립  */
//    @Override
//    public void method(int num) {}

    /* 설명 1. 메소드 이름 변경(에러발생 / Override 적용 안됨) */
//    @Override
//    public void method1(int num) {}

    /* 설명 2. 메소드 리턴 타입 변경(에러발생) */
//    @Override
//    public String method(int num) {return null;}

    /* 설명 3. 메소드의 매개변수 차이나도록 변경(에러발생) */
//    @Override
//    public void method(int num, int num2) {}


    /* 설명 4. 경우에 따라 반환형을 달리할 수 있다.(부모 메소드 반환형의 자식타입은 가능) */
    @Override
    public Integer method2(int num) {
        return null;
    }

    /* 설명 5. private 메소드는 오버라이딩 불가 */
//    @Override
//    private void privateMethod() {}

    /* 설명 6. final 메소드는 오버라이딩 불가 */
//    @Override
//    public final void finalMethod() {}

    /* 설명 7. 부모타입과 같은 접근제어자이거나 더 넓은 범위의 접근제어자로 오버라이딩은 가능 */
    @Override
    public void protectedMethod(){}

    // 접근 가능 public
    // 같은 패키지 내에 접근가능 protected(상속), default
    // 접근 불가 private


}