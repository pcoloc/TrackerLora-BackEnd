package com.trackerlora.backend.controller;

import java.util.List;

import org.slf4j.Logger;
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

import com.trackerlora.backend.entity.TtnMapperData;
import com.trackerlora.backend.repository.TtnMapperDataRepository;


@RestController
@RequestMapping("/ttnMapperData")
@CrossOrigin(origins = {"https://trackerlora.lopezcarrillo.com", "http://localhost:4200"})
public class TtnMapperDataController {

    @Autowired
    private TtnMapperDataRepository ttnMapperDataRepository;
    Logger logger = org.slf4j.LoggerFactory.getLogger(TtnMapperDataController.class);

        @GetMapping("/{id}")
        public ResponseEntity<TtnMapperData> getTtnMapperData(@PathVariable("id") Integer id) {
            TtnMapperData ttnMapperData = ttnMapperDataRepository.findById(id);
            logger.warn("ttnMapperData: " + ttnMapperData);
            return new ResponseEntity<TtnMapperData>(ttnMapperData, HttpStatus.OK);
        }

        @GetMapping("/all")
        public ResponseEntity<List<TtnMapperData>> getAllTtnMapperData() {
            List<TtnMapperData> ttnMapperData = ttnMapperDataRepository.findAll();
            return new ResponseEntity<List<TtnMapperData>>(ttnMapperData, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<TtnMapperData> addTtnMapperData(@RequestBody TtnMapperData ttnMapperData) {
            TtnMapperData newTtnMapperData = ttnMapperDataRepository.save(ttnMapperData);
            return new ResponseEntity<TtnMapperData>(newTtnMapperData, HttpStatus.OK);
        }

        @PutMapping("/update")
        public ResponseEntity<TtnMapperData> updateTtnMapperData(@RequestBody TtnMapperData ttnMapperData) {
            TtnMapperData updatedTtnMapperData = ttnMapperDataRepository.save(ttnMapperData);
            return new ResponseEntity<TtnMapperData>(updatedTtnMapperData, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<TtnMapperData> deleteTtnMapperData(@PathVariable("id") Integer id) {
            ttnMapperDataRepository.deleteById(id);
            return new ResponseEntity<TtnMapperData>(HttpStatus.OK);
        }


}
