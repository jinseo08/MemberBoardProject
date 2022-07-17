package com.its.memberboardproject.service;

import com.its.memberboardproject.dto.BoardDTO;
import com.its.memberboardproject.entity.BoardEntity;
import com.its.memberboardproject.entity.MemberEntity;
import com.its.memberboardproject.repository.BoardRepository;
import com.its.memberboardproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public Long save(BoardDTO boardDTO) throws IOException {
        System.out.println("boardDTO = " + boardDTO);
        MultipartFile boardFile = boardDTO.getBoardFile();
        String boardFileName = boardFile.getOriginalFilename();
        boardFileName = System.currentTimeMillis()+"_"+boardFileName;
        String savePath = "D:\\springboot_img\\" + boardFileName;
        if(!boardFile.isEmpty()){ //파일이 있으면
            boardFile.transferTo(new File(savePath));
        }
        boardDTO.setBoardFileName(boardFileName);

        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberEmail(boardDTO.getBoardWriter());
        if(optionalMemberEntity.isPresent()){
            MemberEntity memberEntity = optionalMemberEntity.get();
            System.out.println("memberEntity = " + memberEntity);
            Long savedId = boardRepository.save(BoardEntity.toBoard(boardDTO, memberEntity)).getId();
            return savedId;

        }else {
            System.out.println("memberEntity = ");
            return null;
        }
    }

}
