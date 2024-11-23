package com.roadmap.url_shortener.Controller;


import com.roadmap.url_shortener.Dto.ShortenUrlRequestDto;
import com.roadmap.url_shortener.Dto.ShortenUrlResponseDto;
import com.roadmap.url_shortener.Service.URLShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ShortenUrlResponseDto> createShortUrl(@RequestBody ShortenUrlRequestDto shortenUrlRequestDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(urlShortenerService.createShortUrl(shortenUrlRequestDto));
    }

    @GetMapping("/{shortcode}")
    public ResponseEntity<ShortenUrlResponseDto> retrieveUrl (@PathVariable String shortcode)
    {
        ShortenUrlResponseDto shortenUrlResponseDto = urlShortenerService.retrieveUrl(shortcode);
        if (shortenUrlResponseDto!=null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(shortenUrlResponseDto);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
