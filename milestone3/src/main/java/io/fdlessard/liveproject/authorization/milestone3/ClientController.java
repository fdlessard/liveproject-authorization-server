package io.fdlessard.liveproject.authorization.milestone3;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class ClientController {

    private ClientService clientService;

    @GetMapping("/clients")
    public List<Clients> get() {
        return clientService.getAllClients();
    }

    @PostMapping("/client")
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody Clients clients) {
        clientService.createClient(clients);
    }

}
