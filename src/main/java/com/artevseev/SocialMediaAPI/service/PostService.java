package com.artevseev.SocialMediaAPI.service;

import com.artevseev.SocialMediaAPI.entity.Post;
import com.artevseev.SocialMediaAPI.model.PostForRequest;

import java.util.List;
import java.util.Optional;

public interface PostService {
    void save(Post post, List<Long> imagesIds);

    Optional<Post> findById(Long id);

    Optional<Post> deleteById(Long id);

    Optional<Post> editById(Long id, PostForRequest newPost);

}
