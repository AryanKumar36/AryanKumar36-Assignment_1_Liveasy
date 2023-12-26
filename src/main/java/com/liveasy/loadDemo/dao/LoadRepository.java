package com.liveasy.loadDemo.dao;

import com.liveasy.loadDemo.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LoadRepository extends JpaRepository<Load, Integer> {
    List<Load> findByShipperId(String shipperId);
}