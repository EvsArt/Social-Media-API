package com.artevseev.SocialMediaAPI.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageForRequest {
    private String name;
    private MultipartFile file;
}
