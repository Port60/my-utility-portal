package com.myutility.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myutility.model.Client;
import com.myutility.model.ClientSite;
import com.myutility.model.ElectricUtility;
import com.myutility.model.Supplier;
import com.myutility.model.UtilitySupplier;
import com.myutility.model.UtilityType;
import com.myutility.model.enums.UtilityTypeEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilitySupplierDaoTest {

  @Autowired
  private UtilitySupplierDao utilitySupplierDao;

  @Autowired
  private SupplierDao supplierDao;

  @Autowired
  private ElectricUtilityDao electricUtilityDao;

  @Autowired
  private ClientDao clientDao;

  @Autowired
  private ClientSiteDao clientSiteDao;

  @Autowired
  private UtilityTypeDao utilityTypeDao;

  @Before
  public void setUp() throws Exception {}

  @Test
  @Transactional
  public void test() {

    Client client = clientDao.save(buildClient());
    ClientSite clientSite = clientSiteDao.save(buildClientSite(client));
    ElectricUtility utility = buildElectricUtility();

    utility.setClientSite(clientSite);
    Optional<UtilityType> utilityType = utilityTypeDao.findById(UtilityTypeEnum.GAS.getId());

    utility.setUtilityType(utilityType.get());

    electricUtilityDao.save(utility);

    Supplier supplier = buildSupplier();
    supplierDao.save(supplier);

    UtilitySupplier utilitySupplier = new UtilitySupplier();
    utilitySupplier.setSupplier(supplier);
    utilitySupplier.setUtility(utility);

    utilitySupplier.setCreatedByUser("test");
    utilitySupplier.setCreated(new Date());
    utilitySupplier.setLastUpdatedByUser("test");
    utilitySupplier.setLastModified(new Date());

    utilitySupplierDao.save(utilitySupplier);

    assertThat(utilitySupplier.getId(), is(notNullValue()));
  }

  private Supplier buildSupplier() {
    Supplier supplier = new Supplier();
    supplier.setSupplierName("test-supplier-sse");
    supplier.setCreatedByUser("test");
    supplier.setCreated(new Date());
    supplier.setLastUpdatedByUser("test");
    supplier.setLastModified(new Date());
    return supplier;
  }

  private ElectricUtility buildElectricUtility() {
    ElectricUtility utility = new ElectricUtility();
    utility.setMpan("1234567890123");
    utility.setLinelossFactor("334");
    utility.setProfileType("04");
    utility.setCode("012");

    utility.setDayRateKwh(new BigDecimal("11.2"));
    utility.setStandingCharge(new BigDecimal("13.8"));
    utility.setUsage(new BigDecimal("132.2"));
    utility.setAutomaticReading(true);

    utility.setCreatedByUser("test");
    utility.setCreated(new Date());
    utility.setLastUpdatedByUser("test");
    utility.setLastModified(new Date());
    return utility;
  }

  private ClientSite buildClientSite(Client client) {
    ClientSite clientSite = new ClientSite();
    clientSite.setClient(client);
    clientSite.setPostcode("B97 4EE");
    clientSite.setAddressLine1("1 test road");
    clientSite.setAddressLine2("test town");
    clientSite.setAddressLine3("test county");
    clientSite.setAddressLine4("spare field");
    clientSite.setCreatedByUser("test");
    clientSite.setCreated(new Date());
    clientSite.setLastUpdatedByUser("test");
    clientSite.setLastModified(new Date());
    return clientSite;
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
