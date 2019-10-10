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

import com.myutility.model.Supplier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierDaoTest {

  @Autowired
  private SupplierDao supplierDao;

  @Before
  public void setUp() throws Exception {}

  @Test
  @Transactional
  public void testSavesupplier_save_successfull() {
    Supplier supplier = new Supplier();
    supplier.setSupplierName("SSE");
    supplier.setCreatedByUser("test");
    supplier.setCreated(new Date());
    supplier.setLastUpdatedByUser("test");
    supplier.setLastModified(new Date());
    supplierDao.save(supplier);
    assertNotNull(supplier.getId());
  }

}
