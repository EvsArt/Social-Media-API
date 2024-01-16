package com.artevseev.SocialMediaAPI.controller;

import com.artevseev.SocialMediaAPI.entity.Post;
import com.artevseev.SocialMediaAPI.entity.User;
import com.artevseev.SocialMediaAPI.service.DefaultPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/post")
public class PostController {

    private final DefaultPostService postService;

    @Autowired
    public PostController(DefaultPostService postService) {
        this.postService = postService;
    }

    @GetMapping("/create")
    public ResponseEntity<String> createPost(@AuthenticationPrincipal User userPrincipals,
                                             @RequestParam("title") String title,
                                             @RequestParam("text") String text,
                                             @RequestParam("images") List<Long> savedImgIds) {

        // TODO: 15.01.2024 Add validation and bad request cases

        postService.save(
                Post.builder()
                        .author(User.builder().email("a").username("a").password("a").authorities(Set.of()).build())
                        .title(title)
                        .text(text)
                        .build(),
                savedImgIds
        );

        return ResponseEntity
                .ok()
                .build();
    }

}
