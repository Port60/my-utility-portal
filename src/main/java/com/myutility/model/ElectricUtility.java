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
@Table(name = "ELECTRIC_UTILITY")
public class ElectricUtility extends Utility {

  @Column(name = "MPAN")
  private String mpan;

  @Column(name = "PROFILE_CLASS")
  private String profileType;

  @Column(name = "METER_TIME_CODE")
  private String code;

  @Column(name = "LINE_LOSS_FACTOR")
  private String linelossFactor;

  @Column(name = "DAY_RATE_KWH", nullable = false)
  private BigDecimal dayRateKwh;

  @Column(name = "NIGHT_RATE_KWH")
  private BigDecimal nightRateKWh;

}
