package com.blogEX.PayLoad;

import lombok.Data;

import java.util.List;

@Data
public class PostDto {

    private Long id;
    private String content;
    private String description;
    private String title;
    private List<CommentDto> comments;


}
