package longhonor.hellospring;

import longhonor.hellospring.repository.MemberRepository;
import longhonor.hellospring.repository.MemoryMemberRepository;
import longhonor.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
