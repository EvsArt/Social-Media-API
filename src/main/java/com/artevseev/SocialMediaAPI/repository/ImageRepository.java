package com.artevseev.SocialMediaAPI.repository;

import com.artevseev.SocialMediaAPI.entity.Image;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<Image, Long> {
    List<Image> findByIdIn(List<Long> ids);
}
