package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {


    /* 설명.
     *  타겟 클래스의 메소드에서 어드바이스를 적용할 수 있는 지점들을 조인포인트라고 한다.
     *  포인트컷은 여러 조인포인트들에 어드바이스를 적용할 곳을 지정한 것이다.
     *  해당 조인 포인트에서 어드바이스가 동작된다.
     *
     * 설명.
     *  <포인트컷 표현식>
     *  execution([수식어] 리턴 타입[클래스이름].이름(파리미터))
     *  1. 수식어: public, private 등 수식어를 명시
     *  2. 리턴타입 명시
     *  3. 클래스이름 및 메소드 이름 명시
     *  4. 메소드의 파라미터 명시
     *  5. "*": 1개 이상
     *  6. "..": 0개 이상
     *
     * 설명.
     *   예시)
     *  execution(public Integer com.ohgiraffers.section01.advice.*.*(*))
     *  -> com.ohgiraffers.section01.advice 패키지에 속해 있는 바로 다음 하위 클래스에 파라미터가 1개인 모든 메소드 이자 접근 제어자가
     *     public이고 반환형이 Integer인 경우
     *  execution(public Integer com.ohgiraffers.section01.advice.annotation..stu*(..))
     *  -> com.ohgiraffers.section01.advice 패키지에 속해 있고, 이름이 stu로 시작하는 파라미터가 0개 이상인
     *     모든 메소드이며 접근제어자와 반환형은 상관없음
     * */
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointcut() {
    }

    /* 설명. 1. Before Advice */
    /* 설명.
     *  매개변수로 쓰인 JointPoint
     *  : 포인트 컷으로 지정된 조인 포인트
     * */
//    @Before("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    @Before("LoggingAspect.logPointcut()")
    public void logBefore(JoinPoint joinPoint) {
//        System.out.println("Before Advice 동작 채영 매니저...");
        System.out.println("Before jointPoint.getTarget() = " + joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature() = " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0) {       // Memo. 타겟 메소드의 매개변수가 하나 이상인 경우
            System.out.println("Before joinPoint.getArgs()[0] = " + joinPoint.getArgs()[0]);
        }
    }


    /* 설명. 2. After Advice */
    @After("LoggingAspect.logPointcut()")
    public void logAfter(JoinPoint joinPoint) {
//        System.out.println("After Advice 동작");
        System.out.println("After jointPoint.getTarget() = " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature() = " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0) {       // Memo. 타겟 메소드의 매개변수가 하나 이상인 경우
            System.out.println("After joinPoint.getArgs()[0] = " + joinPoint.getArgs()[0]);
        }
    }

    /* 설명. 3. AfterReturning Advice */
    /* Memo. Pointcut이 해당하는 위치가 동일한 클래스에 있으면 소속을 안적어도 된다.
     *        Returning에 쓰인 이름이 반환값이 넘어오는 매개변수와 동일해야 한다. */
    @AfterReturning(pointcut = "logPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("After Returning result: " + result);

        /* 설명. AfterReturning Advice를 활용한 반환 값 가공 */
        if (result != null && result instanceof List) {
            ((List<MemberDTO>) result).add(new MemberDTO(3, "반환 값 가공"));
        }
    }


    /* 설명. 4. AfterThrowing Advie */
    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception) {
        System.out.println("After Throwing exception = " + exception);
    }


    /* 설명. 5. Around Advice */
    /* 설명
     *  이 어드바이스는 조인 포인트를 완전히 장악하기 때문에 앞서 살펴 본 어드바이스 모두
     *  Around로 조립할 수 있다.
     *  심지어 원본 조인 포인트를 언제 실행할지, 실행자체를 안할지, 계속 실행할지 여부까지도 제어한다.
     *  Around 의 조인포인트 매개변수는 ProceedingJoinPoint로 고정되어있다.
     *  JoinPoint의 하위 인터페이스로 원본 조인 포인트의 진행 시점을 제어할 수 있다.
     *  조인 포인트를 진행하는 호출을 잊는 경우가 자주 발생하기 때문에 주의 해야하며
     *  가능한 최소한의 요건을 충족하면서도 가장 기능이 약한 어드바이스를 쓰는게 바람직하다.
    * */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Before joinPoint.getSignature().getName() = " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        System.out.println("Around After joinPoint.getSignature().getName() = " + joinPoint.getSignature().getName());

        /* 설명. 실행된 타겟 메소드 반환(다른 어드바이스가 다시 실행할 수 있도록 반환)*/
        return result;
    }

}
