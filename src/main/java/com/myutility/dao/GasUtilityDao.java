package com.myutility.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myutility.model.GasUtility;

public interface GasUtilityDao extends JpaRepository<GasUtility, Long> {

}
