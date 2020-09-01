package com.codemusik.service;

import com.codemusik.po.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);

    void deleteCommentByBlogId(Long blogId);
}
