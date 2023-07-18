package com.blogEX.Service.ServiceIMPL;

import com.blogEX.Entities.Comment;
import com.blogEX.Entities.Post;
import com.blogEX.Exception.EntityNotFoundException;
import com.blogEX.PayLoad.CommentDto;
import com.blogEX.PayLoad.PostDto;
import com.blogEX.Repository.CommentRepository;
import com.blogEX.Repository.PostRepository;
import com.blogEX.Service.Service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository comRepo;

    private PostRepository posRepo;

    public CommentServiceImpl(CommentRepository comRepo, PostRepository posRepo) {
        this.comRepo = comRepo;
        this.posRepo = posRepo;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Post pst = posRepo.findById(postId).orElseThrow(
                () -> new EntityNotFoundException("NO RECORD FIND")

        );

        Comment comment = convertToEntity(commentDto);
        comment.setPost(pst);
        Comment savedComment = comRepo.save(comment);

        CommentDto updatedComment = convertToDto(savedComment);

        return updatedComment;
    }

    private Comment convertToEntity(CommentDto commentDto) {

        Comment comment = new Comment();

        comment.setBody(commentDto.getBody());
        comment.setEmail(commentDto.getEmail());
        comment.setName(commentDto.getName());

        Post post = new Post();
        post.setId(commentDto.getPostId());
        comment.setPost(post);

        return comment;
    }

    private CommentDto convertToDto(Comment comment) {

        CommentDto commentDto = new CommentDto();

        commentDto.setId(comment.getId());
        commentDto.setBody(comment.getBody());
        commentDto.setEmail(comment.getEmail());
        commentDto.setName(comment.getName());
        commentDto.setPostId(comment.getPost().getId());



        return commentDto;
    }
}
