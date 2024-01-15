package com.artevseev.SocialMediaAPI.repository;

import com.artevseev.SocialMediaAPI.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
