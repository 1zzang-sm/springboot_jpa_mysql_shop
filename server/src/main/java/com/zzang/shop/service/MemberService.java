package com.zzang.shop.service;

import com.zzang.shop.domain.member.Member;
import com.zzang.shop.domain.member.Role;
import com.zzang.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 1. 회원가입
 * (이름, 아이디, 성별(남,여), 출생년월, 전화번호, 이메일, 힌트, 등급(AMDIN, SELLER, BUYER)를 저장한다.
 *
 * 2. 아이디 찾기
 * (이름 + 힌트), (이름 + 출생년월) 일치 시 공개
 *
 * 3. 비밀번호 찾기
 * (아이디 + 이름)이 같다면 비밀번호 변경가능
 */
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public Long saveMember(Member member) {
        Member savedMember = new Member();
        savedMember.setUserId(member.getUserId());
        savedMember.setUsername(member.getUsername());
        savedMember.setEmail(member.getEmail());
        savedMember.setTel(member.getTel());
        savedMember.setBirth(member.getBirth());
        savedMember.setRole(Role.BUYER);
        savedMember.setGender(member.getGender());
        return member.getId();
    }

    public void findById(String username, String hint) {
        Optional<Member> findMember = memberRepository.findByUsernameAndHint(username, hint);
        findMember.ifPresent(
                member -> member.getUserId()
        );
    }

    public void findByPassword(String userId, String username, String password) {
        Optional<Member> findMember = memberRepository.findByUserIdAndUsername(userId, username);
        findMember.ifPresent(
                member -> member.setPassword(password)
        );
    }







}
