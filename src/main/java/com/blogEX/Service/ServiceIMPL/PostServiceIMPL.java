package com.blogEX.Service.ServiceIMPL;

import com.blogEX.Entities.Post;
import com.blogEX.PayLoad.PostDto;
import com.blogEX.Repository.PostRepository;
import com.blogEX.Service.Service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceIMPL implements PostService {

    public PostServiceIMPL(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    private PostRepository postRepo;
    @Override
    public PostDto createPost(PostDto postDto) {
        Post convertedpost = mapToEntity(postDto);
        Post savedPost = postRepo.save(convertedpost);

        PostDto savedDto = maoToDto(savedPost);


        return savedDto;
    }

    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();

        post.setId(postDto.getId());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        post.setTitle(postDto.getTitle());

        return post;
    }


    private PostDto maoToDto(Post post) {

        PostDto dto = new PostDto();

        dto.setId(post.getId());
        dto.setContent(post.getContent());
        dto.setDescription(post.getDescription());
        dto.setTitle(post.getTitle());

        return dto;
    }
}
