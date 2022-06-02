package com.trackerlora.backend.controller;

import com.trackerlora.backend.entity.Client;
import com.trackerlora.backend.repository.ClientRepository;

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
@RequestMapping("/client")
@CrossOrigin(origins = "https://trackerlora.lopezcarrillo.com")
public class ClientController {

        @Autowired
        private ClientRepository clientRepository;

        @GetMapping("/{uuid}")
        public ResponseEntity<Client> getClient(@PathVariable("uuid") String uuid) {
            Client client = clientRepository.findByUuid(uuid);
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

}
