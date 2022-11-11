package com.trackerlora.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trackerlora.backend.entity.Power;
import com.trackerlora.backend.repository.PowerRepository;

import io.swagger.v3.oas.annotations.Hidden;

import org.slf4j.Logger;

@Hidden
@RestController
@RequestMapping("/power")
@CrossOrigin(origins = {"https://tracker.lopezcarrillo.com", "http://localhost:80"})
public class PowerController {

    @Autowired
    private PowerRepository powerRepository;
    Logger logger = org.slf4j.LoggerFactory.getLogger(PowerController.class);

    @GetMapping("/{id}")
    public ResponseEntity<Power> getPower(@PathVariable("id") Integer id){
        Power power = powerRepository.findById(id);
        logger.warn("power: " + power);
        return new ResponseEntity<Power>(power, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Power> updatePower(@RequestBody Power power) {
        Power updatedPower = powerRepository.save(power);
        return new ResponseEntity<Power>(updatedPower, HttpStatus.OK);
    }
}
