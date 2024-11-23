package com.roadmap.url_shortener.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StatsResponseDto
{
    private int id;
    private String url;
    private String shortcode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int accessCount;
}
