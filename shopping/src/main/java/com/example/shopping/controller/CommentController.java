package com.example.shopping.controller;

import com.example.shopping.dto.CommentDto;
import com.example.shopping.entity.Comment;
import com.example.shopping.service.CommentService;
import com.example.shopping.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api/v2/comment")
@CrossOrigin("*")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/getByProduct/{productId}")
    public ResponseEntity<?> getCommentByProduct(@PathVariable String productId) {
        List<Comment> comments = commentService.getCommentByProduct(productId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("/{productId}")
    @PreAuthorize("hasRole(USER)")
    public ResponseEntity<?> addComment(@PathVariable String productId, @RequestBody CommentDto commentDto, HttpServletRequest request) {
        String userId = jwtUtils.getUserIdFromJWT(request.getHeader("Authorization").substring(7));
        Comment comments = commentService.addComment(productId, userId, commentDto);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PutMapping("/{commentId}")
    @PreAuthorize("hasRole(USER)")
    public ResponseEntity<?> editComment(@PathVariable String commentId, @RequestBody CommentDto commentDto, HttpServletRequest request) {
        try {
            String userId = jwtUtils.getUserIdFromJWT(request.getHeader("Authorization").substring(7));
            Comment comment = commentService.editComment(commentId, commentDto, userId);
            return new ResponseEntity<>(comment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/{commentId}")
    @PreAuthorize("hasRole(USER)")
    public ResponseEntity<?> deleteComment(@PathVariable String commentId, HttpServletRequest request) {
        try {
            String userId = jwtUtils.getUserIdFromJWT(request.getHeader("Authorization").substring(7));
            commentService.deleteComment(commentId, userId);
            return new ResponseEntity<>("Delete success", HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}
