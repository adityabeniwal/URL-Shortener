package com.roadmap.url_shortener.Model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLrepo extends JpaRepository<URLEntity,Integer>
{
    public URLEntity findById(int id);

    public URLEntity findByshortcode(String shortCode);



}
