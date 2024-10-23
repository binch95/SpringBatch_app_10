package org.koreait.exam.batch.springbatch_app_10.app.base.initData;

import org.koreait.exam.batch.springbatch_app_10.app.member.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@Profile("dev")
public class DevInitData implements InitDataBefore {
    @Bean
    CommandLineRunner initData(MemberService memberService) {
        return args -> {
            before(memberService);
        };
    }
}