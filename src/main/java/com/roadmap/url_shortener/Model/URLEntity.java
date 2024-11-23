package com.roadmap.url_shortener.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="urls")
@Data
public class URLEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String url;
    private String shortcode;
    private LocalDateTime createdAt;
    private LocalDateTime  updatedAt;
    private int accessCount;

}
