package com.trackerlora.backend.repository;

import com.trackerlora.backend.entity.Client;
import com.trackerlora.backend.repository.ClientRepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = {"https://tracker.lopezcarrillo.com", "http://localhost:80"})
@RepositoryRestResource
public interface ClientRepository extends CrudRepository<Client, String> {

        Client findByUuid(@Param("uuid") String uuid);
        List<Client> findAll();
        Client deleteByUuid(@Param("uuid") String uuid);
        //find by router = false
        List<Client> findByisRouter(@Param("isRouter") boolean isRouter);
}
