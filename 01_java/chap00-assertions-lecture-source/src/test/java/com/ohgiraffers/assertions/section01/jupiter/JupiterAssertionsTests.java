package com.ohgiraffers.assertions.section01.jupiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

public class JupiterAssertionsTests {

    /* 수업목표. junit5에서 제공하는 Assertions의 메소드에 대해 이해하고 사용할 수 있다. */

    /* 목차. 1. assertEquals */
    /* 필기. assertEquals(expected, result) 메소드는 실제 값과 기대 값의 일치여부를 동일성으로 판단한다. */
    @Test
    public void testAssertEquals() {

        /* 설명. 1. given */
        int firstNum = 10;
        int secondNem = 20;
        int expected = 30;

        /* 설명. 2. when */
        Calculator calculator = new Calculator();
        int result = calculator.plusTwoNumbers(firstNum, secondNem);

        /* 설명. 3. then */
//        Assertions.assertEquals(expected, result, 1); // delta는 오차 범위
        Assertions.assertEquals(expected, result, "두 값이 같아야 합니다.");
    }

    /* 목차. 2. assertNotEquals */
    /* 필기. assertNotEquals(expected, result) 메소드는 실제 값과 기대값의 불일치 여부를 동일성으로 판단한다.*/
    @Test
    @DisplayName("인스턴스 동일성 비교 테스트")
    public void testAssertNotEquals() {

        Object obj1 = new Object();
        Object obj2 = new Object();
        Assertions.assertNotEquals(obj1, obj2);

        /* 설명. equals와 hashCode가 오버라이딩 되어있다면 동등 비교이다, */
    }

    /* 목차. 3. assertNull */
    @Test
    @DisplayName("null인지 테스트")
    void testAssertNull() {
        String str;
        str = null;
        Assertions.assertNull(str);
    }

    /* 목차. 4. assertNotNull */
    @Test
    @DisplayName("null인지 테스트")
    void testAssertNotNull() {
        String str;
        str = "JAVA";
        Assertions.assertNotNull(str);
    }

    /* 목차. 5. 자주쓰는 나머지 간단한 단정문 */
    /* 설명. assertTrue(), assertFalse()  */

    /* 목차. 6. assertAll */
    @Test
    @DisplayName("동시에 여러가지 값에 대한 검증을 수행하는 경우 테스트")
    void testAssetAll(){

        // given
        String firstName = "길동";
        String lastName = "홍";

        // when
        Person person = new Person(firstName, lastName);

        // then
        Assertions.assertAll(
                "그룹화된 테스트의 이름(테스트 실패시 보여짐)",
                () -> Assertions.assertEquals(firstName, person.getFirstName(), () -> "FirstName 잘못됨"),
                () -> Assertions.assertEquals(lastName, person.getlastName(), () -> "LastName 잘못됨")
        );
    }


    /* 목차. 7. assertThrows */
    @Test
    @DisplayName("void 메소드의 경우 exception이 발생하는지 테스트")
    void testAssertThrows(){
        int firstNum = 10;
        int secondNum = 0;
        String expectedErrorMessage = "0으로 나눌 수 없습니다.";

        PositveNumberValidator validator = new PositveNumberValidator();
        Exception exception = Assertions.assertThrows(
                Exception.class,
                () -> validator.checkDividableNumbers(firstNum, secondNum)
        );

        Assertions.assertAll(
                () -> Assertions.assertInstanceOf(IllegalArgumentException.class, exception,
                        () -> "예외 타입이 일치하지 않음"),
                () -> Assertions.assertEquals(expectedErrorMessage, exception.getMessage(),
                        () -> "예외 메시지가 일치하지 않음")
        );
    }
}
