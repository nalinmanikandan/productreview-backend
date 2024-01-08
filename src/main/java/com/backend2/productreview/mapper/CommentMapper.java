package com.backend2.productreview.mapper;

import com.backend2.productreview.dto.CommentDto;
import com.backend2.productreview.entity.Comment;

public class CommentMapper {
    public static CommentDto mapToCommentDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getComment()
        );
    }

    public static Comment mapToComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setComment(commentDto.getComment());
        return comment;
    }
}
