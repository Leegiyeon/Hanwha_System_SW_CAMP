package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. 스트림의 중계연산 중 하나면 flatMap에 대해 이해하고 사용할 수 있다. */
        /* 필기.
         *  Stream<R> flapMap(Function<? super T, ? extends Stream<? extends R>> mapper);
         *  flatMap()은 중첩 구조를 한 단계 제거하여 단일 컬렉션으로 만들어 준다.
         *  위와 같은 작업을 플래트닝(Flattening)이라 한다.
        * */

        List<List<String>> list = Arrays.asList(
                Arrays.asList("JAVA", "SPRING", "SPRINGBOOT"),
                Arrays.asList("java", "spring", "springboot")
        );
        System.out.println("list:" + list);

        List<String> flatList = list.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("flatList: " + flatList);


    }
}
