package org.koreait.exam.batch.springbatch_app_10.app.base.initData;

import org.koreait.exam.batch.springbatch_app_10.app.member.service.MemberService;
import org.koreait.exam.batch.springbatch_app_10.app.song.service.SongService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Profile("test")
public class TestInitData implements InitDataBefore {
    @Bean
    CommandLineRunner initData(MemberService memberService, SongService songService) {
        return args -> {
            before(memberService, songService);
        };
    }
}