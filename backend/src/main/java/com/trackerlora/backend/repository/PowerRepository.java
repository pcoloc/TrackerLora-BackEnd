package com.trackerlora.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.trackerlora.backend.entity.Power;

@CrossOrigin(origins = {"https://tracker.lopezcarrillo.com", "http://localhost:80"})
public interface PowerRepository extends CrudRepository<Power, String> {

    Power findById(Integer id);

}
