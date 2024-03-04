package longhonor.hellospring.service;

import longhonor.hellospring.domain.Member;
import longhonor.hellospring.repository.MemberRepository;
import longhonor.hellospring.repository.MemoryMemberRepository;

import java.util.Optional;
import java.util.List;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    *회원가입
     */
    public Long join(Member member) {
        //중복된 이름을 가진 회원은 처리하지 않음
        validateDuplicatedMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다");
                        });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
