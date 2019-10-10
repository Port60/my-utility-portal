package com.myutility.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "UTILITY_SUPPLIER")
@SequenceGenerator(name = "seq", sequenceName = "UTILITY_SUPPLIER_SEQ", allocationSize = 1)
public class UtilitySupplier extends Item {

  @Id
  @GeneratedValue(generator = "seq")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "UTILITY_ID", nullable = false)
  private Utility utility;

  @ManyToOne
  @JoinColumn(name = "SUPPLIER_ID", nullable = false)
  private Supplier supplier;

  @Column(name = "START_DATE")
  private Date startDate;

  @Column(name = "END_DATE")
  private Date endDate;

  @Column(name = "DURATION")
  private Integer duration;

  @Column(name = "ACTIVE")
  private Boolean active;



}
