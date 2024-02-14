package com.ohgiraffers.section02.annotation.subsection03.collection;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("pokemonServiceCollection")
public class PokemonService {

    /* 설명. 같은 타입의 빈이 2개이상일 경우, List또는 Map형태의 컬렉션 형태로 주입받을 수 있다. */

    /* 필기. 1. 같은 타입의 빈들을 List 형태로 주입*/
//    private List<Pokemon> pokemonList;
//
//    @Autowired
//    public PokemonService(List<Pokemon> pokemonList) {
//        this.pokemonList = pokemonList;
//    }
//
//    public void pokemonAttack() {
//        pokemonList.forEach(Pokemon::attack);
//    }


    /* 필기. 2. 같은 타입의 빈들을 Map 형태로 주입*/
    private Map<String, Pokemon> pokemonMap;

    /* 설명. key(빈의 id), value(빈 객체의 주소값) */
    @Autowired
    public PokemonService(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
    }

    public void pokemonAttack() {
        pokemonMap.forEach((k, v) -> {
            System.out.println("key = " + k);
            System.out.println("value = " + v);
            v.attack();
        });
    }
}
