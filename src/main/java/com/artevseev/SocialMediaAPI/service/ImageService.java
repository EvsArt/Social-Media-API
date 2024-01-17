package com.artevseev.SocialMediaAPI.service;

import com.artevseev.SocialMediaAPI.entity.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImageService {

    /**
     * Save image and write it to repository
     *
     * @param name name of the image
     * @param file image in MultipartFile
     * @return saved Image object
     */
    Image save(String name, MultipartFile file);

}
