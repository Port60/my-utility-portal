package com.myutility.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myutility.model.Supplier;

public interface SupplierDao extends JpaRepository<Supplier, Long> {

}
