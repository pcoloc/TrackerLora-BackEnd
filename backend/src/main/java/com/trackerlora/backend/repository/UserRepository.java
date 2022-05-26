package com.trackerlora.backend.repository;

import com.trackerlora.backend.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long>{
     /**
  @Query("select u from User u where u.name")
  User findByName(String name);
  */
  List<User> findByName(@Param("name") String name);

    List<User> findAll();

   void deleteById(Long id);

   User save(User user);
}
