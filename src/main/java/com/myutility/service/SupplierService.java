package com.myutility.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.myutility.dao.SupplierDao;
import com.myutility.model.Supplier;

@Service
public class SupplierService {

  private SupplierDao supplierDao;

  public SupplierService(SupplierDao supplierDao) {
    this.supplierDao = supplierDao;
  }

  @Transactional
  public Supplier saveSupplier(Supplier supplier) {
    return supplierDao.save(supplier);
  }


  public List<Supplier> getAllSuppliers() {
    return supplierDao.findAll();
  }

}
