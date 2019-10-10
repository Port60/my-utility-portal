package com.myutility.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "UTILITY")
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "seq", sequenceName = "UTILITY_SEQ", allocationSize = 1)
public class Utility extends Item {


  @Id
  @GeneratedValue(generator = "seq")
  private Long id;


  @Column(name = "STANDING_CHARGE", nullable = false)
  private BigDecimal standingCharge;

  @Column(name = "USAGE", nullable = false)
  private BigDecimal usage;

  @Column(name = "ATOMATIC_READING")
  private Boolean automaticReading;

  @ManyToOne
  @JoinColumn(name = "CLIENT_SITE_ID", nullable = false)
  private ClientSite clientSite;

  @ManyToOne
  @JoinColumn(name = "UTILITY_TYPE_ID", nullable = false)
  private UtilityType utilityType;

}
