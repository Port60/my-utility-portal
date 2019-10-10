package com.myutility.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.myutility.dao.ClientDao;
import com.myutility.dao.ClientSiteDao;
import com.myutility.dto.ClientSiteDto;
import com.myutility.model.Client;
import com.myutility.model.ClientSite;

@Service
public class ClientSiteService {

  private ClientSiteDao clientSiteDao;

  private ClientDao clientDao;

  public ClientSiteService(ClientSiteDao clientSiteDao) {
    this.clientSiteDao = clientSiteDao;
  }


  @Transactional
  public ClientSite saveCLientSite(ClientSiteDto clientSiteDto) {
    ClientSite clientSite = new ClientSite();
    BeanUtils.copyProperties(clientSiteDto, clientSite);
    Optional<Client> client = clientDao.findById(clientSiteDto.getClientId());
    clientSite.setClient(client.get());

    return clientSiteDao.save(clientSite);
  }

}
