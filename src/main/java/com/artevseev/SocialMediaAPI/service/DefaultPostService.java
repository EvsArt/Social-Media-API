package com.artevseev.SocialMediaAPI.service;

import com.artevseev.SocialMediaAPI.entity.Post;
import com.artevseev.SocialMediaAPI.repository.ImageRepository;
import com.artevseev.SocialMediaAPI.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultPostService implements PostService {

    private final PostRepository postRepository;
    private final ImageRepository imageRepository;

    @Autowired
    public DefaultPostService(PostRepository postRepository,
                              ImageRepository imageRepository) {
        this.postRepository = postRepository;
        this.imageRepository = imageRepository;
    }

    public void save(Post post, List<Long> imagesIds) {
        post.setPostImages(imageRepository.findByIdIn(imagesIds));
        postRepository.save(post);
    }
}
