package com.artevseev.SocialMediaAPI.repository;

import com.artevseev.SocialMediaAPI.entity.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {
}
