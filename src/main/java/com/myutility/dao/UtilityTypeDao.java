package com.myutility.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myutility.model.UtilityType;

public interface UtilityTypeDao extends JpaRepository<UtilityType, Long> {

}
