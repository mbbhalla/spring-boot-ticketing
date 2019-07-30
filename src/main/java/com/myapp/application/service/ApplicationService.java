package com.myapp.application.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.application.entity.Application;
import com.myapp.application.repository.ApplicationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ApplicationService {

    private ApplicationRepository applicationRepository;
    
    public List<Application> listApplications() {
        
        return StreamSupport.stream(this.applicationRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }
    
    public Optional<Application> getApplicationById(
        final Long id) {
        
        return this.applicationRepository.findById(id);
    }
}
