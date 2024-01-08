package com.backend2.productreview.service.impl;

import com.backend2.productreview.dto.CommentDto;
import com.backend2.productreview.entity.Comment;
import com.backend2.productreview.exception.ResourceNotFoundException;
import com.backend2.productreview.mapper.CommentMapper;
import com.backend2.productreview.repository.CommentRepository;
import com.backend2.productreview.repository.ProductRepository;
import com.backend2.productreview.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<CommentDto> getCommentsByProductId(Long productId) {
        List<Comment> comments = commentRepository.findByProductId(productId);
        return comments.stream()
                .map(CommentMapper::mapToCommentDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto createComment(Long productId, CommentDto commentDto) {
        Comment comment = CommentMapper.mapToComment(commentDto);
        comment.setProduct(productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId)));
        Comment savedComment = commentRepository.save(comment);
        return CommentMapper.mapToCommentDto(savedComment);
    }
    // Other comment-related methods...
}
