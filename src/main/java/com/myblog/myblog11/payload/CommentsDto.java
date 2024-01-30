package com.myblog.myblog11.payload;

import lombok.Data;

@Data
public class CommentsDto {
    private long id;
    private String email;
    private String text;
}
