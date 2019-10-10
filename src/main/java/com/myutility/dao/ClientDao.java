package com.myutility.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myutility.model.Client;

public interface ClientDao extends JpaRepository<Client, Long> {

}
