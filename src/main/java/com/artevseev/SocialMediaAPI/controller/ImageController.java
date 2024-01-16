package com.artevseev.SocialMediaAPI.controller;

import com.artevseev.SocialMediaAPI.entity.Image;
import com.artevseev.SocialMediaAPI.entity.User;
import com.artevseev.SocialMediaAPI.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createImage(@AuthenticationPrincipal User userPrincipals,
                                              @RequestParam("name") String name,
                                              @RequestParam("body") MultipartFile file) {

        // TODO: 15.01.2024 Add validation and bad request cases

        Image savedImage = imageService.save(name, file);

        return ResponseEntity
                .ok()
                .build();
    }

}
