package com.zzang.shop.repository;

import com.zzang.shop.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsernameAndHint(@Param("username") String username, @Param("hint") String hint);

    Optional<Member> findByUserIdAndUsername(@Param("userId") String userId, @Param("username") String username);

}
