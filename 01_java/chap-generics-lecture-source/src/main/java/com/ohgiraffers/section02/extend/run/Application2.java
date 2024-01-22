package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.vo.*;

public class Application2 {

    public static void main(String[] args) {

        /* 수업목표. 와일드카드에 대해 이해할 수 있다. */

        WildcardFarm wildcardFarm = new WildcardFarm();
        wildcardFarm.anytype(new RabbitFarm<Rabbit>());
        wildcardFarm.anytype(new RabbitFarm<Bunny>());
        wildcardFarm.anytype(new RabbitFarm<DrunkenBunny>());

        wildcardFarm.extendsType(new RabbitFarm<Bunny>());
//        wildcardFarm.extendsType(new RabbitFarm<Rabbit>());
//        wildcardFarm.extendsType(new RabbitFarm<DrunkenBunny>());

        wildcardFarm.superType(new RabbitFarm<Rabbit>());
        wildcardFarm.superType(new RabbitFarm<Bunny>());
//        wildcardFarm.superType(new RabbitFarm<>(DrunkenBunny));

    }
}
