package com.myutility.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "GAS_UTILITY")
public class GasUtility extends Utility {


  @Column(name = "MPRN", nullable = false)
  private String mprn;

  @Column(name = "DAY_RATE_KWH", nullable = false)
  private BigDecimal dayRateKwh;

}
