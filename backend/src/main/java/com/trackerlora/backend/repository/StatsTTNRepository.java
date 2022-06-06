package com.trackerlora.backend.repository;

import com.trackerlora.backend.entity.StatsTTN;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "https://trackerlora2.lopezcarrillo.com")
@RepositoryRestResource
public interface StatsTTNRepository extends CrudRepository<StatsTTN, String>  {

        List<StatsTTN> findAll();
        StatsTTN deleteByUuid(@Param("uuid") String uuid);
        StatsTTN findByUuid(@Param("uuid") String uuid);
        List<StatsTTN> findByClientId(String clientId);

}

