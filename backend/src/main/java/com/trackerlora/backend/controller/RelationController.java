package com.trackerlora.backend.controller;

import com.trackerlora.backend.entity.Relation;
import com.trackerlora.backend.repository.RelationRepository;
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
@RequestMapping("/relation")
@CrossOrigin(origins = "https://trackerlora2.lopezcarrillo.com")
public class RelationController {

    @Autowired
    private RelationRepository relationRepository;

    @GetMapping("/{uuid}")
    public ResponseEntity<Relation> getRelation(@PathVariable("uuid") String uuid) {
        Relation relation = relationRepository.findByUuid(uuid);
        return new ResponseEntity<Relation>(relation, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Relation>> getAllRelations() {
        List<Relation> relations = relationRepository.findAll();
        return new ResponseEntity<List<Relation>>(relations, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Relation> addRelation(@RequestBody Relation relation) {
        Relation newRelation = relationRepository.save(relation);
        return new ResponseEntity<Relation>(newRelation, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Relation> updateRelation(@RequestBody Relation relation) {
        Relation updatedRelation = relationRepository.save(relation);
        return new ResponseEntity<Relation>(updatedRelation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<String> deleteRelation(@PathVariable("uuid") String uuid) {
        relationRepository.deleteByUuid(uuid);
        return new ResponseEntity<String>("Relation deleted", HttpStatus.OK);
    }



}
