package com.roadmap.url_shortener.Dto;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class UpdateUrlResponseDto
{
    private int id;

    private String url;
    private String shortcode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
