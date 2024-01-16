package com.artevseev.SocialMediaAPI.service;

import com.artevseev.SocialMediaAPI.entity.Post;

import java.util.List;

public interface PostService {
    void save(Post post, List<Long> imagesIds);
}
