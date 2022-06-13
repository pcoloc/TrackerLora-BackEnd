package com.trackerlora.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.trackerlora.backend.entity.TtnMapper;


@CrossOrigin(origins = {"https://trackerlora.lopezcarrillo.com", "http://localhost:4200"})
@RepositoryRestResource
public interface TtnMapperRepository extends CrudRepository<TtnMapper, String> {

    List<TtnMapper> findAll();
    TtnMapper findTtnMapperById(@Param("id") String id);
   void deleteById(Integer id);

}
