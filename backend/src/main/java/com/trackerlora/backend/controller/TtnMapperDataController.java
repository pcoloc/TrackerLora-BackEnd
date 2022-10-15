package com.trackerlora.backend.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.trackerlora.backend.entity.Gateways;
import com.trackerlora.backend.entity.TtnMapperData;
import com.trackerlora.backend.repository.TtnMapperDataRepository;
import com.trackerlora.backend.service.CsvExportService;

import java.io.Writer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;


@RestController
@RequestMapping("/ttnMapperData")
@CrossOrigin(origins = {"https://tracker.lopezcarrillo.com", "http://localhost:4200"})
public class TtnMapperDataController {

    @Autowired
    private TtnMapperDataRepository ttnMapperDataRepository;
    Logger logger = org.slf4j.LoggerFactory.getLogger(TtnMapperDataController.class);
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(CsvExportService.class);

        // Create your bot passing the token received from @BotFather
        TelegramBot bot = new TelegramBot("429373973:AAGFbX5A6cZoxGfiykLwdIQw7TzA3HEnT2M");




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
            System.out.println("------------- Adding data --------------");
            System.out.println("data accuracy is: " + ttnMapperData.getAccuracy_meters());
            System.out.println("-----------------------------------------");
            // Send messages
            if(ttnMapperData.getAccuracy_meters() <= 50){
            Gateways router = ttnMapperData.getGateways().get(0);
            ttnMapperData.setPotencia(7);
            List<Gateways> gateways = new ArrayList<Gateways>();
            for(Gateways gateway : ttnMapperData.getGateways()) {
                gateway.setMetros(ttnMapperData.getDistance(gateway.getLatitude(), gateway.getLongitude()));
                gateways.add(gateway);
            }
            ttnMapperData.setGateways(gateways);
            ttnMapperData.setMetros(ttnMapperData.getDistance(router.getLatitude(), router.getLongitude()));
            TtnMapperData newTtnMapperData = ttnMapperDataRepository.save(ttnMapperData);
            System.out.println("--------- Added data ---------------");
            return new ResponseEntity<TtnMapperData>(newTtnMapperData, HttpStatus.OK);
            }
            System.out.println("--------- Not Added data ---------------");
            String mensaje = "Malas noticias, ¡No se ha añadido nada porque la precisión era de" + ttnMapperData.getAccuracy_meters() + " metros!";
            bot.execute(new SendMessage(11051100, mensaje));
            return new ResponseEntity<TtnMapperData>(ttnMapperData, HttpStatus.OK);
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
                Integer index = 1;
                Map<String, Object> map =  new HashMap<>();
                for(Gateways gateway : ttnMapperDataItem.getGateways()) {
                    Map<String, Object> gatewayMap = new HashMap<>();
                    gatewayMap.put("name" , gateway.getGtw_id() != null ? gateway.getGtw_id() : "Unknown Gateway");
                    gatewayMap.put("rssi", (Double) gateway.getRssi() != null ? gateway.getRssi() : -10000 );
                    gatewayMap.put("snr", (Double) gateway.getSnr() != null ? gateway.getSnr() : -10000 );
                    gatewayMap.put("latitud", gateway.getLatitude() != null ? gateway.getLatitude() : -10000);
                    gatewayMap.put("longitud", gateway.getLongitude() != null ?gateway.getLongitude() : -10000);
                    gatewayMap.put("metros", ttnMapperDataItem.getDistance(gateway.getLatitude(), gateway.getLongitude()));
                    map.put("gateway_"+index, gatewayMap);
                    index++;
                }
                map.put("cliente", ttnMapperDataItem.getDev_id() != null ? ttnMapperDataItem.getDev_id() : "Unknown Device");
                map.put("sf", ttnMapperDataItem.getSpreading_factor() != null ? ttnMapperDataItem.getSpreading_factor() : -10000);
                map.put("latitud", ttnMapperDataItem.getLatitude() != null ?  ttnMapperDataItem.getLatitude() : -10000);
                map.put("longitud", ttnMapperDataItem.getLongitude() != null ? ttnMapperDataItem.getLongitude() : -10000);
                cleanedTtnMapperData.add(map);

            }
            return cleanedTtnMapperData;
        }
        @GetMapping("/csv")
        public void getAlTtnMapperDataCsv(HttpServletResponse servletResponse) throws IOException {
            List<TtnMapperData> ttnMapperData = ttnMapperDataRepository.findAll();
            //CsvExportService csvExportService = new CsvExportService(ttnMapperDataRepository);
            servletResponse.setContentType("text/csv");
            servletResponse.addHeader("Content-Disposition","attachment; filename=\"ttnMapper_total.csv\"");
            Writer writer = servletResponse.getWriter();
            //csvExportService.writeEmployeesToCsv(servletResponse.getWriter());
            try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
                csvPrinter.printRecord("id", "rssi", "snr", "spreading_factor", "potencia", "metros"  );
                int counter = 1;
                for (TtnMapperData ttnMapperItem : ttnMapperData) {
                    for(Gateways gateway : ttnMapperItem.getGateways()) {
                    csvPrinter.printRecord(counter, gateway.getRssi(), gateway.getSnr(), ttnMapperItem.getSpreading_factor(), ttnMapperItem.getPotencia(), gateway.getDistance(ttnMapperItem.getLatitude(), ttnMapperItem.getLongitude()) );
                    counter ++;
                    }
                }
            } catch (IOException e) {
                log.error("Error While writing CSV ", e);
            }
        }

        @GetMapping("/mikrotik_csv")
        public void getAlTtnMapperDataMicrotikCsv(HttpServletResponse servletResponse) throws IOException {
            List<TtnMapperData> ttnMapperData = ttnMapperDataRepository.findAll();
            //CsvExportService csvExportService = new CsvExportService(ttnMapperDataRepository);
            servletResponse.setContentType("text/csv");
            servletResponse.addHeader("Content-Disposition","attachment; filename=\"ttnMapper_mikrotik.csv\"");
            Writer writer = servletResponse.getWriter();
            //csvExportService.writeEmployeesToCsv(servletResponse.getWriter());
            try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
                csvPrinter.printRecord("id", "rssi", "snr", "spreading_factor", "potencia", "metros"  );
                int counter = 1;
                for (TtnMapperData ttnMapperItem : ttnMapperData) {
                    for(Gateways gateway : ttnMapperItem.getGateways()) {
                    //si es el router Mikrotik
                        if(gateway.getGtw_id().equals("paco96routermikro")){
                            csvPrinter.printRecord(counter, gateway.getRssi(), gateway.getSnr(), ttnMapperItem.getSpreading_factor(), ttnMapperItem.getPotencia(), gateway.getDistance(ttnMapperItem.getLatitude(), ttnMapperItem.getLongitude()) );
                            counter ++;
                        }
                    }
                }
            } catch (IOException e) {
                log.error("Error While writing CSV ", e);
            }
        }

        @GetMapping("/dragino_csv")
        public void getAlTtnMapperDataDraginoCsv(HttpServletResponse servletResponse) throws IOException {
            List<TtnMapperData> ttnMapperData = ttnMapperDataRepository.findAll();
            //CsvExportService csvExportService = new CsvExportService(ttnMapperDataRepository);
            servletResponse.setContentType("text/csv");
            servletResponse.addHeader("Content-Disposition","attachment; filename=\"ttnMapper_dragino.csv\"");
            Writer writer = servletResponse.getWriter();
            //csvExportService.writeEmployeesToCsv(servletResponse.getWriter());
            try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
                csvPrinter.printRecord("id", "rssi", "snr", "spreading_factor", "potencia", "metros"  );
                int counter = 1;
                for (TtnMapperData ttnMapperItem : ttnMapperData) {
                    for(Gateways gateway : ttnMapperItem.getGateways()) {
                    //filtramos por el router de Dragino
                        if(gateway.getGtw_id().equals("dragino-pac")){
                            csvPrinter.printRecord(counter, gateway.getRssi(), gateway.getSnr(), ttnMapperItem.getSpreading_factor(), ttnMapperItem.getPotencia(), gateway.getDistance(ttnMapperItem.getLatitude(), ttnMapperItem.getLongitude()) );
                            counter ++;
                        }
                    }
                }
            } catch (IOException e) {
                log.error("Error While writing CSV ", e);
            }
        }
        //SELECT COUNT(*) FROM gateways
        @GetMapping("/total")
        public long getTotalRows(HttpEntity<String> httpEntity){
            return ttnMapperDataRepository.getAllGatewayRows();

        }
        //SELECT COUNT(*) FROM gateways WHERE gtw_id='dragino-pac'
        @GetMapping("/gw/{gw}")
        public long getTotalGwRows(@PathVariable("gw") String gw){
            List<TtnMapperData> ttnMapperData = ttnMapperDataRepository.findAll();
                int counter = 0;
                for (TtnMapperData ttnMapperItem : ttnMapperData) {
                    for(Gateways gateway : ttnMapperItem.getGateways()) {
                        if(gateway.getGtw_id().equals(gw)){
                            counter ++;
                        }
                    }
                }
                return counter;
        }
        //SELECT COUNT(*) FROM ttn_mapper_data WHERE spreading_factor=7
        @GetMapping("/sf/{sf}")
        public long getTotalSfRows(@PathVariable("sf") Integer sf){
            List<TtnMapperData> ttnMapperData = ttnMapperDataRepository.findAll();
                int counter = 0;
                for (TtnMapperData ttnMapperItem : ttnMapperData) {
                    for(int i = 0; i < ttnMapperItem.getGateways().size(); i++) {
                        if(ttnMapperItem.getSpreading_factor() == sf){
                            counter ++;
                        }
                    }
                }
                return counter;
        }
        //SELECT COUNT(*) FROM ttn_mapper_data WHERE potencia=7
        @GetMapping("/pw/{pw}")
        public long getTotalPwRows(@PathVariable("pw") Integer pw){
            List<TtnMapperData> ttnMapperData = ttnMapperDataRepository.findAll();
                int counter = 0;
                for (TtnMapperData ttnMapperItem : ttnMapperData) {
                    for(int i = 0; i < ttnMapperItem.getGateways().size(); i++) {
                        if(ttnMapperItem.getPotencia() == pw){
                            counter ++;
                        }
                    }
                }
                return counter;
        }
        //SELECT COUNT(*) FROM ttn_mapper_data WHERE spreading_factor=7 and potencia=14
        @GetMapping("/sfpw/{sf}/{pw}")
        public long getTotalSfPwRows(@PathVariable("sf") Integer sf, @PathVariable("pw") Integer pw){
            List<TtnMapperData> ttnMapperData = ttnMapperDataRepository.findAll();
                int counter = 0;
                for (TtnMapperData ttnMapperItem : ttnMapperData) {
                    for(int i = 0; i < ttnMapperItem.getGateways().size(); i++) {
                        if(ttnMapperItem.getPotencia() == pw && ttnMapperItem.getSpreading_factor() == sf){
                            counter ++;
                        }
                    }
                }
                return counter;
        }

        /**
         * @param gw
         * @param sf
         * @return counter of rows
         */
        @GetMapping("/gwsf/{gw}/{sf}")
        public long getTotalGatewaysSfRows(@PathVariable("gw") String gw, @PathVariable("sf") Integer sf){
            List<TtnMapperData> ttnMapperData = ttnMapperDataRepository.findAll();
                int counter = 0;
                for (TtnMapperData ttnMapperItem : ttnMapperData) {
                    for(Gateways gateway : ttnMapperItem.getGateways()) {
                    //si es el router Mikrotik
                        if(gateway.getGtw_id().equals(gw) && ttnMapperItem.getSpreading_factor() == sf){
                            counter ++;
                        }
                    }
                }
                return counter;
        }

        /**
         * @param gw
         * @param pw
         * @return counter of rows
         */
        @GetMapping("/gwpw/{gw}/{pw}")
        public long getTotalGatewaysPwRows(@PathVariable("gw") String gw, @PathVariable("pw") Integer pw){
            List<TtnMapperData> ttnMapperData = ttnMapperDataRepository.findAll();
                int counter = 0;
                for (TtnMapperData ttnMapperItem : ttnMapperData) {
                    for(Gateways gateway : ttnMapperItem.getGateways()) {
                    //si es el router Mikrotik
                        if(gateway.getGtw_id().equals(gw) && ttnMapperItem.getPotencia() == pw){
                            counter ++;
                        }
                    }
                }
                return counter;
        }

        @GetMapping("/testbot")
        public void pruebaBot(){
            bot.execute(new SendMessage(11051100, "¡Estoy vivo!"));

        }
}
