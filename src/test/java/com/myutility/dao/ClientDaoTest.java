package com.myutility.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myutility.model.Client;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientDaoTest {

  @Autowired
  private ClientDao clientDao;

  @Before
  public void setUp() throws Exception {}

  @Test
  @Transactional
  public void testSaveclient_save_successfull() {
    Client client = new Client();
    client.setOrgName("mu test org");
    client.setOrgRegistrationNumber("080834322524");
    client.setCreatedByUser("test");
    client.setCreated(new Date());
    client.setLastUpdatedByUser("test");
    client.setLastModified(new Date());
    clientDao.save(client);
    assertNotNull(client.getId());
  }

}
