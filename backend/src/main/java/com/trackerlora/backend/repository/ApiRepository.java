package com.trackerlora.backend.repository;

import com.trackerlora.backend.entity.Api;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "https://trackerlora.lopezcarrillo.com")
@RepositoryRestResource
public interface ApiRepository extends CrudRepository<Api, String> {


    List<Api> findByClientUuid(@Param("clientUuid") String clientUuid);
    List<Api> findByName(@Param("name") String name);
    Api findByUuid(@Param("uuid") String uuid);
    List<Api> findAll();
    Api deleteByUuid(@Param("uuid") String uuid);

}
