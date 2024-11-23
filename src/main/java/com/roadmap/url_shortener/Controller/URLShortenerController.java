package com.roadmap.url_shortener.Controller;


import com.roadmap.url_shortener.Dto.ShortenUrlRequestDto;
import com.roadmap.url_shortener.Dto.ShortenUrlResponseDto;
import com.roadmap.url_shortener.Service.URLShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shorten")
public class URLShortenerController
{
    private URLShortenerService urlShortenerService;

    @Autowired
    public URLShortenerController(URLShortenerService urlShortenerService)
    {
        this.urlShortenerService=urlShortenerService;
    }

    @PostMapping()
    public ShortenUrlResponseDto createShortUrl(@RequestBody ShortenUrlRequestDto shortenUrlRequestDto)
    {
        return urlShortenerService.createShortUrl(shortenUrlRequestDto);
    }
}
