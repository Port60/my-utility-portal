package com.myutility.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myutility.dao.ClientDao;
import com.myutility.model.Client;

@Service
public class ClientService {

  private ClientDao clientDao;

  public ClientService(ClientDao clientDao) {
    this.clientDao = clientDao;
  }

  public Client saveClient(Client client) {

    return clientDao.save(client);
  }

  public List<Client> getAllClients() {
    return clientDao.findAll();
  }

}
