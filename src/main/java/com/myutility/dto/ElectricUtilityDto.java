package com.myutility.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ElectricUtilityDto {

  private Long clientSiteId;

  private String mpan;

  private String profileType;

  private String code;

  private String linelossFactor;

  private BigDecimal dayRateKwh;

  private BigDecimal nightRateKWh;

  private BigDecimal standingCharge;

  private BigDecimal usage;

  private Boolean automaticReading;

}
