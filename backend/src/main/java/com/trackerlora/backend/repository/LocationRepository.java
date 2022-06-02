package com.trackerlora.backend.repository;

import com.trackerlora.backend.entity.Location;
import com.trackerlora.backend.repository.LocationRepository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(exported = false)
public interface LocationRepository extends CrudRepository<Location, String> {

}
