package com.trackerlora.backend.controller;

import com.trackerlora.backend.entity.Monitor;
import com.trackerlora.backend.repository.MonitorRepository;
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
@CrossOrigin(origins = "https://trackerlora2.lopezcarrillo.com")
@RequestMapping("/monitor")
public class MonitorController {

    @Autowired
    private MonitorRepository monitorRepository;

    @GetMapping("/{uuid}")
    public ResponseEntity<Monitor> getMonitor(@PathVariable("uuid") String uuid) {
        Monitor monitor = monitorRepository.findByUuid(uuid);
        return new ResponseEntity<Monitor>(monitor, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Monitor>> getAllMonitors() {
        List<Monitor> monitors = monitorRepository.findAll();
        return new ResponseEntity<List<Monitor>>(monitors, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Monitor> addMonitor(@RequestBody Monitor monitor) {
        Monitor newMonitor = monitorRepository.save(monitor);
        return new ResponseEntity<Monitor>(newMonitor, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Monitor> updateMonitor(@RequestBody Monitor monitor) {
        Monitor updatedMonitor = monitorRepository.save(monitor);
        return new ResponseEntity<Monitor>(updatedMonitor, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<String> deleteMonitor(@PathVariable("uuid") String uuid) {
        monitorRepository.deleteByUuid(uuid);
        return new ResponseEntity<String>("Monitor deleted", HttpStatus.OK);
    }

}
