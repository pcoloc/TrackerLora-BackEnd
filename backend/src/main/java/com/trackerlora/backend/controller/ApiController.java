package com.trackerlora.backend.controller;

import com.trackerlora.backend.entity.Api;
import com.trackerlora.backend.repository.ApiRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApiController {

        @Autowired
        private ApiRepository apiRepository;

        @GetMapping("/{uuid}")
        public ResponseEntity<Api> getApi(@PathVariable("uuid") String uuid) {
            Api api = apiRepository.findByUuid(uuid);
            return new ResponseEntity<Api>(api, HttpStatus.OK);
        }

        @GetMapping("/all")
        public ResponseEntity<List<Api>> getAllApis() {
            List<Api> apis = apiRepository.findAll();
            return new ResponseEntity<List<Api>>(apis, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<Api> addApi(@RequestBody Api api) {
            Api newApi = apiRepository.save(api);
            return new ResponseEntity<Api>(newApi, HttpStatus.OK);
        }

        @PutMapping("/update")
        public ResponseEntity<Api> updateApi(@RequestBody Api api) {
            Api updatedApi = apiRepository.save(api);
            return new ResponseEntity<Api>(updatedApi, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{uuid}")
        public ResponseEntity<String> deleteApi(@PathVariable("uuid") String uuid) {
            apiRepository.deleteByUuid(uuid);
            return new ResponseEntity<String>("Api deleted", HttpStatus.OK);
        }


}
