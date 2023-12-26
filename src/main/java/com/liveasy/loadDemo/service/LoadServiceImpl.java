package com.liveasy.loadDemo.service;

import com.liveasy.loadDemo.dao.LoadRepository;
import com.liveasy.loadDemo.entity.Load;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LoadServiceImpl implements LoadService{

    private LoadRepository loadRepository;

    @Autowired
    public LoadServiceImpl(LoadRepository theLoadRepository)
    {
        loadRepository =theLoadRepository;
    }

    @Override
    public List<Load> findAll() {
        return loadRepository.findAll();

    }

    @Override
    public Optional<Load> findById(int theId) {
        return loadRepository.findById(theId);
    }

    @Override
    public List<Load> findByShipperId(String shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }

    @Override
    public Load save(Load theLoad) {
        return loadRepository.save(theLoad);
    }

    @Override
    public void deleteById(int theId) {
        loadRepository.deleteById(theId);
    }

}

