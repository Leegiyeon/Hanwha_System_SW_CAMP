package com.ohgiraffers.section02.set.run;

import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. TreeSet에 대해 이해하고 활용할 수 있다. */
        TreeSet<String> tSet = new TreeSet<>();
        tSet.add("ramen");
        tSet.add("pork");
        tSet.add("kimchi");
        tSet.add("friedEgg");
        tSet.add("soup");

        System.out.println("tSet = " + tSet);

        /* 설명. 중복되지 않는 번호를 발생시켜 로또번호 발생기 만들기(TreeSet사용하지 않고) 1~45, 6개 */
        int[] lotto = new int[6];

        for (int i = 0; i < 6; i++) {

            while (true){
                int winning = (int) (Math.random() * 45) + 1;       // Memo. 난수 발생(1~45)

                boolean flag = true;

                for (int j = 0; j < lotto.length; j++) {
                    if (lotto[j] == winning) {
                        flag = false;
                    }
                }

                if (flag) {
                    lotto[i] = winning;
                    break;
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            System.out.println(lotto[i]);
        }

        int tmp = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (lotto[i] < lotto[j]){
                    tmp = lotto[i];
                    lotto[i] = lotto[j];
                    lotto[j] = tmp;
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            System.out.println(i+1 + "번째 수: " + lotto[i]);
        }







    }
}
