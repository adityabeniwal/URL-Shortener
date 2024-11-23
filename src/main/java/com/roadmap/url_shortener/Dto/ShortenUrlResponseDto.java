package com.roadmap.url_shortener.Dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShortenUrlResponseDto
{
    private int id;

    private String url;
    private String shortcode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
