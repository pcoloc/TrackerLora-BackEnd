package com.trackerlora.backend.repository;

import com.trackerlora.backend.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = " ", allowedHeaders = " ")
public interface UserRepository extends CrudRepository<User, String>{
     /**
  @Query("select u from user u where u.name")
  user findByName(String name);
  */
  List<User> findByFirstName(@Param("firstName") String firstName);
  List<User> findAll();
  User findUserByUsername(@Param("userName") String userName);

  User findUserByUuid(@Param("uuid") String uuid);


  void deleteByUuid(String uuid);

}
