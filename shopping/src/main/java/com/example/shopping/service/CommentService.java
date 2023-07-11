package com.example.shopping.service;

import com.example.shopping.dto.CommentDto;
import com.example.shopping.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentByProduct(String productId);

    Comment addComment(String productId, String userId, CommentDto commentDto);

    Comment editComment(String commentId, CommentDto commentDto, String userId);

    void deleteComment(String commentId, String userId);
}
