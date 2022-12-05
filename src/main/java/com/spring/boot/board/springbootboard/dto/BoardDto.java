package com.spring.boot.board.springbootboard.dto;

import com.spring.boot.board.springbootboard.domain.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private int view;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public BoardEntity toEntity() {
        BoardEntity boardEntity = BoardEntity.builder()
                .id(id)
                .title(title)
                .content(content)
                .writer(writer)
                .view(0)
                .build();
        return boardEntity;
    }

    @Builder
    public BoardDto(Long id, String title, String content, String writer, int view, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.view = view;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
