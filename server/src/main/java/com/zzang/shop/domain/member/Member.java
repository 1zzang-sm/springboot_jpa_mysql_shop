package com.zzang.shop.domain.member;

import com.zzang.shop.domain.common.Address;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK
    @Column(length = 20)
    private String userId; // 아이디

    @Column(name = "user_name", length = 20)
    private String username; // 회원이름
    @Enumerated(value = EnumType.STRING)
    private Gender gender; // MALE, FEMALE

    @Column(name = "user_birth", length = 6)
    private String birth; // 출생년월

    @Column(name = "user_tel", length = 11)
    private String tel;

    @Column(name = "user_email", length = 50)
    private String email; // 이메일

    @Column(name = "user_hint", length = 100)
    private String hint; // 힌트

    @Enumerated(value = EnumType.STRING)
    private Role role; // ADMIN, SELLER, CANCEL

    @Embedded
    private Address address;

}
