package com.myutility.dao;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import com.myutility.model.Client;
import com.myutility.model.ClientSite;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientSiteDaoTest {

  @Autowired
  private ClientSiteDao clientSiteDao;

  @Autowired
  private ClientDao clientDao;

  @Before
  public void setUp() throws Exception {}

  @Test
  @Transactional
  public void testSaveCLientSite_successfull() {
    ClientSite clientSite = new ClientSite();
    Client client = clientDao.save(buildClient());
    clientSite.setClient(client);
    clientSite.setPostcode("B97 4EE");
    clientSite.setAddressLine1("1 test road");
    clientSite.setAddressLine2("test town");
    clientSite.setAddressLine3("test county");
    clientSite.setAddressLine4("spare field");

    clientSiteDao.save(clientSite);

    assertThat(clientSite.getId(), notNullValue());
    assertThat(clientSite.getClient().getId(), notNullValue());
  }

  @Test(expected = DataIntegrityViolationException.class)
  public void testSaveCLientSite_withoutclient_unsuccessfull() {
    ClientSite clientSite = new ClientSite();

    clientSite.setPostcode("B97 4EE");
    clientSite.setAddressLine1("1 test road");
    clientSite.setAddressLine2("test town");
    clientSite.setAddressLine3("test county");
    clientSite.setAddressLine4("spare field");

    clientSiteDao.save(clientSite);
  }



  private Client buildClient() {
    Client client = new Client();
    client.setOrgName("mu test org");
    client.setOrgRegistrationNumber("080834322524");
    client.setCreatedByUser("test");
    client.setCreated(new Date());
    client.setLastUpdatedByUser("test");
    client.setLastModified(new Date());

    return client;
  }

}
