package br.com.budega.service;

import br.com.budega.domain.client.Client;
import br.com.budega.domain.client.dto.RegisterClient;
import br.com.budega.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client addCliente(RegisterClient client) {
        Client newClient = new Client(client);
        return repository.save(newClient);
    }

    public Optional<Client> getClient(UUID id){
        return repository.findById(id);
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }




}
