package com.example.shopping.service.impl;

import com.example.shopping.dto.CommentDto;
import com.example.shopping.entity.Comment;
import com.example.shopping.entity.Product;
import com.example.shopping.repository.CommentRepository;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.repository.UserRepository;
import com.example.shopping.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Comment> getCommentByProduct(String productId) {
        List<Comment> comments = productRepository.findById(productId).get().getComments();
        return comments;
    }

    @Override
    public Comment addComment(String productId, String userId, CommentDto commentDto) {
        Comment addedComment = new Comment();
        addedComment.setRate(commentDto.getRate());
        addedComment.setText(commentDto.getText());
        addedComment.setProduct(productRepository.findById(productId).get());
        addedComment.setUser(userRepository.findById(userId).get());
        commentRepository.save((addedComment));
        Product product = productRepository.findById(productId).get();
        product.setAverageRate(productRepository.countAvgRate(productId));
        productRepository.save(product);
        return addedComment;
    }

    @Override
    public Comment editComment(String commentId, CommentDto commentDto, String userId) {
        Comment comment = commentRepository.findById(commentId).get();
        if (!userId.equals(comment.getUser().getId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        } else {
            comment.setText(commentDto.getText());
            comment.setRate(commentDto.getRate());
            Product product = productRepository.findById(comment.getProduct().getId()).get();
            product.setAverageRate(productRepository.countAvgRate(comment.getProduct().getId()));
            productRepository.save(product);
            return commentRepository.save(comment);
        }
    }

    @Override
    public void deleteComment(String commentId, String userId) {
        Comment comment = commentRepository.findById(commentId).get();
        if (!userId.equals(comment.getUser().getId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        } else {
            commentRepository.deleteById(commentId);
        }
    }
}
