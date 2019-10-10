package com.myutility.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myutility.model.ElectricUtility;

public interface ElectricUtilityDao extends JpaRepository<ElectricUtility, Long> {

}
