package com.trackerlora.backend.repository;

import com.trackerlora.backend.entity.Monitor;
import com.trackerlora.backend.repository.MonitorRepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface MonitorRepository extends CrudRepository<Monitor, String> {

        List<Monitor> findAll();
        Monitor deleteByUuid(@Param("uuid") String uuid);
        Monitor findByUuid(@Param("uuid") String uuid);

}
