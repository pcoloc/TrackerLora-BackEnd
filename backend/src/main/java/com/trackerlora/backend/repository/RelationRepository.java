package com.trackerlora.backend.repository;


import com.trackerlora.backend.entity.Relation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "https://trackerlora.lopezcarrillo.com")
public interface RelationRepository extends CrudRepository<Relation, String> {

        List<Relation> findAll();
        Relation deleteByUuid(@Param("uuid") String uuid);
        Relation findByUuid(@Param("uuid") String uuid);



}
