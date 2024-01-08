package com.backend2.productreview.service;

import com.backend2.productreview.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> getCommentsByProductId(Long productId);

    CommentDto createComment(Long productId, CommentDto commentDto);
    // Other comment-related methods...
}
