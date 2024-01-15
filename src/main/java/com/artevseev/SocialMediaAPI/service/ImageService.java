package com.artevseev.SocialMediaAPI.service;

import com.artevseev.SocialMediaAPI.entity.Image;

import java.util.List;

public interface ImageService {

    /**
     * Save image and write it to repository
     * @param base64Img image in base64
     * @return saved Image object
     */
    Image save(String base64Img);

    /**
     * Save image to file system and write it to repository
     * @param base64Img image in base64
     * @return saved Image objects
     */
    List<Image> save(List<String> base64Img);

}
