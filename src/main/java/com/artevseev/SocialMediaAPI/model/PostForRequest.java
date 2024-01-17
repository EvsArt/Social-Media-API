package com.artevseev.SocialMediaAPI.model;

import lombok.Data;

import java.util.List;

@Data
public class PostForRequest {

    private String title;
    private String text;
    private List<Long> savedImgIds;

}
