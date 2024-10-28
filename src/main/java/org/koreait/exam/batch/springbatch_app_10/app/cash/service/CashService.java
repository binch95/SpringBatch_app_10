package org.koreait.exam.batch.springbatch_app_10.app.cash.service;

import org.koreait.exam.batch.springbatch_app_10.app.cash.entity.CashLog;
import org.koreait.exam.batch.springbatch_app_10.app.cash.repository.CashRepository;
import org.koreait.exam.batch.springbatch_app_10.app.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CashService {
    private final CashRepository cashRepository;

    public CashLog addCash(Member member, long price, String eventType) {
        CashLog cashLog = CashLog.builder()
                .member(member)
                .price(price)
                .eventType(eventType)
                .build();
        cashRepository.save(cashLog);
        return cashLog;
    }
}
