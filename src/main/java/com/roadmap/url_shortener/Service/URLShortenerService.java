package com.roadmap.url_shortener.Service;


import com.roadmap.url_shortener.Dto.*;
import com.roadmap.url_shortener.Model.URLEntity;
import com.roadmap.url_shortener.Model.URLrepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

@Service
public class URLShortenerService
{
    private URLrepo urlRepo;

    private ModelMapper modelMapper;

    @Autowired
    public void URLShortenerService(URLrepo urlRepo,ModelMapper modelMapper)
    {
        this.urlRepo=urlRepo;
        this.modelMapper=modelMapper;
    }

    public ShortenUrlResponseDto createShortUrl(ShortenUrlRequestDto shortenUrlRequestDto)
    {
        URLEntity urlEntity = new URLEntity();
        urlEntity.setUrl(shortenUrlRequestDto.getUrl());
        String shortCode = generateRandom();
        while (urlRepo.findByshortcode(shortCode) != null)
        {
            shortCode=generateRandom();
        }
        urlEntity.setShortcode(shortCode);
        urlEntity.setAccessCount(0);
        urlEntity.setCreatedAt(LocalDateTime.now());
        urlEntity.setUpdatedAt(LocalDateTime.now());
        urlRepo.save(urlEntity);

        return modelMapper.map(urlEntity,ShortenUrlResponseDto.class);
    }

    public ShortenUrlResponseDto retrieveUrl(String shortcode)
    {
        URLEntity urlEntity = urlRepo.findByshortcode(shortcode);
        if(urlEntity!=null)
        {
            urlEntity.setAccessCount(urlEntity.getAccessCount()+1);
            urlRepo.save(urlEntity);
            return modelMapper.map(urlEntity,ShortenUrlResponseDto.class);
        }
        else
        {
            return null;
        }
    }

    public UpdateUrlResponseDto updateUrl (String shortcode, UpdateUrlRequestDto updateUrlRequestDto)
    {
        URLEntity urlEntity = urlRepo.findByshortcode(shortcode);
        if(urlEntity!=null)
        {
            urlEntity.setUrl(updateUrlRequestDto.getUrl());
            urlEntity.setUpdatedAt(LocalDateTime.now());
            urlRepo.save(urlEntity);
            return modelMapper.map(urlEntity,UpdateUrlResponseDto.class);
        }
        else
        {
            return null;
        }

    }

    public boolean deleteUrl (String shortcode)
    {

        URLEntity urlEntity = urlRepo.findByshortcode(shortcode);
        if(urlEntity!=null)
        {
            urlRepo.delete(urlEntity);
           return true;
        }
        else
        {
            return false;
        }
    }

    public StatsResponseDto getStats(String shortcode)
    {
        URLEntity urlEntity = urlRepo.findByshortcode(shortcode);
        if(urlEntity!=null)
        {
            return modelMapper.map(urlEntity,StatsResponseDto.class);
        }
        else
        {
            return null;
        }
    }

    private static String generateRandom() {
        String aToZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random rand=new Random();
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int randIndex=rand.nextInt(aToZ.length());
            res.append(aToZ.charAt(randIndex));
        }
        return res.toString();
    }



}
