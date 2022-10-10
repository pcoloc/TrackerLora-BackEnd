package com.trackerlora.backend.repository;

import com.trackerlora.backend.entity.Shodan;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = {"https://tracker.lopezcarrillo.com", "http://localhost:4200"})
@RepositoryRestResource
public interface ShodanRepository extends CrudRepository<Shodan, String> {

        List<Shodan> findAll();
        Shodan deleteByUuid(@Param("uuid") String uuid);
        Shodan findByUuid(@Param("uuid") String uuid);

}


