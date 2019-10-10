package com.myutility.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myutility.dao.UtilityTypeDao;
import com.myutility.model.UtilityType;

@Service
public class UtilityTypeService {


  private UtilityTypeDao utilityTypeDao;

  public UtilityTypeService(UtilityTypeDao utilityTypeDao) {
    this.utilityTypeDao = utilityTypeDao;
  }


  public UtilityType findById(Long id) {
    return utilityTypeDao.findById(id).get();
  }

  public List<UtilityType> findall(Long id) {
    return utilityTypeDao.findAll();
  }

}
