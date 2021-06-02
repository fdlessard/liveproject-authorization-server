package io.fdlessard.liveproject.authorization.milestone5.controllers;

import io.fdlessard.liveproject.authorization.milestone5.domain.Client;
import io.fdlessard.liveproject.authorization.milestone5.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class ClientController {

    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> get() {
        return clientService.getAllClients();
    }

    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody Client client) {
        clientService.createClient(client);
    }

}
