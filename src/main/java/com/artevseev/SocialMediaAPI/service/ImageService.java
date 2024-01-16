package com.artevseev.SocialMediaAPI.service;

import com.artevseev.SocialMediaAPI.entity.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ImageService {

    /**
     * Save image and write it to repository
     * @param base64Img image in base64
     * @return saved Image object
     */
    Image save(String name, MultipartFile file);

}
