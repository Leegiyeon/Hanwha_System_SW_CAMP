package com.ohgiraffers.section03.annotationconfig.subsection01.java;


import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/* 설명. 설정용 클래스도 bean으로 관리되며 이름을 부여할 수 있다. */
@Configuration("configurationSection03")

/* 설명. 1. 단순히 범위 지정만으로 @Component 계열의 어노테이션들을 모두 bean으로 관리하는 경우 */
//@ComponentScan(basePackages = "com.ohgiraffers")

/* 설명. 2. 범위 및 필터를 적용하여 bean 관리 */
//@ComponentScan(basePackages = "com.ohgiraffers",
//        excludeFilters = {
//                @ComponentScan.Filter(
//                        /* Memo. 타입으로 설정 */
//                        type = FilterType.ASSIGNABLE_TYPE,
//                        classes = {MemberDTO.class}
//
//                        /* Memo. 어노테이션으로 설정 */
//                        type = FilterType.ANNOTATION,
//                        classes = {org.springframework.stereotype.Repository.class}
//
//                        /* Memo. 표현식으로 설정 */
//                        type = FilterType.REGEX,
//                        pattern = {"com.ohgiraffers.section03.annotationconfig.subjection01.java.*"}
//
//                )
//
//        })


/* 설명. 3. 범위 및 필터를 적용해서 bean을 관리하는 경우(includeFilter) */
@ComponentScan(basePackages = "com.ohgiraffers",
                useDefaultFilters = false,
                includeFilters = {
                        @ComponentScan.Filter(
                                type = FilterType.ASSIGNABLE_TYPE,
                                classes = {MemberDTO.class}
                        )
                }
)

/* 설명.
 *  @ComponentScan 필터의 경우 개념 정도만 알아도 되지만 기본적으로 @Configuration 클래스가 위치한
 *  패키지와 해당 패키지 하위만 scan하기에 더 상위 범위나 다른 패키지를 scan하기위해 주로 사용된다.
* */
public class ContextConfiguration {

}
