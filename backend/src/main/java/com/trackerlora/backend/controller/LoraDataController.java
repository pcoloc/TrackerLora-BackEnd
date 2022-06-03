package com.trackerlora.backend.controller;

import com.trackerlora.backend.dto.LoraData;
import com.trackerlora.backend.service.LoraDataService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// (1) Anotación de controlador REST.
@RestController
// (2) Anotación de mapeo de petición en la URL /lora.
@RequestMapping("/lora")
public class LoraDataController {

    @Autowired
    // (3) Inyección de dependencia de la clase LoraDataService.
    private LoraDataService loraDataService;

    // (4) Mapeo de petición GET a la URL /lora/data.
    @GetMapping("data")
    public ResponseEntity<LoraData> getLoraData() {
        // (5) Devuelve una lista de objetos LoraData con los datos del scraping realizados por el servicio.
        return new ResponseEntity<LoraData>(loraDataService.retrieveLoraData(),
            HttpStatus.OK);
    }

}
