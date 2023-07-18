package com.blogEX.Service.Service;

import com.blogEX.PayLoad.CommentDto;

public interface CommentService {

    public CommentDto createComment(long postId , CommentDto commentDto);
}
