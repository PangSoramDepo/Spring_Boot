package com.example.first_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import com.example.first_project.model.Alien;

public interface AlienRepo extends JpaRepository<Alien,Integer>{
    
    // This method for find by Aname(property of class Alien)
    // Syntax findby + property_name
    // with argument
    List<Alien> findByAname(String aname);

    List<Alien> findByAidGreaterThan(int aid);

    // This is how to want to use raw query
    @Query("from Alien where aname=?1 order by aname")
    List<Alien> findByAnameSorted(String aname);
}
