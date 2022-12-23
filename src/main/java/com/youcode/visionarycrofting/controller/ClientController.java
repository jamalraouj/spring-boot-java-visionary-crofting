package com.youcode.visionarycrofting.controller;


import com.youcode.visionarycrofting.classes.Message;
import com.youcode.visionarycrofting.classes.PasserCommande;
import com.youcode.visionarycrofting.configspringsecurity.JwtUtils;
import com.youcode.visionarycrofting.entity.Client;
import com.youcode.visionarycrofting.entity.Command;
import com.youcode.visionarycrofting.entity.Role;
import com.youcode.visionarycrofting.service.ClientService;
import io.jsonwebtoken.impl.crypto.JwtSigner;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.Principal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = {"visionarycrofting/Client", "visionarycrofting/client"})
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = {"/Clients","/","","/all","/clients"})
    @ResponseBody
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/{client_id}")
    public Optional<Client> getOne(@PathVariable("client_id") Long clientId) {
        return clientService.getOneById(clientId);
    }
    @GetMapping(path = {"/me" ,"/profile","/my_profile" })
    public Optional<Client> getOne(Principal principal) {
        return clientService.getOneByEmail(principal.getName());
    }

    @PostMapping("/addClient")
    public Client registerNewClient(@RequestBody Client client) {
        client.setRole(Role.CLIENT);
        return clientService.addClient(client);
    }

    @DeleteMapping(path = "deleteClient/{clientId}")
    public Message deleteClient(@PathVariable("clientId") Long clientId) {
        return clientService.deleteClient(clientId);
    }

    @PutMapping(path = "/updateClient")
    public Client updateClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }


    @PostMapping("/passer_commande")
    @ResponseBody
    public Client passerCommande(@RequestBody Collection<PasserCommande> productList, Principal principal) throws IOException {
        Optional<Client> client = clientService.getOneByEmail(principal.getName());
        return clientService.passerCommande(productList, client.get());

    }

}
