package com.myutility.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class GasUtilityDto {


  private Long clientSiteId;

  private BigDecimal standingCharge;

  private BigDecimal usage;

  private Boolean automaticReading;

  private String mprn;

  private BigDecimal dayRateKwh;

}
