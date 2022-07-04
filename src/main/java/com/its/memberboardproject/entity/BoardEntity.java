package com.its.memberboardproject.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "board_table")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "boardTitle", length = 50, nullable = false) //nullable = false : not null 제약조건
    private String boardTitle;

    @Column(name = "boardWriter", length = 20)
    private String boardWriter;

    @Column(name = "boardContents", length = 500)
    private String boardContents;

    @Column(name = "boardHits")
    private int boardHits;

    @Column
    private String boardFileName;



}
