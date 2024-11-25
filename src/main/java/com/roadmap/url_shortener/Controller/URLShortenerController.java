package com.roadmap.url_shortener.Controller;


import com.roadmap.url_shortener.Dto.*;
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

    @PutMapping("{shortcode}")
    public ResponseEntity<UpdateUrlResponseDto> updateUrl (@PathVariable String shortcode, @RequestBody UpdateUrlRequestDto updateUrlRequestDto)
    {
        UpdateUrlResponseDto updateUrlResponseDto = urlShortenerService.updateUrl(shortcode,updateUrlRequestDto);
        if (updateUrlRequestDto!=null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(updateUrlResponseDto);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("{shortcode}")
    public ResponseEntity<String> deleteUrl (@PathVariable String shortcode)
    {
        if(urlShortenerService.deleteUrl(shortcode))
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
    }

    @GetMapping("{shortcode}/stats")
    public ResponseEntity<StatsResponseDto> getStats(@PathVariable String shortcode)
    {
        StatsResponseDto statsResponseDto = urlShortenerService.getStats(shortcode);
        if (statsResponseDto!=null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(statsResponseDto);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
