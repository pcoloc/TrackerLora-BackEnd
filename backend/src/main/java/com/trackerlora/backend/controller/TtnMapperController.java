package com.trackerlora.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trackerlora.backend.entity.TtnMapper;
import com.trackerlora.backend.repository.TtnMapperRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/ttnMapper")
@CrossOrigin(origins = {"https://trackerlora.lopezcarrillo.com", "http://localhost:4200"})
public class TtnMapperController {

    @Autowired
    private TtnMapperRepository ttnMapperRepository;

    @GetMapping("/all")
    public ResponseEntity<List<TtnMapper>> getAllTtnMappers() {
        List<TtnMapper> ttnMappers = ttnMapperRepository.findAll();
        return new ResponseEntity<List<TtnMapper>>(ttnMappers, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TtnMapper> addTtnMapper(@RequestBody TtnMapper ttnMapper) {
        TtnMapper newTtnMapper = ttnMapperRepository.save(ttnMapper);
        return new ResponseEntity<TtnMapper>(newTtnMapper, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<TtnMapper> updateTtnMapper(@RequestBody TtnMapper ttnMapper) {
        TtnMapper updatedTtnMapper = ttnMapperRepository.save(ttnMapper);
        return new ResponseEntity<TtnMapper>(updatedTtnMapper, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity<String> deleteTtnMapper(@PathVariable("index") Integer index) {
        ttnMapperRepository.deleteByIndex(index);
        return new ResponseEntity<String>("TtnMapper deleted", HttpStatus.OK);
    }

}
