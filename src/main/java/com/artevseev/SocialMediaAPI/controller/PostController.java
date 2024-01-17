package com.artevseev.SocialMediaAPI.controller;

import com.artevseev.SocialMediaAPI.entity.Post;
import com.artevseev.SocialMediaAPI.entity.User;
import com.artevseev.SocialMediaAPI.model.PostForRequest;
import com.artevseev.SocialMediaAPI.service.DefaultPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/post")
public class PostController {

    private final DefaultPostService postService;

    @Autowired
    public PostController(DefaultPostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPost(@AuthenticationPrincipal User userPrincipals,
                                             @RequestParam("post") PostForRequest post) {

        // TODO: 15.01.2024 Add validation and bad request cases

        postService.save(
                Post.builder()
                        .author(User.builder().email("a").username("a").password("a").authorities(Set.of()).build())
                        .title(post.getTitle())
                        .text(post.getText())
                        .build(),
                post.getSavedImgIds()
        );

        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id) {

        Optional<Post> post = postService.findById(id);

        if (post.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(post.get());
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<Post> deletePost(@AuthenticationPrincipal User userPrincipals,
                                           @PathVariable Long id) {

        Optional<Post> post = postService.deleteById(id);

        if (post.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (post.get().getAuthor().equals(userPrincipals)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        return ResponseEntity.ok(post.get());
    }

    @PostMapping("/{id}/edit")
    public ResponseEntity<Post> editPost(@AuthenticationPrincipal User userPrincipals,
                                         @PathVariable("id") Long id,
                                         @RequestParam("newPost") PostForRequest newPost) {

        Optional<Post> post = postService.editById(id, newPost);

        if (post.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        if (post.get().getAuthor().equals(userPrincipals)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        return ResponseEntity.ok(post.get());

    }

}
