package com.artevseev.SocialMediaAPI.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private User author;

    @NonNull
    private String title;

    @NonNull
    private String text;

    @OneToMany
    @NonNull
    @Singular("addImage")
    private List<Image> postImages;

}
