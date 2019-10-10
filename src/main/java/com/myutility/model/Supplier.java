package com.myutility.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "SUPPLIER")
@SequenceGenerator(name = "seq", sequenceName = "SUPPLIER_SEQ", allocationSize = 1)
public class Supplier extends Item {

  @Id
  @GeneratedValue(generator = "seq")
  private Long id;

  @Column(name = "SUPPLIER_NAME")
  private String supplierName;


}
