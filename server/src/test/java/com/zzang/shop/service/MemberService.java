package com.zzang.shop.service;

import com.zzang.shop.domain.Store;
import com.zzang.shop.domain.common.Address;
import com.zzang.shop.domain.member.Gender;
import com.zzang.shop.domain.member.Member;
import com.zzang.shop.domain.member.Role;
import com.zzang.shop.repository.MemberRepository;
import org.aspectj.lang.annotation.RequiredTypes;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    EntityManager em;


    @DisplayName("SAVE 검증")
    @Test
    void savedMember() {
        Member member = new Member();
        member.setUserId("blosw123");
        member.setUsername("이성민");
        member.setBirth("960826");
        member.setRole(Role.BUYER);
        member.setEmail("captain1152@naver.com");
        member.setGender(Gender.MALE);
        member.setHint("보물찾기");
        member.setTel("01022061152");
        member.setAddress(new Address("광주광역시", "남구 백운동", "33-11"));
        memberRepository.save(member);
    }

    @DisplayName("dirth checking으로 인한 수정하기 검증")
    @Test
    void updatedMember() {
        Member member = new Member();
        member.setUserId("blosw123");
        member.setUsername("이성민");
        member.setBirth("960826");
        member.setRole(Role.BUYER);
        member.setEmail("captain1152@naver.com");
        member.setGender(Gender.MALE);
        member.setHint("보물찾기");
        member.setTel("01022061152");
        member.setAddress(new Address("광주광역시", "남구 백운동", "33-11"));
        memberRepository.save(member);

        Optional<Member> findMember = memberRepository.findById(member.getId());
        findMember.ifPresent(member1 -> member1.setUsername("김성민"));

        Assertions.assertThat(member).isEqualTo(findMember.get());

    }

    @DisplayName("DELETE 검증")
    @Test
    void deletedMember() {
        Member member = new Member();
        member.setUserId("blosw123");
        member.setUsername("이성민");
        member.setBirth("960826");
        member.setRole(Role.BUYER);
        member.setEmail("captain1152@naver.com");
        member.setGender(Gender.MALE);
        member.setHint("보물찾기");
        member.setTel("01022061152");
        member.setAddress(new Address("광주광역시", "남구 백운동", "33-11"));
        memberRepository.save(member);

        memberRepository.delete(member);
    }

    @DisplayName("아이디 찾기")
    @Test
    void findById() {
        String username = "이성민";
        String hint = "보물찾기";

        Member member = new Member();
        member.setUserId("blosw123");
        member.setUsername(username);
        member.setBirth("960826");
        member.setRole(Role.BUYER);
        member.setEmail("captain1152@naver.com");
        member.setGender(Gender.MALE);
        member.setHint(hint);
        member.setTel("01022061152");
        member.setAddress(new Address("광주광역시", "남구 백운동", "33-11"));
        memberRepository.save(member);

        Optional<Member> findMember = memberRepository.findByUsernameAndHint(username, hint);
        findMember.ifPresent(
                Member::getUserId
        );
        System.out.println("findMember = " + findMember.get().getUserId());
    }

    @DisplayName("비밀번호 변경하기")
    @Test
    void findByPassword() {
        String userId = "blosw123";
        String username = "이성민";

        Member member = new Member();
        member.setUserId(userId);
        member.setUsername(username);
        member.setPassword("abc123");
        member.setBirth("960826");
        member.setRole(Role.BUYER);
        member.setEmail("captain1152@naver.com");
        member.setGender(Gender.MALE);
        member.setHint("보물찾기");
        member.setTel("01022061152");
        member.setAddress(new Address("광주광역시", "남구 백운동", "33-11"));
        memberRepository.save(member);

        Optional<Member> findMember = memberRepository.findByUserIdAndUsername(userId, username);
        findMember.ifPresent(getMember ->{
            getMember.setPassword("test123");
        });
    }
}
