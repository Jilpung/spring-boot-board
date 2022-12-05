package com.spring.boot.board.springbootboard.domain.repository;

import com.spring.boot.board.springbootboard.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    List<BoardEntity> findByTitleContaining(String keyword);
    @Modifying
    @Query("update BoardEntity b set b.view = b.view + 1 where b.id = :id")
    static int updateView(Long id) {
        return 0;
    }
}
