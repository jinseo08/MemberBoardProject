package com.its.memberboardproject.entity;

import com.its.memberboardproject.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "member_table")
public class MemberEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true,length = 50)
    private String memberEmail;

    @Column(length = 20)
    private String memberPassword;

    @Column(length = 20)
    private String memberName;

    @Column(length = 50)
    private String memberProfileName;

    @Column(length = 20)
    private String memberMobile;

    public static MemberEntity toSave(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberMobile(memberDTO.getMemberMobile());
        memberEntity.setMemberProfileName(memberDTO.getMemberProfileName());
        return memberEntity;
    }

    public static MemberEntity toUpdate(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberMobile(memberDTO.getMemberMobile());
        memberEntity.setMemberProfileName(memberDTO.getMemberProfileName());
        return memberEntity;
    }

}
