package com.trackerlora.backend.controller;

import com.trackerlora.backend.entity.Client;
import com.trackerlora.backend.entity.Location;
import com.trackerlora.backend.repository.ClientRepository;

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

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = {"https://trackerlora.lopezcarrillo.com", "http://localhost:4200"})
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;
    Logger logger = org.slf4j.LoggerFactory.getLogger(ClientController.class);

        @GetMapping("/{uuid}")
        public ResponseEntity<Client> getClient(@PathVariable("uuid") String uuid) {
            Client client = clientRepository.findByUuid(uuid);
            logger.warn("client: " + client);
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        }

        @GetMapping("/all")
        public ResponseEntity<List<Client>> getAllClients() {
            List<Client> clients = clientRepository.findAll();
            return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<Client> addClient(@RequestBody Client client) {
            Client newClient = clientRepository.save(client);
            return new ResponseEntity<Client>(newClient, HttpStatus.OK);
        }

        @PutMapping("/update")
        public ResponseEntity<Client> updateClient(@RequestBody Client client) {
            Client updatedClient = clientRepository.save(client);
            return new ResponseEntity<Client>(updatedClient, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{uuid}")
        public ResponseEntity<String> deleteClient(@PathVariable("uuid") String uuid) {
            clientRepository.deleteByUuid(uuid);
            return new ResponseEntity<String>("Client deleted", HttpStatus.OK);
        }

        @GetMapping("/nodes")
        public ResponseEntity<List<Client>> getAllNodes() {
            List<Client> clients = clientRepository.findByisRouter(false);
            return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
        }

        @GetMapping("/routers")
        public ResponseEntity<List<Client>> getAllRouters() {
            List<Client> clients = clientRepository.findByisRouter(true);
            return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
        }

        @GetMapping("/routers/count")
        public ResponseEntity<Integer> getRoutersCount() {
            ResponseEntity<List<Client>> router = getAllRouters();
            Integer count = router.getBody().size();
            return new ResponseEntity<Integer>(count, HttpStatus.OK);
        }

        @GetMapping("/nodes/count")
        public ResponseEntity<Integer> getNodesCount() {
            ResponseEntity<List<Client>> nodes = getAllNodes();
            Integer count = nodes.getBody().size();
            return new ResponseEntity<Integer>(count, HttpStatus.OK);
        }

        //Get last location registered sorted by date of a client by uuid
        @GetMapping("/location/{uuid}")
        public ResponseEntity<Location> getLastLocation(@PathVariable("uuid") String uuid) {
            Client client = clientRepository.findByUuid(uuid);
            Location location = client.getLastLocation();
            return new ResponseEntity<Location>(location, HttpStatus.OK);
        }







}
