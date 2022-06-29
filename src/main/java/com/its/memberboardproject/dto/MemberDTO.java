package com.its.memberboardproject.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MemberDTO {

    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private MultipartFile memberProfile;
    private String memberProfileName;
    private String memberMobile;

}
