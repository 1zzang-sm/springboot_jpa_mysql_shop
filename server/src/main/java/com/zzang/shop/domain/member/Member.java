package com.zzang.shop.domain.member;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue
    private Long id; // PK
    private String userId; // 아이디

    private String username; // 회원설계
    @Enumerated(value = EnumType.STRING)
    private Gender gender; // MALE, FEMALE

    private String birth; // 출생년월
    private String email; // 이메일
    private String hint; // 힌트

    @Enumerated(value = EnumType.STRING)
    private Role role; // ADMIN, SELLER, CANCEL

}
