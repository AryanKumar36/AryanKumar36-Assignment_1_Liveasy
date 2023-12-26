package com.liveasy.loadDemo.service;

import com.liveasy.loadDemo.entity.Load;

import java.util.List;
import java.util.Optional;

public interface LoadService {
    List<Load> findAll();

    Optional<Load> findById(int theId);

    List<Load> findByShipperId(String shipperId);

    Load save(Load theLoad);

    void deleteById(int theId);


}
