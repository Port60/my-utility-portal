package com.myutility.model;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.Data;

@Data
@MappedSuperclass
public class Item {

  @Version
  private Integer version;

  private Date created;

  private String createdByUser;

  private Date lastModified;

  private String lastUpdatedByUser;

}
