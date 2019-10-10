package com.myutility.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myutility.model.ClientSite;

public interface ClientSiteDao extends JpaRepository<ClientSite, Long> {

}
