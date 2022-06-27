package com.trackerlora.backend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trackerlora.backend.entity.Gateways;
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
            logger.warn("ttnMapperData: " + ttnMapperData);
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

        @RequestMapping(value = "/greeting", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
        @ResponseBody
        public String greetingJson(HttpEntity<String> httpEntity) {
            String json = httpEntity.getBody();
            // json contains the plain json string
            logger.warn("json: " + json);
            return json;
        }

        @GetMapping("/cleaned")
        public List<Map<String, Object>> getCleanedTtnMapperData() {
            List<TtnMapperData> ttnMapperData = ttnMapperDataRepository.findAll();
            List<Map<String, Object>> cleanedTtnMapperData = new ArrayList<Map<String,Object>>();


            for(TtnMapperData ttnMapperDataItem : ttnMapperData) {
                int index = 1;
                Map<String, Object> map =  new HashMap<>();
                for(Gateways gateway : ttnMapperDataItem.getGateways()) {
                    map.put("Gateway-"+ index , gateway.getGtw_id() != null ? gateway.getGtw_id() : "Unknown Gateway");
                    map.put("RSSI-"+ index, (Double) gateway.getRssi() != null ? gateway.getRssi() : -10000 );
                    map.put("SNR-"+ index, (Double) gateway.getSnr() != null ? gateway.getSnr() : -10000 );
                    map.put("Latitude-"+ index, gateway.getLatitude() != null ? gateway.getLatitude() : -10000);
                    map.put("Longitude-"+ index, gateway.getLongitude() != null ?gateway.getLongitude() : -10000);
                    map.put("Metros-"+ index, ttnMapperDataItem.getDistance(gateway.getLatitude(), gateway.getLongitude()));
                    index++;
                }
                map.put("Cliente", ttnMapperDataItem.getDev_id() != null ? ttnMapperDataItem.getDev_id() : "Unknown Device");
                map.put("SF", ttnMapperDataItem.getSpreading_factor() != null ? ttnMapperDataItem.getSpreading_factor() : -10000);
                map.put("Latitud", ttnMapperDataItem.getLatitude() != null ?  ttnMapperDataItem.getLatitude() : -10000);
                map.put("Longitud", ttnMapperDataItem.getLongitude() != null ? ttnMapperDataItem.getLongitude() : -10000);
                map.put("Potencia", 14);
                //map.put("metros", ttnMapperDataItem.getDistance());
                cleanedTtnMapperData.add(map);
            }
            return cleanedTtnMapperData;
        }
}
