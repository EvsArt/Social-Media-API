package com.artevseev.SocialMediaAPI.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Set;

@Data
@Builder
@Entity(name = "users")
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User implements UserDetails {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String email;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    @Singular
    @OneToMany
    private Set<Role> authorities;

    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;

}
