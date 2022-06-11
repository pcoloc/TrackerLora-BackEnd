package com.trackerlora.backend.controller;

import java.time.ZonedDateTime;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.trackerlora.backend.entity.Client;
import com.trackerlora.backend.repository.ClientRepository;
import com.trackerlora.backend.repository.StatsTTNRepository;
import com.trackerlora.backend.entity.StatsTTN;

@RestController
@RequestMapping("/stats")
@CrossOrigin(origins = {"https://trackerlora.lopezcarrillo.com", "http://localhost:4200"})
public class StatsTTNController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private StatsTTNRepository statsTTNRepository;
    Logger logger = org.slf4j.LoggerFactory.getLogger(StatsTTNController.class);
    private String urlString = "https://eu1.cloud.thethings.network/api/v3/gs/gateways/";
    @Autowired
    private RestTemplate restTemplate;

    //with clientid and ApiKey this method return the stats of the client from TheThingsNetwork
    @CrossOrigin(origins = {"https://trackerlora.lopezcarrillo.com", "http://localhost:4200"})
    @GetMapping("/{clientId}")
    public StatsTTN getStats(@PathVariable("clientId") String clientId) {
        return statsTTNRepository.save(consumeAPI(clientId));
    }

    // Get Uplink Count from clientId
    @CrossOrigin(origins = {"https://trackerlora.lopezcarrillo.com", "http://localhost:4200"})
    @GetMapping("/uplinkCount/{clientId}")
    public int getUplinkCount(@PathVariable("clientId") String clientId) {
        return consumeAPI(clientId).getUplinkCount();
    }

    public StatsTTN consumeAPI(String clientId){
        Client client = clientRepository.findByUuid(clientId);
        logger.warn("client: " + client.toString());
        if(client.isRouter()){
        //resttemplate with bearer Token at header
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + client.getApiKey());
            HttpEntity<?> request = new HttpEntity<Object>(headers);
            logger.warn(client.getApiKey());
            String url = urlString + client.getTtnId() + "/connection/stats";
            ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.GET, request, String.class);

            if(response.getStatusCode() == HttpStatus.OK) {
                logger.warn(response.getBody().toString());
                StatsTTN statsTTN = new StatsTTN();
                try {
                    JSONObject jsonObject = new JSONObject(response.getBody());
                    statsTTN.setClientId(clientId);
                    Date connected_at = Date.from(ZonedDateTime.parse(jsonObject.getString("connected_at")).toInstant());
                    statsTTN.setConnectedAt(connected_at);
                    statsTTN.setDownlinkCount(jsonObject.getInt("downlink_count"));
                    Date last_downlink_received_at = Date.from(ZonedDateTime.parse(jsonObject.getString("last_downlink_received_at")).toInstant());
                    statsTTN.setLastDownlinkReceivedAt(last_downlink_received_at);
                    statsTTN.setProtocol(jsonObject.getString("protocol"));
                    statsTTN.setUplinkCount(jsonObject.getInt("uplink_count"));
                    Date last_uplink_received_at = Date.from(ZonedDateTime.parse(jsonObject.getString("last_uplink_received_at")).toInstant());
                    statsTTN.setLastUplinkReceivedAt(last_uplink_received_at);
                    logger.warn(jsonObject.toString());
            }catch (JSONException err){
                    logger.debug("Error", err.toString());
            }
                return statsTTN;
            } else {
                return null;
            }
        }
        return null;
    }


}
