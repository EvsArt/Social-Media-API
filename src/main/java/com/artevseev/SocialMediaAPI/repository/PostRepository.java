package com.artevseev.SocialMediaAPI.repository;

import com.artevseev.SocialMediaAPI.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
