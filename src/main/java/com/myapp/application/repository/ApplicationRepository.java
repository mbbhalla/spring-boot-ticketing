package com.myapp.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myapp.application.entity.Application;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long> {

}
