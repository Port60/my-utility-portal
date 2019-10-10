package com.myutility.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.myutility.dao.ClientSiteDao;
import com.myutility.dao.ElectricUtilityDao;
import com.myutility.dao.GasUtilityDao;
import com.myutility.dao.SupplierDao;
import com.myutility.dao.UtilityTypeDao;
import com.myutility.dto.ElectricUtilityDto;
import com.myutility.dto.GasUtilityDto;
import com.myutility.model.ClientSite;
import com.myutility.model.ElectricUtility;
import com.myutility.model.GasUtility;
import com.myutility.model.UtilityType;
import com.myutility.model.enums.UtilityTypeEnum;

@Service
public class UtilityService {

  private GasUtilityDao gasUtilityDao;

  private ElectricUtilityDao electricUtilityDao;

  private SupplierDao supplierDao;

  private ClientSiteDao clientSiteDao;

  private UtilityTypeDao utilityTypeDao;

  public UtilityService(GasUtilityDao gasUtilityDao, ElectricUtilityDao electricUtilityDao,
      SupplierDao supplierDao, ClientSiteDao clientSiteDao, UtilityTypeDao utilityTypeDao) {
    this.gasUtilityDao = gasUtilityDao;
    this.electricUtilityDao = electricUtilityDao;
    this.supplierDao = supplierDao;
    this.clientSiteDao = clientSiteDao;
    this.utilityTypeDao = utilityTypeDao;
  }


  @Transactional
  public ElectricUtility addElectricUtilityforClientSite(ElectricUtilityDto electricUtilityDto) {

    ElectricUtility utility = new ElectricUtility();
    BeanUtils.copyProperties(electricUtilityDto, utility);
    Optional<ClientSite> clientSite = clientSiteDao.findById(electricUtilityDto.getClientSiteId());
    utility.setClientSite(clientSite.get());

    Optional<UtilityType> utilityType = utilityTypeDao.findById(UtilityTypeEnum.ELECTRIC.getId());
    utility.setUtilityType(utilityType.get());
    return electricUtilityDao.save(utility);
  }

  @Transactional
  public GasUtility addGasUtilityforClientSite(GasUtilityDto gasUtilityDto) {

    GasUtility utility = new GasUtility();
    BeanUtils.copyProperties(gasUtilityDto, utility);
    Optional<ClientSite> clientSite = clientSiteDao.findById(gasUtilityDto.getClientSiteId());
    utility.setClientSite(clientSite.get());

    Optional<UtilityType> utilityType = utilityTypeDao.findById(UtilityTypeEnum.ELECTRIC.getId());
    utility.setUtilityType(utilityType.get());
    return gasUtilityDao.save(utility);
  }

}
