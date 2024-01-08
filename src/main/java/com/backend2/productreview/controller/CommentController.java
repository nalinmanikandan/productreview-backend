package com.backend2.productreview.controller;

import com.backend2.productreview.dto.CommentDto;
import com.backend2.productreview.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products/{productId}/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentDto>> getCommentsByProductId(@PathVariable Long productId) {
        List<CommentDto> comments = commentService.getCommentsByProductId(productId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommentDto> createComment(
            @PathVariable Long productId,
            @RequestBody CommentDto commentDto
    ) {
        CommentDto savedComment = commentService.createComment(productId, commentDto);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }
    // Other comment-related endpoints...
}
