package com.ohgiraffers.userservice.vo;

import lombok.Data;

@Data
public class ResponseUser {
    private String name;
    private String email;
    private String userId;      // 사용자 ID(회원번호 X)

    /* 설명. FeignClient 이후(다른 도메인 서버와 통신하여 값을 가져온 이후) 추가 */
//    private List<ResponseOrder> orders;
}
