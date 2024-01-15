package com.artevseev.SocialMediaAPI.controller;

import com.artevseev.SocialMediaAPI.entity.Post;
import com.artevseev.SocialMediaAPI.entity.User;
import com.artevseev.SocialMediaAPI.repository.PostRepository;
import com.artevseev.SocialMediaAPI.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostRepository postRepository;
    private final ImageService imageService;

    @Autowired
    public PostController(PostRepository postRepository,
                          ImageService imageService) {
        this.postRepository = postRepository;
        this.imageService = imageService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPost(@AuthenticationPrincipal User userPrincipals,
                                             @RequestParam("title") String title,
                                             @RequestParam("text") String text,
                                             @RequestParam("images") List<String> base64Imgs) {

        // TODO: 15.01.2024 Add validation and bad request cases

        postRepository.save(
                Post.builder()
                        .author(userPrincipals)
                        .title(title)
                        .text(text)
                        .postImages(imageService.save(base64Imgs))
                        .build()
        );

        return ResponseEntity
                .ok()
                .build();
    }

}
