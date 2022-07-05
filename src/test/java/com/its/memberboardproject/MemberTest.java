package com.its.memberboardproject;


import com.its.memberboardproject.dto.MemberDTO;
import com.its.memberboardproject.repository.MemberRepository;
import com.its.memberboardproject.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MemberTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberService memberService;



    @Test
    @DisplayName("회원가입 테스트")
    @Transactional
    @Rollback(value = false)
    public void saveTest() {
        Long savedId = memberService.save(newMember(1));
        MemberDTO memberDTO = memberService.findById(savedId);
        System.out.println("MemberTestClass.saveTest");
        System.out.println("memberDTO = " + memberDTO);
        assertThat(newMember(1).getMemberEmail()).isEqualTo(memberDTO.getMemberEmail());
    }

}
