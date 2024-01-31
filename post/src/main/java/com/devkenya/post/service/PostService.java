package com.devkenya.post.service;

import com.devkenya.post.dto.req.CreatePostReq;
import com.devkenya.post.model.Post;
import com.devkenya.post.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    //create a post
    public boolean createPost(CreatePostReq createPostReq) {
        log.info("Creating post for user with id: {}", createPostReq.userId());
        var userId = createPostReq.userId();


        Post post = Post.builder()
                .userId(userId)
                .hasImage(createPostReq.image() != null)
                .image(createPostReq.image())
                .content(createPostReq.content())
                .build();

        // Save the post to the database
        postRepository.save(post);

        return true;
    }

}
