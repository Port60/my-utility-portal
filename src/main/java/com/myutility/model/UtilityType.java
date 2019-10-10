package com.myutility.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "UTILITY_TYPE")
@SequenceGenerator(name = "seq", sequenceName = "UTILITY_TYPE_SEQ", allocationSize = 1)
public class UtilityType {

  @Id
  @GeneratedValue(generator = "seq")
  private Long id;

  @Column(name = "UTILITY_NAME")
  private String utilityName;

}
