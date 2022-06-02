package com.trackerlora.backend.repository;

import com.trackerlora.backend.entity.Client;
import com.trackerlora.backend.repository.ClientRepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin(origins = "https://trackerlora.lopezcarrillo.com")
public interface ClientRepository extends CrudRepository<Client, String> {

        Client findByUuid(@Param("uuid") String uuid);
        List<Client> findAll();
        Client deleteByUuid(@Param("uuid") String uuid);
}
