package com.its.memberboardproject.repository;

import com.its.memberboardproject.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity,Long> {

    @Modifying
    @Query(value = "update BoardEntity b set b.boardHits = b.boardHits+1 where b.id= :id")
    void boardHits(@Param("id") Long id);

    List<BoardEntity> findByBoardTitleContainingOrBoardContentsContaining(String q1, String q2);
}
