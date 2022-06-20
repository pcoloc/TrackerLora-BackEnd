package com.trackerlora.backend.repository;

import com.trackerlora.backend.entity.TtnMapperData;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = {"https://trackerlora.lopezcarrillo.com", "http://localhost:4200"})
public interface TtnMapperDataRepository extends CrudRepository<TtnMapperData, String> {

    TtnMapperData findById(Integer id);
    List<TtnMapperData> findAll();
    void deleteById(Integer id);
}
