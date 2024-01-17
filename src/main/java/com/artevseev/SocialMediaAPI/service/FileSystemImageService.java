package com.artevseev.SocialMediaAPI.service;

import com.artevseev.SocialMediaAPI.entity.Image;
import com.artevseev.SocialMediaAPI.repository.ImageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.UUID;

@Slf4j
@Service
public class FileSystemImageService implements ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public FileSystemImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    /**
     * Save image to file system and write it to repository
     * @param file file in MultipartFile
     * @return saved Image object
     */
    public Image save(String name, MultipartFile file) {
        String nameInFileSystem = saveToSystem(file);
        return imageRepository.save(new Image(name, nameInFileSystem));
    }

    /**
     * Save image in base64 to file system and return its name
     * @param file file in MultipartFile
     * @return name of saved image
     */
    protected String saveToSystem(MultipartFile file) {

        log.debug("Saving file {}", file);
        String nameInFileSystem = UUID.randomUUID().toString();
        while(imageRepository.existBySavedUniqueName(nameInFileSystem)) {
            nameInFileSystem = UUID.randomUUID().toString();
        }
        log.debug("File will saved with name: {}", nameInFileSystem);

        Path path = Path.of("src", "main", "resources", "images", nameInFileSystem);
        try {
            Files.createDirectories(path.getParent());
            Files.createFile(path);
            Files.write(path, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nameInFileSystem;
    }

}
