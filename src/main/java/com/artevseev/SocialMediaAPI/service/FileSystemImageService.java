package com.artevseev.SocialMediaAPI.service;

import com.artevseev.SocialMediaAPI.entity.Image;
import com.artevseev.SocialMediaAPI.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileSystemImageService implements ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public FileSystemImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    /**
     * Save image to file system and write it to repository
     * @param base64Img image in base64
     * @return saved Image object
     */
    public Image save(String base64Img) {
        String name = saveToSystem(base64Img);
        return imageRepository.save(new Image(name));
    }

    /**
     * Save images to file system and write them to repository
     * @param base64Imgs images in base64
     * @return list of saved Image objects
     */
    public List<Image> save(List<String> base64Imgs) {
        return base64Imgs.stream()
                .map(this::save)
                .toList();
    }

    /**
     * Save image in base64 to file system and return its name
     * @param base64Img image in base64
     * @return name of saved image
     */
    private String saveToSystem(String base64Img) {
        // TODO: 15.01.2024 Realize image saving
        return "ImageName";
    }

    /**
     * Save list of images to file system and return its name
     * @param base64Imgs list of images in base64
     * @return list of names of saved images
     */
    private List<String> saveToSystem(List<String> base64Imgs) {
        return base64Imgs.stream()
                .map(this::saveToSystem)
                .toList();
    }

}
