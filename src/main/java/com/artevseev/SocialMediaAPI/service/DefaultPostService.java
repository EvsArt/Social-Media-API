package com.artevseev.SocialMediaAPI.service;

import com.artevseev.SocialMediaAPI.entity.Post;
import com.artevseev.SocialMediaAPI.model.PostForRequest;
import com.artevseev.SocialMediaAPI.repository.ImageRepository;
import com.artevseev.SocialMediaAPI.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public Optional<Post> deleteById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        postRepository.deleteById(id);
        return post;
    }

    public Optional<Post> editById(Long id, PostForRequest newPost) {

        Optional<Post> oldPost = postRepository.findById(id);
        if (oldPost.isEmpty()) {
            return Optional.empty();
        }

        Post post = Post.builder()
                .id(id)
                .title(newPost.getTitle())
                .text(newPost.getText())
                .postImages(imageRepository.findByIdIn(newPost.getSavedImgIds()))
                .build();

        postRepository.save(post);  // id will rewrite bc var post has it

        return oldPost;
    }

}
