package org.koreait.exam.batch.springbatch_app_10.app.member.service;

import org.koreait.exam.batch.springbatch_app_10.app.cash.entity.CashLog;
import org.koreait.exam.batch.springbatch_app_10.app.cash.service.CashService;
import org.koreait.exam.batch.springbatch_app_10.app.member.entity.Member;
import org.koreait.exam.batch.springbatch_app_10.app.member.exception.AlreadyJoinException;
import org.koreait.exam.batch.springbatch_app_10.app.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final CashService cashService;

    public Member join(String username, String password, String email) {
        if (memberRepository.findByUsername(username).isPresent()) {
            throw new AlreadyJoinException();
        }
        Member member = Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();
        memberRepository.save(member);
        return member;
    }

    @Transactional(readOnly = true)
    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    public long addCash(Member member, long price, String eventType) {
        CashLog cashLog = cashService.addCash(member, price, eventType);
        long newRestCash = member.getRestCash() + cashLog.getPrice();
        member.setRestCash(newRestCash);
        memberRepository.save(member);
        return newRestCash;
    }

    public long getRestCash(Member member) {
        Member foundMember = findByUsername(member.getUsername()).get();
        return foundMember.getRestCash();
    }
}
